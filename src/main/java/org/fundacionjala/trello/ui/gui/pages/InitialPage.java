package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InitialPage extends BasePage{

    @FindBy(xpath = "//div[@class='float-right buttons']/a[1]")
    private WebElement btnLogin;

    @FindBy(xpath = "//title[contains(text(), 'Trello')]")
    private WebElement title;

    public InitialPage() {
        super();
    }

    public void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btnLogin));
    }

    public TrelloLoginPage clickOnButtonLogin() {
        ElementUtil.clickElement(btnLogin);
        return new TrelloLoginPage();

    }

    public WebElement getTitle() {
        return title;
    }

    public void goBaseUrl(){
        super.goBaseURL();
    }
}
