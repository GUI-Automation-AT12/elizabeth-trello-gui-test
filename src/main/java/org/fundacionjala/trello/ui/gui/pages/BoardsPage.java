package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPage extends BasePage {

    @FindBy(css = "button[data-test-id='header-member-menu-logout']/span")
    private WebElement btnLogout;

    @FindBy(css = "button[data-test-id='header-member-menu-button']")
    private WebElement btnMenu;

    /**
     * Constructor.
     */
    public BoardsPage() {
        super();
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
}
