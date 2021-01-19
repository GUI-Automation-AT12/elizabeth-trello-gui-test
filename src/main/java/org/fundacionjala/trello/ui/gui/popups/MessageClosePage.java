package org.fundacionjala.trello.ui.gui.popups;

import org.fundacionjala.trello.ui.gui.pages.BasePage;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessageClosePage extends BasePage {

    @FindBy(css = "div.closed-board h1")
    private WebElement message;

    @FindBy(css = "a.js-delete")
    private WebElement linkToDelete;

    @FindBy(css = "a.js-reopen")
    private WebElement linkToReopen;

    @FindBy(css = "input.js-confirm")
    private WebElement btnCloseMessageConfirm;

    /**
     * Constructor.
     */
    public MessageClosePage() {
        super();
    }

    /**
     * Gets text of message.
     * @return text of message
     */
    public String getTextMessage() {
        return WebElementUtil.getTextFromWebElement(message);
    }

    /**
     * Waits until page is loaded.
     */
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsVisible(message);
    }

    /**
     * Clicks on WebElement.
     */
    public void clickBtnCloseMessageConfirm() {
        WebElementUtil.clickElement(btnCloseMessageConfirm);
    }

    /**
     * Clicks on WebElement.
     */
    public void clickLinkCloseBoard() {
        WebElementUtil.clickElement(linkToDelete);
    }

    /**
     * Closes board.
     * @return MessageClosePage
     */
    public MessageDeletePage deleteBoard() {
        clickLinkCloseBoard();
        clickBtnCloseMessageConfirm();
        return new MessageDeletePage();
    }

}
