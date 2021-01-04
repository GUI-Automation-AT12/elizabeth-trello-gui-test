package org.fundacionjala.trello.ui.gui.component;

import org.fundacionjala.trello.ui.gui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage {

    @FindBy(css = "a[data-test-id='header-home-button]")
    private WebElement btnHome;

    @FindBy(css = "input[data-test-id='header-search-input]")
    private WebElement searchInput;

    @FindBy(css = "a[aria-label='Back to Home']")
    private WebElement linkHome;

    @FindBy(css = "button[data-test-id='header-create-button]")
    private WebElement btnCreate;

    @FindBy(css = "button[data-test-id='header-info-button]")
    private WebElement btnInfo;

    @FindBy(css = "button[data-test-id='header-notification-button]")
    private WebElement btnNotification;

    @FindBy(css = "button[data-test-id='header-member-menu-button]")
    private WebElement btnMemberMenu;

    /**
     * Constructor.
     */
    public TopMenu() {
        super();
    }

    /**
     * Gets WebElement Home button.
     * @return btnHome
     */
    public WebElement getBtnHome() {
        return btnHome;
    }

    /**
     * Gets WebElement search input.
     * @return searchInput
     */
    public WebElement getSearchInput() {
        return searchInput;
    }

    /**
     * Gets WebElement Home link.
     * @return linkHome
     */
    public WebElement getLinkHome() {
        return linkHome;
    }

    /**
     * Gets WebElement Create button.
     * @return btnCreate
     */
    public WebElement getBtnCreate() {
        return btnCreate;
    }

    /**
     * Gets WebElement Info button.
     * @return btnInfo
     */
    public WebElement getBtnInfo() {
        return btnInfo;
    }

    /**
     * Gets WebElement Notification button.
     * @return btnNotification
     */
    public WebElement getBtnNotification() {
        return btnNotification;
    }

    /**
     * Gets WebElement MemberMenu button.
     * @return btnMemberMenu
     */
    public WebElement getBtnMemberMenu() {
        return btnMemberMenu;
    }
}
