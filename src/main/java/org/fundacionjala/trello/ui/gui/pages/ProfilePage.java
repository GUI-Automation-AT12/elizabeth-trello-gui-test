package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.entities.User;
import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class ProfilePage extends BasePage{

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement btnSave;

    @FindBy(xpath = "//input[@*='username']")
    private WebElement usernameTextBox;

    @FindBy(xpath = "//span[text()='Bio']/parent::div/following-sibling::textarea")
    private WebElement bioTextarea;

    @FindBy(xpath = "//button[@*='header-member-menu-button']")
    private WebElement btnMenu;

    @FindBy(xpath = "//div[@id='layer-manager-alert']/div")
    private WebElement messageSuccess;

    @FindBy(css = "div.tabbed-pane-header span:nth-child(2)")
    private WebElement headerTextContent;

    public ProfilePage() {
        super();
    }

    public void clickBtnSave() {
        WebElementUtil.clickElement(btnSave);
    }

    public void setUsernameTextBox(final String username) {
        WebElementUtil.setElement(usernameTextBox, username);
    }

    public void setBioTextarea(final String bio) {
        WebElementUtil.setElement(bioTextarea, bio);
    }

    public void clickBtnMenu() {
        WebElementUtil.clickElement(btnMenu);
    }

    public void waitUntilPageObjectIsLoaded() {
        WebElementUtil.waitUntilElementIsLoaded(btnMenu);
    }

    public void editUserProfile(final String username , final String bio) {
        this.setUsernameTextBox(username);
        this.setBioTextarea(bio);
        this.clickBtnSave();
    }

    public WebElement getHeaderTextContent() {
        WebElementUtil.waitUntilElementIsLoaded(headerTextContent);
        return headerTextContent;
    }

    public WebElement getUsernameTextBox() {
        return usernameTextBox;
    }

    public WebElement getBioTextarea() {
        return bioTextarea;
    }

    public boolean isDisplayedMessageSuccess() {
        return messageSuccess.isDisplayed();
    }

    public void editUserProfile(User user) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(user.getUpdatedInfo());
        user.getUpdatedInfo().keySet().forEach(key -> strategyMap.get(key).run());
        clickBtnSave();
    }

    private HashMap<String, Runnable> composeStrategySetter(Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> setUsernameTextBox(userInformation.get("username")));
        strategyMap.put("bio", () -> setBioTextarea(userInformation.get("bio")));
        return strategyMap;
    }
}
