package org.fundacionjala.trello.ui.unit;

import org.fundacionjala.trello.core.utils.WebDriverManager;
import org.fundacionjala.trello.ui.gui.AtlassianLoginPage;
import org.fundacionjala.trello.ui.gui.BoardsPage;
import org.fundacionjala.trello.ui.gui.InitialPage;
import org.fundacionjala.trello.ui.gui.TrelloLoginPage;
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

    @Before
    public void setUp() {
        WebDriverManager.getInstance().getWebDriver().get(pageUrl);
    }
    @After
    public void tearDown() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }

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
