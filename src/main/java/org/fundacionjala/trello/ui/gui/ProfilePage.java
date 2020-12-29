package org.fundacionjala.trello.ui.gui;

import org.fundacionjala.trello.ui.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement btnLoginSubmit;

    @FindBy(xpath = "//input[@*='username']")
    private WebElement usernameTextBox;

    @FindBy(xpath = "//span[text()='Bio']/parent::div/following-sibling::textarea")
    private WebElement bioTextarea;

    @FindBy(xpath = "//button[@*='header-member-menu-button']")
    private WebElement btnMenu;

    @FindBy(xpath = "//div[@class='tabbed-pane-header']/*/*/*/*/span[2]")
    private WebElement headerSpan;


    public ProfilePage() {
        super();
    }

    public void clickBtnLoginSubmit() {
        ElementUtil.clickElement(btnLoginSubmit);
    }

    public void setUsernameTextBox(final String username) {
        ElementUtil.setElement(usernameTextBox, username);
    }

    public void setBioTextarea(final String bio) {
        ElementUtil.setElement(bioTextarea, bio);
    }

    public void clickBtnMenu() {
        ElementUtil.clickElement(btnMenu);
    }

    public void editUserProfile(final String username , final String bio) {
        this.setUsernameTextBox(username);
        this.setBioTextarea(bio);
        this.clickBtnLoginSubmit();
    }

    public WebElement getHeaderSpan() {
        return headerSpan;
    }
}
