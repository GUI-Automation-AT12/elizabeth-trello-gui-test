package org.fundacionjala.trello.ui.gui.popups;

import org.fundacionjala.trello.ui.gui.pages.BasePage;
import org.fundacionjala.trello.ui.gui.pages.ProfilePage;
import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPopUp extends BasePage {

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
     * Clicks button menu profile.
     */
    public ProfilePage getProfilePage() {
        WebElementUtil.clickElement(btnMenuProfile);
        return new ProfilePage();
    }

    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnMenuProfile);
    }

    /**
     * Gets Menu cards button.
     * @return Menu cards button
     */
    public WebElement getBtnMenuCards() {
        return btnMenuCards;
    }


}
