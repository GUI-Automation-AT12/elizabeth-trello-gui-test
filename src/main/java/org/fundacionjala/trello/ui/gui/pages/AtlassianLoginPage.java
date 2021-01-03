package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AtlassianLoginPage extends BasePage {
    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "login-submit")
    private WebElement btnLoginSubmit;

    @FindBy(xpath = "//title[contains(text(), 'Trello')]")
    private WebElement title;

    @FindBy(xpath = "//button[@*='header-member-menu-button']")
    private WebElement iconUser;

    public AtlassianLoginPage() {
        super();
    }

    public void clickBtnLoginSubmit() {
        WebElementUtil.clickElement(btnLoginSubmit);
    }

    public void clickIconUser() {
        WebElementUtil.clickElement(iconUser);
    }

    public WebElement getIconUser() {
        return iconUser;
    }

    public void setPassword(final String password) {
        WebElementUtil.setElement(passwordTextBox, password);
    }

    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnLoginSubmit);
    }

    public BoardsPage loginTrello(final String password) {
        this.setPassword(password);
        this.clickBtnLoginSubmit();
        return new BoardsPage();
    }
}
