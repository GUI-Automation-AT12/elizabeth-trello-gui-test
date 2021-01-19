package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.gui.pages.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.pages.BoardsPage;
import org.fundacionjala.trello.ui.gui.pages.TrelloLoginPage;
import org.fundacionjala.trello.ui.utils.ReaderUserFile;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {
    private TrelloLoginPage trelloLoginPage;
    private AtlassianLoginPage atlassianLoginPage;
    private BoardsPage boardsPage;

    /**
     * Set use and password.
     */
    @When("I set username and password")
    public void setTextBoxes() {
        trelloLoginPage = new TrelloLoginPage();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(ReaderUserFile.getInstance().getEmail("Valid"));
        atlassianLoginPage.waitUntilPageObjectIsLoaded();
        boardsPage = atlassianLoginPage.loginTrello(ReaderUserFile.getInstance().getPassword("Valid"));
        boardsPage.waitUntilPageObjectIsLoaded();
    }

    /**
     * Verify if url contains the endpoint.
     * @param endPoint
     */
    @Then("I should view the {string} suffix in the URL")
    public void verifyTheSuffixInTheURL(final String endPoint) {
        boardsPage.waitUntilPageObjectIsLoaded();
        assertTrue(boardsPage.getWebDriver().getCurrentUrl().contains(endPoint));
    }
}
