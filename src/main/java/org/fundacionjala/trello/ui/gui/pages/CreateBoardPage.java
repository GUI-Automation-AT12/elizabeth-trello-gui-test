package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.core.utils.WebDriverManager;
import org.fundacionjala.trello.ui.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBoardPage extends BasePage {
    @FindBy(xpath = "//button[@*='header-boards-menu-button']")
    private WebElement buttonBoards;
    @FindBy(xpath = "//button[contains(text(),'Create new board')]")
    private WebElement linkCreateBoard;
    @FindBy(xpath = "//input[@*='create-board-title-input']")
    private WebElement textBoxNameBoard;
    @FindBy(xpath = "//button[@*='create-board-submit-button']")
    private WebElement buttonCreateBoard;

    public CreateBoardPage() {
        super();
    }

    public String getTitle() {
        return WebDriverManager.getInstance().getWebDriver().getTitle();
    }

    public void clickButtonCreateBoard(final String name) {
        ElementUtil.clickElement(buttonBoards);
        ElementUtil.clickElement(linkCreateBoard);
        ElementUtil.setElement(textBoxNameBoard, name);
        ElementUtil.clickElement(buttonCreateBoard);
    }
}
