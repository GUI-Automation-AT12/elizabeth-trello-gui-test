package org.fundacionjala.trello.ui.gui.popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPopUp {
    @FindBy(css = "a[data-test-id='header-member-menu-profile']")
    private WebElement btnMenuProfile;

    @FindBy(css = "a[data-test-id='header-member-menu-cards']")
    private WebElement btnMenuCards;

    /**
     * Constructor.
     */
    public AccountPopUp() {
        super();
    }

    /**
     * Gets Menu profile button.
     * @return Menu profile button
     */
    public WebElement getBtnMenuProfile() {
        return btnMenuProfile;
    }

    /**
     * Gets Menu cards button.
     * @return Menu cards button
     */
    public WebElement getBtnMenuCards() {
        return btnMenuCards;
    }
}
