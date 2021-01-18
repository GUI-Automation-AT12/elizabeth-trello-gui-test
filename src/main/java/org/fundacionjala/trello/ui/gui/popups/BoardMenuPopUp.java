package org.fundacionjala.trello.ui.gui.popups;

import org.fundacionjala.trello.ui.gui.pages.BasePage;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardMenuPopUp extends BasePage {
    @FindBy(css = "a.js-open-more")
    private WebElement linkMore;

    @FindBy(css = "a.js-close-board")
    private WebElement linkCloseBoard;

    @FindBy(css = "input.js-confirm")
    private WebElement btnCloseMessageConfirm;

    private MessageClosePage messageCloseBoardPage;

    public BoardMenuPopUp() {
        super();
    }

    /**
     * Clicks on WebElement.
     */
    public void clickLinkMore() {
        WebElementUtil.clickElement(linkMore);
    }

    /**
     * Clicks on WebElement.
     */
    public void clickLinkCloseBoard() {
        WebElementUtil.clickElement(linkCloseBoard);
    }

    /**
     * Clicks on WebElement.
     */
    public void clickBtnCloseMessageConfirm() {
        WebElementUtil.clickElement(btnCloseMessageConfirm);
    }

    /**
     * Closes board
     * @return MessageClosePage
     */
    public MessageClosePage CloseBoard() {
        clickLinkMore();
        clickLinkCloseBoard();
        clickBtnCloseMessageConfirm();
        return new MessageClosePage();
    }

    public WebElement getLinkMore() {
        return linkMore;
    }
}
