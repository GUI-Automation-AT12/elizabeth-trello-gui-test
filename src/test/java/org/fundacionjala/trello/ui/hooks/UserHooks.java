package org.fundacionjala.trello.ui.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.ui.config.Context;
import org.fundacionjala.trello.ui.config.ReaderUserFile;
import org.fundacionjala.trello.ui.gui.pages.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.pages.BoardsPage;
import org.fundacionjala.trello.ui.gui.pages.ProfilePage;
import org.fundacionjala.trello.ui.gui.pages.TrelloLoginPage;
import org.fundacionjala.trello.ui.utils.PageTransporter;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserHooks {
    private AtlassianLoginPage atlassianLoginPage;
    private Context context;
    private ProfilePage profilePage;
    private TrelloLoginPage trelloLoginPage;
    private BoardsPage boardsPage;

    /**
     * Constructor.
     * @param sharedContext
     */
    public UserHooks(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Reset user' information.
     * @throws IOException
     * @throws ParseException
     */
    @After(value = "@resetUserInformation", order = 1)
    public void restoreUserProfile() throws IOException, ParseException {
        Map<String, String> userInformation = new HashMap<>();
        userInformation.put("username", ReaderUserFile.getUsername(context.user.getTypeUser()));
        userInformation.put("bio", ReaderUserFile.getBio(context.user.getTypeUser()));
        context.user.processInformation(userInformation);
        PageTransporter.navigateToPage("login");
        trelloLoginPage = new TrelloLoginPage();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(ReaderUserFile.getEmail(context.user.getTypeUser()));
        atlassianLoginPage.waitUntilPageObjectIsLoaded();
        boardsPage = atlassianLoginPage.loginTrello(ReaderUserFile.getPassword(context.user.getTypeUser()));
        boardsPage.waitUntilPageObjectIsLoaded();
        profilePage = boardsPage.getTopMenu().clickBtnMemberMenu().getProfilePage();
        profilePage.editUserProfile(context.user);
        WebDriverManager.getInstance().quit();
    }
}
