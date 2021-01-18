package org.fundacionjala.trello.ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.fundacionjala.trello.ui.Context.Context;
import org.fundacionjala.trello.api.utils.TeamHelper;
import org.fundacionjala.trello.ui.entities.Team;

public class TeamHooks {
    private Context context;

    public TeamHooks(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Deletes a Team
     */
    @After(value = "@DeleteTeam", order = 3)
    public void deleteTeam(){
        TeamHelper.deleteTeam(context.team);
    }

    /**
     * Creates a Team
     */
    @Before(value = "@CreateTeam", order = 0)
    public void createTeam(){
        context.team = new Team();
        context.team = TeamHelper.createTeam();
    }
}
