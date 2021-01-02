package org.fundacionjala.trello.ui.utils;

import org.fundacionjala.trello.core.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

    private ElementUtil() {
        
    }

    public static void setElement(final WebElement webElement, final String text) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void setElement(final By by, final String text) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
        setElement(webElement, text);
    }

    public static void clickElement(final WebElement webElement) {
       WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
       webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public static void clickElement(final By by) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        WebElement webElement = webDriver.findElement(by);
        clickElement(webElement);
    }

    public static void waitUntilPageIsLoaded(WebElement webElement) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
