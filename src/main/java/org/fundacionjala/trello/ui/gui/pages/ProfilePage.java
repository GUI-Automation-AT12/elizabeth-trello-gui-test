package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.entities.User;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class ProfilePage extends BasePage {

    @FindBy(css = "div[data-test-id='profile-tab-container'] button")
    private WebElement btnSave;

    @FindBy(name = "username")
    private WebElement usernameTextBox;

    @FindBy(css = "div[data-test-id='profile-tab-container'] textarea")
    private WebElement bioTextarea;

    @FindBy(css = "button[data-test-id='header-member-menu-button']")
    private WebElement btnMenu;

    @FindBy(id = "layer-manager-alert")
    private WebElement messageSuccess;

    @FindBy(css = "div.tabbed-pane-header span:nth-child(2)")
    private WebElement headerTextContent;

    private Set<String> updatedFields = new HashSet<>();

    /**
     * Constructor.
     */
    public ProfilePage() {
        super();
    }

    /**
     * Clicks save button.
     */
    public void clickBtnSave() {
        WebElementUtil.clickElement(btnSave);
    }

    /**
     * Sets username textBox.
     * @param username
     */
    public void setUsernameTextBox(final String username) {
        WebElementUtil.setElement(usernameTextBox, username);
    }

    /**
     * Sets bio textarea.
     * @param bio
     */
    public void setBioTextarea(final String bio) {
        WebElementUtil.setElement(bioTextarea, bio);
    }

    /**
     * Clicks Menu button.
     */
    public void clickBtnMenu() {
        WebElementUtil.clickElement(btnMenu);
    }

    /**
     * Waits until page is loaded.
     */
    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnMenu);
    }

    /**
     * Edits user by clicking save button.
     * @param username
     * @param bio
     */
    public void editUserProfile(final String username, final String bio) {
        this.setUsernameTextBox(username);
        this.setBioTextarea(bio);
        this.clickBtnSave();
    }

    /**
     * Gets Header text.
     * @return header text.
     */
    public WebElement getHeaderTextContent() {
        WebElementUtil.waitUntilElementIsLoaded(headerTextContent);
        return headerTextContent;
    }

    /**
     * Gets WebElement username textBox.
     * @return username TextBox
     */
    public WebElement getUsernameTextBox() {
        return usernameTextBox;
    }

    /**
     * Gets value of username textBox.
     * @return value of username textBox
     */
    public String getValueUsernameTextBox() {
        return WebElementUtil.getValue(usernameTextBox);
    }

    /**
     * Gets WebElement bio Textarea.
     * @return bio Textarea
     */
    public WebElement getBioTextarea() {
        return bioTextarea;
    }

    /**
     * Gets value of bio Textarea.
     * @return value of bio Textarea
     */
    public String getValueBioTextarea() {
        return WebElementUtil.getValue(bioTextarea);
    }

    /**
     * Verify if Message is displayed.
     * @return if the message is displayed
     */
    public boolean isDisplayedMessageSuccess() {
        return messageSuccess.isDisplayed();
    }

    /**
     * Composes strategy setter map.
     * @param userInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> setUsernameTextBox(userInformation.get("username")));
        strategyMap.put("bio", () -> setBioTextarea(userInformation.get("bio")));
        return strategyMap;
    }

    /**
     * Sets fields with user information.
     * @param user
     */
    public void editUserProfile(final User user) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(user.getUpdatedInfo());
        user.getUpdatedInfo().keySet().forEach(key -> strategyMap.get(key).run());
        clickBtnSave();
    }

    /**
     * Composes strategy getter map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> getValueUsernameTextBox());
        strategyMap.put("bio", () -> getValueBioTextarea());
        return strategyMap;
    }

    /**
     * Gets user's information as a map.
     * @param fields
     * @return Map with user's information
     */
    public Map<String, String> getUserInformationAsAMap(final Set<String> fields) {
        Map<String, String> userInfo = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetter();
        fields.forEach(field -> userInfo.put(field, strategyMap.get(field).get()));
        return userInfo;
    }
}
