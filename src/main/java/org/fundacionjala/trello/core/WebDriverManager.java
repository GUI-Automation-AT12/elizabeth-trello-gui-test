package org.fundacionjala.trello.core;

import org.fundacionjala.trello.core.WebDrivers.DriveFactory;
import org.fundacionjala.trello.core.config.WebDriverEnvironment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * Constructor.
     */
    public WebDriverManager() {
        webDriver = DriveFactory.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(
                WebDriverEnvironment.getInstance().getImplicitTime(),
                TimeUnit.SECONDS
        );
        webDriverWait = new WebDriverWait(webDriver, WebDriverEnvironment.getInstance().getExplicitTime());
    }

    /**
     * Gets instance of WebDriverManager.
     * @return a instance of WebDriverManager
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * Gets WebDriver.
     * @return WebDriver
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

    /**
     * Close browser.
     */
    public void quit() {
        webDriver.quit();
        webDriverManager = null;
    }
}
