package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.fundacionjala.trello.ui.config.Environment;
import org.fundacionjala.trello.ui.entities.User;
import org.fundacionjala.trello.ui.gui.pages.*;

import java.util.Map;

public class UserStepdefs {

    private InitialPage initialPage;
    private TrelloLoginPage trelloLoginPage;
    private AtlassianLoginPage atlassianLoginPage;
    private BoardsPage boardsPage;
    private ProfilePage profilePage;
    private User user;

    @Given("I log in Trello with valid Credentials")
    public void iLogInTrelloWithValidCredentials() {
        initialPage = new InitialPage();
        initialPage.goBaseUrl();
        trelloLoginPage = initialPage.clickOnButtonLogin();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(Environment.getInstance().getUsername());
        boardsPage = atlassianLoginPage.loginTrello(Environment.getInstance().getPassword());
    }

    @And("I edit My Profile with the following information")
    public void iEditMyProfileWithTheFollowingInformation(final Map<String, String> information) {
        user.processInformation(information);
    }

    @And("My Profile section should be updated")
    public void myProfileSectionShouldBeUpdated() {
    }
}
