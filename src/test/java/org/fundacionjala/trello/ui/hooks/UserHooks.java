package org.fundacionjala.trello.ui.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.trello.ui.Context.Context;
import org.fundacionjala.trello.ui.utils.ReaderUserFile;
import org.fundacionjala.trello.ui.gui.pages.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.pages.BoardsPage;
import org.fundacionjala.trello.ui.gui.pages.ProfilePage;
import org.fundacionjala.trello.ui.gui.pages.TrelloLoginPage;
import org.fundacionjala.trello.ui.gui.PageTransporter;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
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
    @After(value = "@ResetUserInformation", order = 1)
    public void restoreUserProfile() throws MalformedURLException {
        Map<String, String> userInformation = new HashMap<>();
        userInformation.put("username", ReaderUserFile.getInstance().getUsername(context.getUser().getTypeUser()));
        userInformation.put("bio", ReaderUserFile.getInstance().getBio(context.getUser().getTypeUser()));
        context.getUser().processInformation(userInformation);

        PageTransporter.navigateToPage("login");
        trelloLoginPage = new TrelloLoginPage();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(ReaderUserFile.getInstance().getEmail(context.getUser().getTypeUser()));
        atlassianLoginPage.waitUntilPageObjectIsLoaded();
        boardsPage = atlassianLoginPage.loginTrello(ReaderUserFile.getInstance().getPassword(context.getUser().getTypeUser()));
        boardsPage.waitUntilPageObjectIsLoaded();
        profilePage = boardsPage.getTopMenu().clickBtnMemberMenu().getProfilePage();
        profilePage.editUserProfile(context.getUser());
        WebDriverManager.getInstance().quit();
    }
}
