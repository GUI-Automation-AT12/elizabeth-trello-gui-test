package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBoardPage extends BasePage {
    @FindBy(css = "button[data-test-id='header-boards-menu-button']")
    private WebElement buttonBoards;

    @FindBy(xpath = "//button[contains(text(),'Create new board')]")
    private WebElement linkCreateBoard;

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement textBoxNameBoard;

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement buttonCreateBoard;

    /**
     * Constructor.
     */
    public CreateBoardPage() {
        super();
    }

    /**
     * Gets title of page.
     * @return title of page
     */
    public String getTitle() {
        return WebDriverManager.getInstance().getWebDriver().getTitle();
    }

    /**
     * Create board by clicking create board button.
     * @param name
     */
    public void clickButtonCreateBoard(final String name) {
        WebElementUtil.clickElement(buttonBoards);
        WebElementUtil.clickElement(linkCreateBoard);
        WebElementUtil.setElement(textBoxNameBoard, name);
        WebElementUtil.clickElement(buttonCreateBoard);
    }
}
