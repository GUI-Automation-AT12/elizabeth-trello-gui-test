package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.trello.ui.Context.Context;
import org.fundacionjala.trello.ui.entities.Board;
import org.fundacionjala.trello.ui.gui.pages.BoardPage;
import org.fundacionjala.trello.ui.gui.pages.BoardsPage;
import org.fundacionjala.trello.ui.gui.popups.BoardMenuPopUp;
import org.fundacionjala.trello.ui.gui.popups.CreateBoardPopUp;
import org.fundacionjala.trello.ui.gui.popups.MessageClosePage;
import org.fundacionjala.trello.ui.gui.popups.MessageDeletePage;
import org.testng.Assert;

import java.util.Map;

public class BoardStepDefs {

    private Context context;
    private BoardsPage boardsPage = new BoardsPage();
    private BoardPage boardPage = new BoardPage();
    private BoardMenuPopUp boardMenuPopUp;
    private MessageClosePage messageClosePage;
    private MessageDeletePage messageDeletePage;

    /**
     * Constructor.
     * @param sharedContext
     */
    public BoardStepDefs(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Create a new board.
     * @param boardInformation
     */
    @When("I create a board with the following information")
    public void createABoardWithTheFollowingInformation(final Map<String, String> boardInformation) {
        context.board = new Board();
        CreateBoardPopUp createBoardPopUp = boardsPage.getTopMenu().getCreateBoardPage();
        context.board.processInformation(boardInformation);
        boardPage = createBoardPopUp.createBoard(context.board);
    }

    /**
     * Verify new board is created.
     */
    @Then("The board name should be displayed on Board Page")
    public void verifyBoardNameIsDisplayed() {
        boardPage.waitUntilPageObjectIsLoaded();
        String expectedName = context.board.getName();
        context.board.setIdBoard(WebDriverManager.getInstance().getWebDriver().getCurrentUrl());
        String actualName = boardPage.getNameBoardCreated();
        Assert.assertEquals(actualName, expectedName);
    }

    @Then("The board team name should be displayed on Board Page")
    public void verifyBoardTeamNameIsDisplayed() {
        String expected = context.board.getTeam();
        String actualName = boardPage.getNameTeamBoardCreated();
        Assert.assertTrue(actualName.contains(expected));
    }

    @Then("The board privacy should be displayed on Board Page")
    public void verifyBoardPrivacyIsDisplayed() {
        String expected = context.board.getPrivacy();
        String actualName = boardPage.getPrivacyBoardCreated();
        Assert.assertEquals(actualName, expected);
    }

    @And("I select specific board")
    public void selectSpecificBoard() {
        System.out.println(context.board.getName());
        boardsPage.waitUntilPageObjectIsLoaded();
        boardPage = boardsPage.selectABoard(context.board.getName());
        boardPage.waitUntilPageObjectIsLoaded();
    }

    @And("I delete the board")
    public void deleteTheBoard() {
        boardMenuPopUp = boardPage.showBoardMenu();
        messageClosePage = boardMenuPopUp.CloseBoard();
        messageDeletePage = messageClosePage.deleteBoard();
        messageDeletePage.waitUntilPageObjectIsLoaded();
    }

    @Then("{string} message should be displayed on Board Page")
    public void verifyMessageShouldBeDisplayed(String message) {
        Assert.assertEquals(message,messageDeletePage.getTextMessage());
    }
}
