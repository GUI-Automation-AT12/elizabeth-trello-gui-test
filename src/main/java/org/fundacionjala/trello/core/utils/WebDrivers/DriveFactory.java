package org.fundacionjala.trello.core.utils.WebDrivers;

import org.fundacionjala.trello.core.utils.WebDriverManager;
import org.fundacionjala.trello.ui.config.WebDriverEnvironment;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public final class DriveFactory {
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";

    private DriveFactory() {

    }
     public static WebDriver getDriver() {
         Map<String, IDriver> strategyBrowser = new HashMap<>();
         strategyBrowser.put(FIREFOX, new Firefox());
         strategyBrowser.put(CHROME, new Chrome());

         System.out.println(WebDriverEnvironment.getInstance().getBrowserName().toLowerCase());
         return strategyBrowser.get(WebDriverEnvironment.getInstance().getBrowserName().toLowerCase()).initDriver();
     }
}
