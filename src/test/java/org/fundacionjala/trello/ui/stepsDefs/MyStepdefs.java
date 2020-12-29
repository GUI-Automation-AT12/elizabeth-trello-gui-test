package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.config.Environment;
import org.fundacionjala.trello.ui.gui.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.BoardsPage;
import org.fundacionjala.trello.ui.gui.InitialPage;
import org.fundacionjala.trello.ui.gui.TrelloLoginPage;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class MyStepdefs {
    private InitialPage initialPage;
    private TrelloLoginPage trelloLoginPage;
    private AtlassianLoginPage atlassianLoginPage;
    private BoardsPage boardsPage;

    @Given("I am on the login page {string}")
    public void iAmOnTheLoginPage(final String url) {
        initialPage = new InitialPage();
        initialPage.goBaseUrl();
        trelloLoginPage = initialPage.clickOnButtonLogin();
    }

    @When("I set username and password")
    public void setTextBox() {
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(Environment.getInstance().getUsername());
    }

    @Then("I should view the {string} suffix in the URL")
    public void iShouldViewTheSuffixInTheURL(final String endPoint) {
        boardsPage = atlassianLoginPage.loginTrello(Environment.getInstance().getPassword());
        assertTrue(boardsPage.getCurrentUrl().contains(endPoint));
    }
}
