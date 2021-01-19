package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.gui.popups.BoardMenuPopUp;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends BasePage {

    @FindBy(css = "div.board-canvas")
    private WebElement boardLists;

    @FindBy(css = "h1.board-header-btn-text")
    private WebElement nameBoardCreated;

    @FindBy(css = "a.board-header-btn-org-name span.board-header-btn-text")
    private WebElement teamNameBoardCreated;

    @FindBy(css = "a#permission-level span.board-header-btn-text")
    private WebElement privacyBoardCreated;

    @FindBy(css = "a.mod-show-menu")
    private WebElement btnMenu;

    /**
     * Constructor.
     */
    public BoardPage() {
        super();
    }

    /**
     * Gets name of board.
     * @return name of board created
     */
    public String getNameBoardCreated() {
        WebElementUtil.waitUntilElementIsLoaded(boardLists);
        return WebElementUtil.getTextFromWebElement(nameBoardCreated);
    }

    /**
     * Waits until page is loaded.
     */
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsVisible(boardLists);
    }

    /**
     * Gets team name of board.
     * @return team name of board created
     */
    public String getNameTeamBoardCreated() {
        return WebElementUtil.getTextFromWebElement(teamNameBoardCreated);
    }

    /**
     * Gets privacy of board.
     * @return privacy of board created
     */
    public String getPrivacyBoardCreated() {
        return WebElementUtil.getTextFromWebElement(privacyBoardCreated);
    }

    /**
     * Gets menu of board.
     * @return menu of board
     */
    public BoardMenuPopUp showBoardMenu() {
        BoardMenuPopUp boardMenuPopUp = new BoardMenuPopUp();
        if (!boardMenuPopUp.getLinkMore().isDisplayed()) {
            WebElementUtil.clickElement(btnMenu);
        }
        return boardMenuPopUp;
    }
}
