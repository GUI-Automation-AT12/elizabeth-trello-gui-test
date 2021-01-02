package org.fundacionjala.trello.ui.gui.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu {

    @FindBy(css = "a[data-test-id='header-home-button]" )
    private WebElement btnHome;

    @FindBy(css = "input[data-test-id='header-search-input]" )
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

    public TopMenu() {
        super();
    }

    public WebElement getBtnHome() {
        return btnHome;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getLinkHome() {
        return linkHome;
    }

    public WebElement getBtnCreate() {
        return btnCreate;
    }

    public WebElement getBtnInfo() {
        return btnInfo;
    }

    public WebElement getBtnNotification() {
        return btnNotification;
    }

    public WebElement getBtnMemberMenu() {
        return btnMemberMenu;
    }
}
