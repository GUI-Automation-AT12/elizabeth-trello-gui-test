package org.fundacionjala.trello.ui.gui.popups;

import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.trello.ui.entities.Board;
import org.fundacionjala.trello.ui.gui.pages.BasePage;
import org.fundacionjala.trello.ui.gui.pages.BoardPage;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class CreateBoardPopUp extends BasePage {

    @FindBy(css = "button[data-test-id='header-boards-menu-button']")
    private WebElement buttonBoards;

    @FindBy(xpath = "//button[contains(text(),'Create new board')]")
    private WebElement linkCreateBoard;

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement textBoxNameBoard;

    @FindBy(css = "input[data-test-id='create-board-title-input'] + button")
    private WebElement btnSelectTeam;

    @FindBy(css = "input[data-test-id='create-board-title-input'] + button + button")
    private WebElement btnSelectPrivacy;

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement buttonCreateBoard;

    @FindBy(css = "input[data-test-id='create-board-title-input'] + button span")
    private WebElement spanTeam;

    @FindBy(css = "input[data-test-id='create-board-title-input'] + button + button span")
    private WebElement spanPrivacy;



    /**
     * Constructor.
     */
    public CreateBoardPopUp() {
        super();
    }

    /**
     * Gets title of page.
     * @return title of page
     */
    public String getTitle() {
        return WebDriverManager.getInstance().getWebDriver().getTitle();
    }

    /**
     * Sets value of textBox.
     */
    public void setTextBoxNameBoard(final String name) {
        WebElementUtil.setElement(textBoxNameBoard, name);
    }

    /**
     * Create board by clicking create board button.
     * @param name
     */
    public void clickButtonCreateBoard(final String name) {
        setTextBoxNameBoard(name);
        WebElementUtil.clickElement(buttonCreateBoard);
    }

    /**
     * Create board by clicking create board button.
     * @param value
     * @return webElement
     */
    public void selectValue(final String value) {
        WebElement item = WebDriverManager.getInstance()
                                             .getWebDriver()
                                             .findElement(By.xpath("//button/span[text()="+"'" + value + "']"));
        WebElementUtil.clickElement(item);
    }

    public void setTextSpanTeam(final String spanTeam) {
        WebElementUtil.clickElement(btnSelectTeam);
        selectValue(spanTeam);
    }

    public void setTextSpanPrivacy(String spanPrivacy) {
        WebElementUtil.clickElement(btnSelectPrivacy);
        selectValue(spanPrivacy);
    }

    public String getTextSpanTeam() {
        return WebElementUtil.getTextFromWebElement(spanTeam);
    }

    public String getTextSpanPrivacy() {
        return WebElementUtil.getTextFromWebElement(spanPrivacy);
    }

    /**
     * Create board by clicking create board button.
     */
    public void clickButtonCreateBoard() {
        WebElementUtil.clickElement(buttonCreateBoard);
    }

    public String getValueTextBoxNameBoard() {
        return WebElementUtil.getValue(textBoxNameBoard);
    }

    /**
     * Composes strategy setter map.
     * @param boardInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> boardInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setTextBoxNameBoard(boardInformation.get("name")));
        strategyMap.put("team", () -> setTextSpanTeam(boardInformation.get("team")));
        strategyMap.put("privacy", () -> setTextSpanPrivacy(boardInformation.get("privacy")));
        return strategyMap;
    }

    /**
     * Sets fields with board information.
     * @param board
     */
    public BoardPage createBoard(final Board board) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(board.getUpdatedInfo());
        board.getUpdatedInfo().keySet().forEach(key -> strategyMap.get(key).run());
        clickButtonCreateBoard();
        return new BoardPage();
    }

    /**
     * Composes strategy getter map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> getValueTextBoxNameBoard());
        strategyMap.put("team", () -> getTextSpanTeam());
        strategyMap.put("privacy", () -> getTextSpanPrivacy());
        return strategyMap;
    }

    /**
     * Gets board's information as a map.
     * @param fields
     * @return Map with user's information
     */
    public Map<String, String> getBoardInformationAsAMap(final Set<String> fields) {
        Map<String, String> boardInfo = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetter();
        fields.forEach(field -> boardInfo.put(field, strategyMap.get(field).get()));
        return boardInfo;
    }
}
