package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateListPage extends BasePage {

    @FindBy(className = "open-add-list")
    private WebElement buttonAddList;

    @FindBy(className = "list-name-input")
    private WebElement textBoxNameList;

    @FindBy(css = "input[value='Add List']")
    private WebElement buttonCreateList;

    /**
     * Constructor.
     */
    public CreateListPage() {
        super();
    }

    /**
     * Gets title page.
     * @return title
     */
    public String getTitle() {
        return WebDriverManager.getInstance().getWebDriver().getTitle();
    }

    /**
     * Creates a list by clicking create list button.
     * @param name
     */
    public void clickButtonCreateList(final String name) {
        WebElementUtil.clickElement(buttonAddList);
        WebElementUtil.setElement(textBoxNameList, name);
        WebElementUtil.clickElement(buttonCreateList);
    }

}
