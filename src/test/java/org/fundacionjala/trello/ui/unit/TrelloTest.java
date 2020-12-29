package org.fundacionjala.trello.ui.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrelloTest {
    private WebDriver driver;
    JavascriptExecutor js;
    private String pageUrl = "https://trello.com/";
    private String pageLogin = "https://trello.com/usuario87/boards";
    WebDriverWait wait;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get(pageUrl);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        wait = new WebDriverWait(driver, 30);
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='float-right buttons']/a[1]")).click();
        driver.findElement(By.id("user")).sendKeys("trello.proy1234@gmail.com");
        driver.findElement(By.id("login")).click();
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit")));
        driver.findElement(By.id("password")).sendKeys("TrelloGUI567890");
        buttonElement.click();
        WebElement selectGender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@*='header-member-menu-button']")));
        selectGender.click();
        assertEquals(driver.findElement(By.xpath("//button[@*='header-member-menu-logout']/span")).getText(), "Log Out");
    }

    @Test
    public void createBoard() {
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='float-right buttons']/a[1]")).click();
        driver.findElement(By.id("user")).sendKeys("trello.proy1234@gmail.com");
        driver.findElement(By.id("login")).click();
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit")));
        driver.findElement(By.id("password")).sendKeys("TrelloGUI567890");
        buttonElement.click();
        WebElement buttonBoards = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@*='header-boards-menu-button']")));
        buttonBoards.click();
        driver.findElement(By.xpath("//button[contains(text(),'Create new board')]")).click();
        WebElement inputBoard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@*='create-board-title-input']")));
        inputBoard.sendKeys("Board desde selenium");
        driver.findElement(By.xpath("//button[@*='create-board-submit-button']")).click();
        driver.getCurrentUrl();
    }

    @Test
    public void deleteBoard() {
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='float-right buttons']/a[1]")).click();
        driver.findElement(By.id("user")).sendKeys("trello.proy1234@gmail.com");
        driver.findElement(By.id("login")).click();
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit")));
        driver.findElement(By.id("password")).sendKeys("TrelloGUI567890");
        buttonElement.click();

        WebElement buttonBoards = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@*='header-boards-menu-button']")));
        buttonBoards.click();
        driver.findElement(By.xpath("//a[@title='Board1']/ancestor::div[@*='header-boards-menu-popover']")).click();
        WebElement headerBoard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("board-header")));
        //driver.findElement(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']")).click();

        driver.findElement(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']")).click();
        driver.findElement(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']")).click();
        driver.findElement(By.xpath("//input[@value='Close']")).click();
        driver.findElement(By.xpath("//a[@class='quiet js-delete']")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        assertTrue(driver.findElement(By.linkText("Board not found.")).isEnabled());
    }

    @Test
    public void createList() {
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='float-right buttons']/a[1]")).click();
        driver.findElement(By.id("user")).sendKeys("trello.proy1234@gmail.com");
        driver.findElement(By.id("login")).click();
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit")));
        driver.findElement(By.id("password")).sendKeys("TrelloGUI567890");
        buttonElement.click();
        WebElement buttonBoards = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@*='header-boards-menu-button']")));
        buttonBoards.click();
        driver.findElement(By.xpath("//a[@title='Board desde selenium']")).click();
        WebElement headerBoard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("board-header")));
        driver.findElement(By.className("open-add-list")).click();
        driver.findElement(By.className("list-name-input")).sendKeys("List 1");
        driver.findElement(By.xpath("//input[@value='Add List']")).click();
        assertTrue(driver.findElement(By.xpath("//div[@class='js-list list-wrapper']/div/div/h2[text()='List 1']")).isEnabled());
    }

    @Test
    public void deleteList() {
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='float-right buttons']/a[1]")).click();
        driver.findElement(By.id("user")).sendKeys("trello.proy1234@gmail.com");
        driver.findElement(By.id("login")).click();
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit")));
        driver.findElement(By.id("password")).sendKeys("TrelloGUI567890");
        buttonElement.click();
        WebElement buttonBoards = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@*='header-boards-menu-button']")));
        buttonBoards.click();
        driver.findElement(By.xpath("//a[@title='Board1']")).click();
        WebElement headerBoard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("board-header")));
        driver.findElement(By.xpath("//h2[text()='e']/ancestor::div[@class='list-header js-list-header u-clearfix is-menu-shown']/div[@class='list-header-extras']/a")).click();
        driver.findElement(By.xpath("//a[@class='js-close-list']")).click();
    }

    @Test
    public void createCard() {
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='float-right buttons']/a[1]")).click();
        driver.findElement(By.id("user")).sendKeys("trello.proy1234@gmail.com");
        driver.findElement(By.id("login")).click();
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit")));
        driver.findElement(By.id("password")).sendKeys("TrelloGUI567890");
        buttonElement.click();
        WebElement buttonBoards = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@*='header-boards-menu-button']")));
        buttonBoards.click();
        driver.findElement(By.xpath("//a[@title='Board desde selenium']")).click();
        WebElement headerBoard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("board-header")));
        driver.findElement(By.xpath("//h2[text()='List 1']/parent::div/following-sibling::div/a[contains(.,'Add')]")).click();
        driver.findElement(By.className("list-card-composer-textarea")).sendKeys("Card 1");
        driver.findElement(By.xpath("//input[@value='Add Card']")).click();
        assertTrue(driver.findElement(By.xpath("//h2[text()='List 1']/parent::*/following-sibling::div/a[contains(.,'Card 1')]")).isEnabled());
    }

    @Test
    public void deleteCard() {
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='float-right buttons']/a[1]")).click();
        driver.findElement(By.id("user")).sendKeys("trello.proy1234@gmail.com");
        driver.findElement(By.id("login")).click();
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-submit")));
        driver.findElement(By.id("password")).sendKeys("TrelloGUI567890");
        buttonElement.click();
        WebElement buttonBoards = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@*='header-boards-menu-button']")));
        buttonBoards.click();
        driver.findElement(By.xpath("//a[@title='Board desde selenium']")).click();
        WebElement headerBoard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("board-header")));
        driver.findElement(By.xpath("//h2[text()='List 1']/parent::*/following-sibling::div/a[contains(.,'Card 1')]")).click();
        driver.findElement(By.className(".js-archive-card")).click();
        driver.findElement(By.className(".js-delete-card")).click();
        driver.findElement(By.className(".js-confirm")).click();
    }
}
