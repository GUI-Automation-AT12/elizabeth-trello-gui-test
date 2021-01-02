package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.ui.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPage extends BasePage {

    @FindBy(xpath = "//button[@*='header-member-menu-logout']/span")
    private WebElement btnLogout;

    @FindBy(xpath = "//button[@*='header-member-menu-button']")
    private WebElement btnMenu;

    public BoardsPage (){
        super();
    }

    public void waitUntilPageObjectIsLoaded() {
        ElementUtil.waitUntilPageIsLoaded(btnMenu);
    }

    public WebElement getBtnLogout() {
        return btnLogout;
    }

    public void clickBtnMenu() {
        ElementUtil.clickElement(btnMenu);
    }
}
