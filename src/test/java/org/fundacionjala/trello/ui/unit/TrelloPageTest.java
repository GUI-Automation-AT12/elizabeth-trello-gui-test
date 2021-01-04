package org.fundacionjala.trello.ui.unit;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.ui.gui.pages.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.pages.BoardsPage;
import org.fundacionjala.trello.ui.gui.pages.InitialPage;
import org.fundacionjala.trello.ui.gui.pages.TrelloLoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrelloPageTest {

    private String pageUrl = "https://trello.com/";
    private String pageLogin = "https://trello.com/usuario87/boards";
    private InitialPage initialPage;
    private AtlassianLoginPage atlassianLoginPage;
    private TrelloLoginPage trelloLoginPage;
    private BoardsPage boardsPage;

    /**
     * Redirects to initial page.
     */
    @Before
    public void setUp() {
        WebDriverManager.getInstance().getWebDriver().get(pageUrl);
    }

    /**
     * Closes browser.
     */
    @After
    public void tearDown() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }

    /**
     * Tests login to the application.
     */
    @Test
    public void testLogin() {
        initialPage = new InitialPage();
        trelloLoginPage = initialPage.clickOnButtonLogin();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian("trello.proy1234@gmail.com");
        boardsPage = atlassianLoginPage.loginTrello("TrelloGUI567890");
        boardsPage.clickBtnMenu();
        assertEquals(boardsPage.getBtnLogout().getText(),"Log Out");
    }
}
