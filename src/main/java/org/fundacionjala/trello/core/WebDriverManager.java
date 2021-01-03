package org.fundacionjala.trello.core;

import org.fundacionjala.trello.core.WebDrivers.DriveFactory;
import org.fundacionjala.trello.ui.config.WebDriverEnvironment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WebDriverManager() {
        webDriver = DriveFactory.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(WebDriverEnvironment.getInstance().getImplicitTime(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, WebDriverEnvironment.getInstance().getExplicitTime());
    }

    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void quit() {
        webDriver.quit();
        webDriverManager = null;
    }
}
