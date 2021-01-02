package org.fundacionjala.trello.ui.gui.popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPopUp {
    @FindBy(css = "a[data-test-id='header-member-menu-profile']" )
    private WebElement btnMenuProfile;

    @FindBy(css = "a[data-test-id='header-member-menu-cards']" )
    private WebElement btnMenuCards;

    public AccountPopUp() {
        super();
    }

    public WebElement getBtnMenuProfile() {
        return btnMenuProfile;
    }

    public WebElement getBtnMenuCards() {
        return btnMenuCards;
    }
}
