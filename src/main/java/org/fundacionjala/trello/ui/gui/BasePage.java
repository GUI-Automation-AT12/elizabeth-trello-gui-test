package org.fundacionjala.trello.ui.gui;

import org.fundacionjala.trello.core.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        this.webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(this.webDriver,this);
    }

    protected void goBaseURL() {
        webDriver.get("https://www.trello.com/");
    }

    protected String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
