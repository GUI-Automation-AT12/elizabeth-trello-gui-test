package org.fundacionjala.core.ui;

import org.fundacionjala.core.config.WebDriverConfig;
import org.fundacionjala.core.config.WebDriverEnvironment;
import org.fundacionjala.core.ui.webDrivers.DriveFactory;
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
        webDriver.manage().timeouts().implicitlyWait(
                WebDriverConfig.getInstance().getImplicitTime(WebDriverEnvironment
                        .getInstance().getBrowserName()), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver,
                WebDriverConfig.getInstance().getExplicitTime(WebDriverEnvironment
                        .getInstance().getBrowserName()));
        webDriver.manage().window().maximize();
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
