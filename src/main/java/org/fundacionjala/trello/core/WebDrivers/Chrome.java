package org.fundacionjala.trello.core.WebDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;


public class Chrome implements IDriver {

    /**
     * Init chrome driver.
     * @return ChromeDriver
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version("87.0.4280.88").setup();
        return new ChromeDriver();
    }
}
