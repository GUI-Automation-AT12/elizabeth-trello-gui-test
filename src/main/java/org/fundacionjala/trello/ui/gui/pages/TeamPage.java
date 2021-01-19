package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamPage extends BasePage {

    @FindBy(css = "div.js-current-details h1")
    private WebElement teamName;

    @FindBy(css = "div.js-current-details h1 + span")
    private WebElement teamVisibility;

    @FindBy(css = "div.js-current-details button")
    private WebElement btnEditTeam;

    @FindBy(css = "a[data-tab='boards']")
    private WebElement boardsTab;

    @FindBy(css = "a[data-tab='members']")
    private WebElement membersTab;

    @FindBy(css = "a[data-tab='settings']")
    private WebElement settingsTab;

    @FindBy(css = "a[data-tab='businessClass']")
    private WebElement businessClassTab;

    /**
     * Constructor.
     */
    public TeamPage() {
        super();
    }

    /**
     * Gets name of Team.
     * @return name of Team created
     */
    public String getTeamNameCreated() {
        WebElementUtil.waitUntilElementIsLoaded(btnEditTeam);
        return WebElementUtil.getTextFromWebElement(teamName);
    }

    /**
     * Waits until page is loaded.
     */
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsVisible(btnEditTeam);
    }

    /**
     * Gets teamVisibility of team.
     * @return teamVisibility of team created
     */
    public String getTeamVisibilityCreated() {
        return WebElementUtil.getTextFromWebElement(teamVisibility);
    }
    /**
     * Clicks Edit button.
     * @return page
     */
    public EditTeamPage clickBtnEditTeam() {
        WebElementUtil.clickElement(btnEditTeam);
        return new EditTeamPage();
    }
}
