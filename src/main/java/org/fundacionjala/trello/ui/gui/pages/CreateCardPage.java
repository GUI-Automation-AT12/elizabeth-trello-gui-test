package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCardPage extends BasePage {

    @FindBy(css = "a.js-add-card")
    private WebElement buttonAddCard;

    @FindBy(className = "list-card-composer-textarea")
    private WebElement textBoxNameCard;

    @FindBy(css = "input[value='Add Card']")
    private WebElement buttonCreateCard;

    /**
     * Constructor.
     */
    public CreateCardPage() {
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
     * Creates a card by clicking create card button.
     * @param name
     */
    public void clickButtonCreateCard(final String name) {
        WebElementUtil.clickElement(buttonAddCard);
        WebElementUtil.setElement(textBoxNameCard, name);
        WebElementUtil.clickElement(buttonCreateCard);
    }
}
