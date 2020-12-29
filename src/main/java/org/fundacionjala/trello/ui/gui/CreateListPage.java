package org.fundacionjala.trello.ui.gui;

import org.fundacionjala.trello.core.utils.WebDriverManager;
import org.fundacionjala.trello.ui.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateListPage extends BasePage{

    @FindBy(className = "open-add-list")
    private WebElement buttonAddList;
    @FindBy(className = "list-name-input")
    private WebElement textBoxNameList;
    @FindBy(xpath = "//input[@value='Add List']")
    private WebElement buttonCreateList;

    public CreateListPage() {
        super();
    }

    public String getTitle() {
        return WebDriverManager.getInstance().getWebDriver().getTitle();
    }

    public void clickButtonCreateBoard(final String name) {
        ElementUtil.clickElement(buttonAddList);
        ElementUtil.setElement(textBoxNameList, name);
        ElementUtil.clickElement(buttonCreateList);
    }

}
