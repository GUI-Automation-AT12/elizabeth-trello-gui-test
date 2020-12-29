package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.config.Environment;
import org.fundacionjala.trello.ui.gui.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.BoardsPage;
import org.fundacionjala.trello.ui.gui.InitialPage;
import org.fundacionjala.trello.ui.gui.TrelloLoginPage;

public class UserStepdefs {

    private InitialPage initialPage;
    private TrelloLoginPage trelloLoginPage;
    private AtlassianLoginPage atlassianLoginPage;
    private BoardsPage boardsPage;

    @Given("I log in Trello with valid Credentials")
    public void iLogInTrelloWithValidCredentials() {
        initialPage = new InitialPage();
        initialPage.goBaseUrl();
        trelloLoginPage = initialPage.clickOnButtonLogin();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(Environment.getInstance().getUsername());
        boardsPage = atlassianLoginPage.loginTrello(Environment.getInstance().getPassword());
    }

    @When("I navigate to My Profile Page")
    public void iNavigateToMyProfilePage() {
    }

    @And("I edit My Profile with the following information")
    public void iEditMyProfileWithTheFollowingInformation() {
    }

    @And("My Profile section should be updated")
    public void myProfileSectionShouldBeUpdated() {
    }
}
