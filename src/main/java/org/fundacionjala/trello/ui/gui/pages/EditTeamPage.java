package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.entities.Team;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class EditTeamPage extends BasePage {
    @FindBy(id = "displayName")
    private WebElement name;

    @FindBy(id = "name")
    private WebElement shortName;

    @FindBy(id = "website")
    private WebElement website;

    @FindBy(id = "desc")
    private WebElement description;

    @FindBy(css = "form[id='organization-detail-form'] button[type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(css = "form[id='organization-detail-form'] button[type=\"button\"]")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@id='teamTypeSelect']/parent::div/parent::div/parent::div")
    private WebElement dropdown;

    private String type;
    private String typeOfTeam = "//*[contains(text(),'%s')]";

    /**
     * Constructor.
     */
    public EditTeamPage() {
        super();
    }

    /**
     * set name.
     * @param newName
     */
    private void setName(final String newName) {
        WebElementUtil.setElement(name, newName);
    }

    /**
     * set short name.
     * @param newShortName
     */
    private void setShortName(final String newShortName) {
        WebElementUtil.setElement(this.shortName, newShortName);
    }

    /**
     * set website.
     * @param newWebsite
     */
    private void setWebsite(final String newWebsite) {
        WebElementUtil.setElement(this.website, newWebsite);
    }

    /**
     * set description.
     * @param newDescription
     */
    private void setDesc(final String newDescription) {
        WebElementUtil.setElement(this.description, newDescription);
    }

    /**
     *
     * @return name.
     */
    public String getName() {
        return WebElementUtil.getValue(name);
    }

    /**
     *
     * @return short name.
     */
    public String getShortName() {
        return WebElementUtil.getValue(shortName);
    }

    /**
     *
     * @return website.
     */
    public String getWebsite() {
        return WebElementUtil.getValue(website);
    }

    /**
     *
     * @return description.
     */
    public String getDescription() {
        return WebElementUtil.getValue(description);
    }

    /**
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param newType
     */
    public void setType(final String newType) {
        this.type = newType;
    }

    /**
     * Selects an element from a html select tag.
     * @param newtype
     */
    public void selectDropDownOptionByName(final String newtype) {
        WebElementUtil.clickElement(dropdown);
        By dropDownTeam = By.xpath(String.format(typeOfTeam, newtype));
        WebElementUtil.clickElement(dropDownTeam);
        setType(newtype);
    }

    /**
     * Sets fields with team information.
     * @param team
     * @return page.
     */
    public TeamPage editATeam(final Team team) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(team.getUpdatedInfo());
        team.getUpdatedInfo().keySet().forEach(key -> strategyMap.get(key).run());
        WebElementUtil.clickElement(submitButton);
        return new TeamPage();
    }

    /**
     * Compose a strategy map.
     * @param teamInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setName(teamInformation.get("name")));
        strategyMap.put("type", () -> selectDropDownOptionByName(teamInformation.get("type")));
        strategyMap.put("description", () -> setDesc(teamInformation.get("description")));
        strategyMap.put("website", () -> setWebsite(teamInformation.get("website")));
        strategyMap.put("shortName", () -> setShortName(teamInformation.get("shortName")));
        return strategyMap;
    }

    /**
     * Composes strategy getter map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> getName());
        strategyMap.put("type", () -> getType());
        strategyMap.put("description", () -> getDescription());
        strategyMap.put("website", () -> getWebsite());
        strategyMap.put("shortName", () -> getShortName());
        return strategyMap;
    }

    /**
     * Gets team information as a map.
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
