package org.fundacionjala.trello.ui.gui.component;

import org.fundacionjala.trello.ui.gui.pages.BasePage;
import org.fundacionjala.trello.ui.gui.popups.CreateBoardPopUp;
import org.fundacionjala.trello.ui.gui.popups.AccountPopUp;
import org.fundacionjala.trello.ui.gui.popups.CreateTeamPopUp;
import org.fundacionjala.core.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage {

    @FindBy(css = "a[data-test-id='header-home-button']")
    private WebElement btnHome;

    @FindBy(css = "input[data-test-id='header-search-input']")
    private WebElement searchInput;

    @FindBy(css = "a[aria-label='Back to Home']")
    private WebElement linkHome;

    @FindBy(css = "button[data-test-id='header-info-button']")
    private WebElement btnInfo;

    @FindBy(css = "button[data-test-id='header-notification-button']")
    private WebElement btnNotification;

    @FindBy(css = "button[data-test-id='header-member-menu-button']")
    private WebElement btnMemberMenu;

    //CreateComponentPopup
    @FindBy(css = "button[data-test-id='header-create-menu-button']")
    private WebElement btnCreate;

    @FindBy(css = "button[data-test-id='header-create-board-button']")
    private WebElement btnCreateBoard;

    @FindBy(css = "button[data-test-id='header-create-team-button']")
    private WebElement btnCreateTeam;

    private CreateBoardPopUp createBoardPage;
    private AccountPopUp accountPopUp;

    /**
     * Constructor.
     */
    public TopMenu() {
        super();
        createBoardPage = new CreateBoardPopUp();
        accountPopUp = new AccountPopUp();
    }

    /**
     * Gets WebElement Home button.
     * @return btnHome
     */
    public WebElement getBtnHome() {
        return btnHome;
    }

    /**
     * Gets WebElement search input.
     * @return searchInput
     */
    public WebElement getSearchInput() {
        return searchInput;
    }

    /**
     * Gets WebElement Home link.
     * @return linkHome
     */
    public WebElement getLinkHome() {
        return linkHome;
    }

    /**
     * Gets WebElement Create button.
     * @return btnCreate
     */
    public WebElement getBtnCreate() {
        return btnCreate;
    }

    /**
     * Gets WebElement Info button.
     * @return btnInfo
     */
    public WebElement getBtnInfo() {
        return btnInfo;
    }

    /**
     * Gets WebElement Notification button.
     * @return btnNotification
     */
    public WebElement getBtnNotification() {
        return btnNotification;
    }

    /**
     * Gets WebElement MemberMenu button.
     * @return btnMemberMenu
     */
    public WebElement getBtnMemberMenu() {
        return btnMemberMenu;
    }

    /**
     * Gets WebElement MemberMenu button.
     * @return btnMemberMenu
     */
    public AccountPopUp clickBtnMemberMenu() {
        WebElementUtil.clickElement(btnMemberMenu);
        return accountPopUp;
    }

    /**
     * Gets WebElement MemberMenu button.
     * @return btnMemberMenu
     */
    public CreateBoardPopUp getCreateBoardPage() {
        WebElementUtil.clickElement(btnCreate);
        WebElementUtil.clickElement(btnCreateBoard);
        return new CreateBoardPopUp();
    }

    /**
     * Gets WebElement MemberMenu button.
     * @return btnMemberMenu
     */
    public CreateTeamPopUp getCreateTeamPage() {
        WebElementUtil.clickElement(btnCreate);
        WebElementUtil.clickElement(btnCreateTeam);
        return new CreateTeamPopUp();
    }
}
