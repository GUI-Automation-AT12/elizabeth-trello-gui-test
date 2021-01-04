package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrelloLoginPage extends BasePage {

    @FindBy(id = "user")
    private WebElement usernameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "login")
    private WebElement btnLogin;

    /**
     * Constructor.
     */
    public TrelloLoginPage() {
        super();
    }

    /**
     * Sets username textBox.
     * @param username
     */
    public void setUsername(final String username) {
        WebElementUtil.setElement(usernameTextBox, username);
    }

    /**
     * Sets password textBox.
     * @param password
     */
    public void setPassword(final String password) {
        WebElementUtil.setElement(passwordTextBox, password);
    }

    /**
     * Clicks login button.
     */
    public void clickBtnLogin() {
        WebElementUtil.clickElement(btnLogin);
    }

    /**
     * Waits until the page is loaded.
     */
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnLogin);
    }

    /**
     * Redirects to Atlassian page.
     * @param username
     * @return Atlassian page
     */
    public AtlassianLoginPage clickButtonLoginWithAtlassian(final String username) {
        this.setUsername(username);
        this.clickBtnLogin();
        return new AtlassianLoginPage();
    }
}
