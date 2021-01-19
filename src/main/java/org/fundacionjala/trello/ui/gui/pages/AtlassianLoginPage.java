package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AtlassianLoginPage extends BasePage {
    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "login-submit")
    private WebElement btnLoginSubmit;

    @FindBy(xpath = "//title[contains(text(), 'Trello')]")
    private WebElement title;

    /**
     * Constructor.
     */
    public AtlassianLoginPage() {
        super();
    }

    /**
     * Clicks login button.
     */
    public void clickBtnLoginSubmit() {
        WebElementUtil.clickElement(btnLoginSubmit);
    }

    /**
     * Sets password.
     * @param password
     */
    public void setPassword(final String password) {
        WebElementUtil.setElement(passwordTextBox, password);
    }

    /**
     * Waits until page is Loaded.
     */
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnLoginSubmit);
    }

    /**
     * Login in Trello application.
     * @param password
     * @return the boards page
     */
    public BoardsPage loginTrello(final String password) {
        this.setPassword(password);
        this.clickBtnLoginSubmit();
        return new BoardsPage();
    }
}
