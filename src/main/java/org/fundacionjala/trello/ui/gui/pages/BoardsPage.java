package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.trello.ui.gui.component.TopMenu;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BoardsPage extends BasePage {

    @FindBy(css = "button[data-test-id='header-member-menu-logout']/span")
    private WebElement btnLogout;

    @FindBy(css = "button[data-test-id='header-member-menu-button']")
    private WebElement btnMenu;

    private List<WebElement> boards = WebDriverManager.getInstance()
                                                    .getWebDriver().findElements(By.className("board-tile"));
    private List<WebElement> teams = WebDriverManager.getInstance().getWebDriver()
                                                     .findElements(By.cssSelector("li[data-test-id^='home-team-tab-section'] a"));

    private TopMenu topMenu;

    /**
     * Constructor.
     */
    public BoardsPage() {
        super();
        topMenu = new TopMenu();
    }

    /**
     * Waits to element of page is loaded.
     */
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnMenu);
    }

    /**
     * Gets WebElement logout button.
     * @return btnLogout
     */
    public WebElement getBtnLogout() {
        return btnLogout;
    }

    /**
     * Clicks Menu button.
     */
    public void clickBtnMenu() {
        WebElementUtil.clickElement(btnMenu);
    }

    /**
     * Gets WebElement Top Menu.
     * @return btnLogout
     */
    public TopMenu getTopMenu() {
        return topMenu;
    }

    /**
     * Gets WebElement.
     * @return boardTile
     */
    public BoardPage selectABoard(String name) {
        for (WebElement element: boards) {
            String urlBoard = element.getAttribute("href");
            if (urlBoard.contains(name.toLowerCase())) {
                WebElementUtil.clickElement(element);
                break;
            }
        }
        return new BoardPage();
    }

    /**
     * Gets WebElement.
     * @return boardTile
     */
    public TeamPage selectATeam(String name) {
        for (WebElement element: teams) {
            System.out.println(element.getAttribute("href"));
            String urlBoard = element.getAttribute("href");
            if (urlBoard.contains(name.toLowerCase()+ "/home")) {
                WebElementUtil.clickElement(element);
                WebDriverManager.getInstance()
                        .getWebDriver()
                        .findElement(By
                                .cssSelector("li[data-test-id^='home-team-tab-section'] a[href$='account']")
                        ).click();
                break;
            }
        }
        return new TeamPage();
    }
}
