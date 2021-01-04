package org.fundacionjala.trello.ui.utils;

import org.fundacionjala.trello.core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebElementUtil {

    /**
     * Constructor.
     */
    private WebElementUtil() {
    }

    /**
     * Sets webElement text.
     * @param webElement
     * @param text
     */
    public static void setElement(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Sets element text.
     * @param by
     * @param text
     */
    public static void setElement(final By by, final String text) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
        setElement(webElement, text);
    }

    /**
     * Clicks on elements.
     * @param webElement
     */
    public static void clickElement(final WebElement webElement) {
       webElement.click();
    }

    /**
     * Clicks on elements.
     * @param by
     */
    public static void clickElement(final By by) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        WebElement webElement = webDriver.findElement(by);
        clickElement(webElement);
    }

    /**
     * Waits until a element is loaded.
     * @param webElement
     */
    public static void waitUntilElementIsLoaded(final WebElement webElement) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
