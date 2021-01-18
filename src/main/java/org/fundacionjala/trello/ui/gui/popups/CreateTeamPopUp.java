package org.fundacionjala.trello.ui.gui.popups;

import org.fundacionjala.trello.ui.entities.Team;
import org.fundacionjala.trello.ui.gui.pages.BasePage;
import org.fundacionjala.trello.ui.gui.pages.TeamPage;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class CreateTeamPopUp extends BasePage {
    @FindBy(css = "input[data-test-id='header-create-team-name-input']")
    private WebElement teamNameTextBox;

    @FindBy(css = "id#teamTypeSelect")
    private WebElement teamTypeSelect;

    @FindBy(css = "div[data-test-id='header-create-team-type-input'] div")
    private WebElement btnSelectType;

    @FindBy(css = "textarea[id$='create-team-org-description']")
    private WebElement descriptionTextarea;

    @FindBy(css = "button[data-test-id='header-create-team-submit-button']")
    private WebElement btnCreateTeam;

    private String typeOfTeam = "//*[contains(text(),'%s')]";

    /**
     * Members Team
     */


    @FindBy(css = "div[data-test-id='header-create-team-type-input']")
    private WebElement dropDownTeamType;

    @FindBy(css = "input[data-test-id='add-members-input']")
    private WebElement membersTextBox;

    @FindBy(css = "button[data-test-id='team-invite-submit-button']")
    private WebElement btnInviteToTeam;

    @FindBy(css = "a[data-test-id='show-later-button']")
    private WebElement btnWillDoLater;

    /**
     * Constructor.
     */
    public CreateTeamPopUp() {
        super();
    }

    /**
     * Gets team name of page.
     * @return team name
     */
    public String getValueTeamNameTextBox() {
        return WebElementUtil.getValue(teamNameTextBox);
    }

    public void selectDropDownOptionByName(final String optionName) {
        By dropDownTeam = By.xpath(String.format(typeOfTeam, optionName));
        WebElementUtil.clickElement(dropDownTeam);
    }

    /**
     * Sets value of textBox.
     */
    public void setTeamNameTextBox(final String name) {
        WebElementUtil.setElement(teamNameTextBox, name);
    }

    /**
     * Gets team type WebElement.
     * @return teamTypeSelect
     */
    public String getValueTeamTypeSelect() {
        return WebElementUtil.getValue(teamNameTextBox);
    }

    /**
     * Sets value of textBox.
     */
    public void setTeamTypeSelect(String teamType) {
        WebElementUtil.clickElement(dropDownTeamType);
        selectDropDownOptionByName(teamType);
    }

    /**
     * Gets description textarea of page.
     * @return descriptionTextarea
     */
    public String getValueDescriptionTextarea() {
        return WebElementUtil.getValue(descriptionTextarea);
    }

    /**
     * Sets value of textarea.
     */
    public void setDescriptionTextarea(final String desc) {
        WebElementUtil.setElement(descriptionTextarea, desc);
    }
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(teamNameTextBox);
    }

    /**
     * Gets title of page.
     * @return title of page
     */
    public String getValueMembersTextBox() {
        return WebElementUtil.getValue(membersTextBox);
    }

    /**
     * Gets title of page.
     * @return title of page
     */
    public void setMembersTextBox(WebElement membersTextBox) {
        this.membersTextBox = membersTextBox;
    }

    /**
     * Clicks create team button.
     */
    public void clickButtonCreateTeam() {
        WebElementUtil.clickElement(btnCreateTeam);
    }

    /**
     * Clicks create team button.
     */
    public void clickButtonWillDoLater() {
        WebElementUtil.clickElement(btnWillDoLater);
    }
    /**
     * Composes strategy setter map.
     * @param teamInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setTeamNameTextBox(teamInformation.get("name")));
        strategyMap.put("type", () -> setTeamTypeSelect(teamInformation.get("type")));
        strategyMap.put("description", () -> setDescriptionTextarea(teamInformation.get("description")));
        return strategyMap;
    }

    /**
     * Sets fields with team information.
     * @param team
     */
    public TeamPage createATeam(final Team team) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(team.getUpdatedInfo());
        team.getUpdatedInfo().keySet().forEach(key -> strategyMap.get(key).run());
        clickButtonCreateTeam();
        clickButtonWillDoLater();
        return new TeamPage();
    }

    /**
     * Composes strategy getter map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> getValueTeamNameTextBox());
        strategyMap.put("type", () -> getValueTeamTypeSelect());
        strategyMap.put("description", () -> getValueDescriptionTextarea());
        return strategyMap;
    }

    /**
     * Gets board's information as a map.
     * @param fields
     * @return Map with user's information
     */
    public Map<String, String> getBoardInformationAsAMap(final Set<String> fields) {
        Map<String, String> teamInfo = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetter();
        fields.forEach(field -> teamInfo.put(field, strategyMap.get(field).get()));
        return teamInfo;
    }
}
