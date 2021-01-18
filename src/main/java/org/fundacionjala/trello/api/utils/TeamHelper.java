package org.fundacionjala.trello.api.utils;

import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.trello.ui.entities.Team;
import org.fundacionjala.trello.api.utils.AuthenticationUtils;
import org.json.simple.JSONObject;

public class TeamHelper {

    public static void deleteTeam(final Team team){
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        if(team.getId().contains("/")){
            String[] endpointSplit = team.getId().split("/");
            System.out.println("organizations/" + endpointSplit[endpointSplit.length - 1]);

            RequestManager.delete("organizations/" + endpointSplit[endpointSplit.length - 1]);
        } else {
            RequestManager.delete("organizations/" + team.getId());
        }
    }

    public static Team createTeam(){
        Team team = new Team();
        JSONObject data = new JSONObject();
        data.put("displayName","TeamAPI");
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        Response response = RequestManager.post("organizations", data.toString());
        team.setTeamName(response.jsonPath().get("displayName"));
        team.setId(response.jsonPath().get("id"));
        team.setShortName(response.jsonPath().get("name"));
        return team;
    }
}
