package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.trello.ui.Context.Context;
import org.fundacionjala.trello.ui.utils.ReaderUserFile;
import org.fundacionjala.trello.ui.entities.User;
import org.fundacionjala.trello.ui.gui.pages.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.pages.BoardsPage;
import org.fundacionjala.trello.ui.gui.pages.TrelloLoginPage;
import org.fundacionjala.trello.ui.gui.PageTransporter;

import java.net.MalformedURLException;

public class BackgroundStepDefs {

    private TrelloLoginPage trelloLoginPage;
    private AtlassianLoginPage atlassianLoginPage;
    private BoardsPage boardsPage;
    private Context context;

    /**
     * Constructor.
     * @param contextDI
     */
    public BackgroundStepDefs(final Context contextDI) {
        this.context = contextDI;
    }

    /**
     * Login to Trello with valid credentials.
     * @throws MalformedURLException
     */
    @Given("^I log in Trello with (.*?) user credentials$")
    public void logInTrelloWithValidCredentials(final String typeUser) throws MalformedURLException {
        context.user = new User();
        context.user.setTypeUser(typeUser);
        PageTransporter.navigateToPage("login");
        trelloLoginPage = new TrelloLoginPage();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(ReaderUserFile.getInstance().getEmail(typeUser));
        atlassianLoginPage.waitUntilPageObjectIsLoaded();
        boardsPage = atlassianLoginPage.loginTrello(ReaderUserFile.getInstance().getPassword(typeUser));
    }

    /**
     * Executes code after each scenarios
     */
    @After
    public void afterScenario() {
        WebDriverManager.getInstance().quit();
    }
}
