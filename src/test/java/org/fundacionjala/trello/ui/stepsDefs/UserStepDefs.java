package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.config.Environment;
import org.fundacionjala.trello.ui.entities.User;
import org.fundacionjala.trello.ui.gui.pages.*;
import org.fundacionjala.trello.ui.utils.PageTransporter;
import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class UserStepDefs {

    private TrelloLoginPage trelloLoginPage;
    private AtlassianLoginPage atlassianLoginPage;
    private BoardsPage boardsPage;
    private ProfilePage profilePage;
    private final User user = new User();

    /**
     * Login to Trello with valid credentials.
     * @throws MalformedURLException
     */
    @Given("I log in Trello with valid Credentials")
    public void iLogInTrelloWithValidCredentials() throws MalformedURLException {
        PageTransporter.navigateToPage("login");
        trelloLoginPage = new TrelloLoginPage();
        atlassianLoginPage = trelloLoginPage.clickButtonLoginWithAtlassian(Environment.getInstance().getUsername());
        atlassianLoginPage.waitUntilPageObjectIsLoaded();
        boardsPage = atlassianLoginPage.loginTrello(Environment.getInstance().getPassword());
        boardsPage.waitUntilPageObjectIsLoaded();
    }

    /**
     * Edit user.
     * @param userInformation
     */
    @When("I edit My Profile with the following information")
    public void iEditMyProfileWithTheFollowingInformation(final Map<String, String> userInformation) {
        profilePage = new ProfilePage();
        //save information in the entity
        user.processInformation(userInformation);
        //update information by ui
        profilePage.editUserProfile(user);
    }

    /**
     * Verify message of information updated.
     * @param message
     */
    @Then("{string} message should be displayed in My Profile and Visibility section")
    public void verifyMessageShouldBeDisplayedInMyProfileSection(String message) {
        assertTrue(message, profilePage.isDisplayedMessageSuccess());
    }

    /**
     * Verify user's information after update.
     */
    @Then("the user information should be updated in My Profile and Visibility section")
    public void verifyTheUserInformationShouldBeUpdatedInMyProfileSection() {
        SoftAssert softAssert = new SoftAssert();
        //Gets information of fields edited.
        Map<String, String> profileInfo = profilePage.getUserInformationAsAMap(user.getUpdatedFields());
        //Map with the getters of user
        Map<String, String> userInfo = user.getUpdatedInfo();
        profileInfo.forEach((field, value) ->
                softAssert.assertEquals(value,userInfo.get(field))
        );
        softAssert.assertTrue(profilePage.getHeaderTextContent().getText().contains(user.getUsername()));
        softAssert.assertAll();
    }
}
