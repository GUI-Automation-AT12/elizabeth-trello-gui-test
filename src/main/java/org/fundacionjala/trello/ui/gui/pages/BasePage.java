package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * Constructor.
     */
    public BasePage() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        this.webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Gets webDriver.
     * @return webDriver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets webDriverWait.
     * @return webDriverWait
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
