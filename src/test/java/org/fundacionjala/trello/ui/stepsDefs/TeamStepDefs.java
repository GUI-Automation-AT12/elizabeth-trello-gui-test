package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.trello.ui.Context.Context;
import org.fundacionjala.trello.ui.entities.Team;
import org.fundacionjala.trello.ui.gui.pages.BoardsPage;
import org.fundacionjala.trello.ui.gui.pages.EditTeamPage;
import org.fundacionjala.trello.ui.gui.pages.TeamPage;
import org.fundacionjala.trello.ui.gui.popups.*;
import org.testng.Assert;

import java.util.Map;

public class TeamStepDefs {

    private Context context;
    private BoardsPage boardsPage = new BoardsPage();
    private BoardMenuPopUp boardMenuPopUp;
    private MessageClosePage messageClosePage;
    private MessageDeletePage messageDeletePage;
    private CreateTeamPopUp createTeamPopUp;
    private TeamPage teamPage;

    /**
     * Constructor.
     * @param sharedContext
     */
    public TeamStepDefs(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Create a new team.
     * @param teamInformation
     */
    @When("I create a team with the following information")
    public void createATeamWithTheFollowingInformation(final Map<String, String> teamInformation) {
        context.team = new Team();
        //context.team.setMembers(teamInformation.get("members"));
        context.team.processInformation(teamInformation);
        createTeamPopUp = boardsPage.getTopMenu().getCreateTeamPage();
        createTeamPopUp.waitUntilPageObjectIsLoaded();
        teamPage = createTeamPopUp.createATeam(context.team);
    }

    /**
     * Verify new team is created.
     */
    @Then("The team name should be displayed on Team Page")
    public void verifyBoardNameIsDisplayed() {
        teamPage.waitUntilPageObjectIsLoaded();
        String expectedName = context.team.getTeamName();
        context.team.setId(WebDriverManager.getInstance().getWebDriver().getCurrentUrl());
        String actualName = teamPage.getTeamNameCreated();
        Assert.assertEquals(actualName, expectedName);
    }

    /**
     * Verify new team is created.
     */
    @Then("{string} message should be displayed on Team Page")
    public void verifyMessageShouldBeDisplayed(String message) {
        Assert.assertEquals(message,messageDeletePage.getTextMessage());
    }

    /**
     * Verify new team is created.
     */
    @When("I select a specific team")
    public void selectASpecificTeam() {
        boardsPage.waitUntilPageObjectIsLoaded();
        teamPage = boardsPage.selectATeam(context.team.getShortName());
        teamPage.waitUntilPageObjectIsLoaded();
    }

    @And("I edit the Team information with the following information")
    public void editTheTeamInformation(final Map<String, String> teamInformation) {
        EditTeamPage editTeamPage = teamPage.clickBtnEditTeam();
        //save information in the entity
        context.team.processInformation(teamInformation);
        //update information by ui
        teamPage = editTeamPage.editATeam(context.team);
    }

    @Then("The team name should be updated on Team Page")
    public void verifyTheTeamSNameShouldBeUpdated() {
        teamPage.waitUntilPageObjectIsLoaded();
        String expectedName = context.team.getTeamName();
        //context.team.setId(context.team.getShortName());
        System.out.println(context.team.getId());
        String actualName = teamPage.getTeamNameCreated();
        Assert.assertEquals(actualName, expectedName);
    }
}
