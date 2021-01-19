package org.fundacionjala.core.ui.webDrivers;

import org.fundacionjala.core.config.WebDriverEnvironment;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public final class DriveFactory {
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String EDGE = "edge";

    /**
     * Constructor.
     */
    private DriveFactory() {
    }

    /**
     * Gets webDriver of specific browser.
     * @return webdriver
     */
     public static WebDriver getDriver() {
         Map<String, IDriver> strategyBrowser = new HashMap<>();
         strategyBrowser.put(FIREFOX, new Firefox());
         strategyBrowser.put(CHROME, new Chrome());
         strategyBrowser.put(EDGE, new Edge());

         return strategyBrowser.get(WebDriverEnvironment.getInstance()
                 .getBrowserName().toLowerCase()).initDriver();
     }
}
