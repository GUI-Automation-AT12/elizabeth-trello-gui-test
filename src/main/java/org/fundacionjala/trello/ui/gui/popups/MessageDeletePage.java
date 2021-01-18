package org.fundacionjala.trello.ui.gui.popups;

import org.fundacionjala.trello.ui.gui.pages.BasePage;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessageDeletePage extends BasePage {
    @FindBy(xpath = "//h1[text()='Board not found.']")
    private WebElement message;

    public MessageDeletePage() {
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
        WebElementUtil.waitUntilElementIsLoaded(message);
    }

}
