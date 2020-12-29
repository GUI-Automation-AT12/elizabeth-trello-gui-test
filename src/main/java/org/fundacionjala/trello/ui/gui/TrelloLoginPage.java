package org.fundacionjala.trello.ui.gui;

import org.fundacionjala.trello.ui.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrelloLoginPage extends BasePage{
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
        ElementUtil.setElement(usernameTextBox, username);
    }

    public void setPassword(final String password) {
        ElementUtil.setElement(passwordTextBox, password);
    }

    public void clickBtnLogin() {
        ElementUtil.clickElement(btnLogin);
    }

    public AtlassianLoginPage clickButtonLoginWithAtlassian(final String username) {
        this.setUsername(username);
        this.clickBtnLogin();
        return new AtlassianLoginPage();
    }
}
