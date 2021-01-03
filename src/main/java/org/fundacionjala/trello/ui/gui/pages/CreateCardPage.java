package org.fundacionjala.trello.ui.gui.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.ui.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCardPage extends BasePage {

    @FindBy(xpath = "//h2[text()='List 1']/parent::div/following-sibling::div/a[contains(.,'Add')]")
    private WebElement buttonAddCard;
    @FindBy(className = "list-card-composer-textarea")
    private WebElement textBoxNameCard;
    @FindBy(xpath = "//input[@value='Add Card']")
    private WebElement buttonCreateCard;

    public CreateCardPage() {
        super();
    }

    public String getTitle() {
        return WebDriverManager.getInstance().getWebDriver().getTitle();
    }

    public void clickButtonCreateBoard(final String name) {
        WebElementUtil.clickElement(buttonAddCard);
        WebElementUtil.setElement(textBoxNameCard, name);
        WebElementUtil.clickElement(buttonCreateCard);
    }
}
