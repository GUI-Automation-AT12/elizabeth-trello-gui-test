package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrelloLoginPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'email-password']/div/input[@id='user']")
    private WebElement usernameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "login")
    private WebElement btnLogin;

    @FindBy(xpath = "//title[contains(text(), 'Trello')]")
    private WebElement title;

    public TrelloLoginPage() {
        super();
    }

    public WebElement getTitle() {
        return title;
    }

    public void setUsername(final String username) {
        WebElementUtil.setElement(usernameTextBox, username);
    }

    public void setPassword(final String password) {
        WebElementUtil.setElement(passwordTextBox, password);
    }

    public void clickBtnLogin() {
        WebElementUtil.clickElement(btnLogin);
    }

    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnLogin);
    }

    public AtlassianLoginPage clickButtonLoginWithAtlassian(final String username) {
        this.setUsername(username);
        this.clickBtnLogin();
        return new AtlassianLoginPage();
    }
}
