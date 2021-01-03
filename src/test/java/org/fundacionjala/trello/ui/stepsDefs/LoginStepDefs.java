package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.config.Environment;
import org.fundacionjala.trello.ui.gui.pages.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.pages.BoardsPage;
import org.fundacionjala.trello.ui.gui.pages.TrelloLoginPage;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {
    private TrelloLoginPage trelloLoginPage;
    private AtlassianLoginPage atlassianLoginPage;
    private BoardsPage boardsPage;

    @When("I set username and password")
    public void setTextBoxes() {
        trelloLoginPage = new TrelloLoginPage();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(Environment.getInstance().getUsername());
        boardsPage = atlassianLoginPage.loginTrello(Environment.getInstance().getPassword());
    }

    @Then("I should view the {string} suffix in the URL")
    public void verifyTheSuffixInTheURL(final String endPoint) {
        boardsPage.waitUntilPageObjectIsLoaded();
        assertTrue(boardsPage.getCurrentUrl().contains(endPoint));
    }
}
