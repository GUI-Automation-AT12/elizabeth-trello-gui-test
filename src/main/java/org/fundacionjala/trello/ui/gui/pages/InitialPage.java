package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialPage extends BasePage {

    @FindBy(css = "a[href*='/login']")
    private WebElement btnLogin;

    /**
     * Constructor.
     */
    public InitialPage() {
        super();
    }

    /**
     * Waits until page is loaded.
     */
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnLogin);
    }

    /**
     * Clicks in login button.
     * @return Trello login page
     */
    public TrelloLoginPage clickOnButtonLogin() {
        WebElementUtil.clickElement(btnLogin);
        return new TrelloLoginPage();
    }
}
