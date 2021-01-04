package org.fundacionjala.trello.core.WebDrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class Firefox implements IDriver {
    private static int wait;
    private static int waitImplicit;

    /**
     * Init firefox driver.
     * @return FirefoxDriver
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version("").setup();
        return new FirefoxDriver();
    }
}
