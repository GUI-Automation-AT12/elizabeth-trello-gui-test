package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.Context.Context;
import org.fundacionjala.trello.ui.gui.pages.*;
import org.testng.asserts.SoftAssert;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class UserStepDefs {

    private TrelloLoginPage trelloLoginPage;
    private AtlassianLoginPage atlassianLoginPage;
    private BoardsPage boardsPage;
    private ProfilePage profilePage;
    private Context context;

    /**
     * Constructor.
     * @param contextDI
     */
    public UserStepDefs(final Context contextDI) {
        this.context = contextDI;
    }

    /**
     * Edit user.
     * @param userInformation
     */
    @When("I edit My Profile with the following information")
    public void editMyProfileWithTheFollowingInformation(final Map<String, String> userInformation) {
        profilePage = new ProfilePage();

        //save information in the entity
        context.getUser().processInformation(userInformation);
        //update information by ui
        profilePage.editUserProfile(context.getUser());
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
        Map<String, String> profileInfo = profilePage.getUserInformationAsAMap(context.getUser().getUpdatedFields());
        //Map with the getters of user
        Map<String, String> userInfo = context.getUser().getUpdatedInfo();
        profileInfo.forEach((field, value) ->
                softAssert.assertEquals(value,userInfo.get(field))
        );
        profilePage.waitUntilPageObjectIsLoaded();
        //softAssert.assertTrue(profilePage.getHeaderTextContent().getText().contains(context.user.getUsername()));
        softAssert.assertAll();
    }

}
