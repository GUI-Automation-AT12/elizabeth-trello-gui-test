package org.fundacionjala.trello.api.utils;

import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.trello.ui.entities.Board;
import org.json.simple.JSONObject;

public final class BoardHelper {
    private BoardHelper() {
    }

    /**
     * Deletes board.
     * @param board
     */
    public static void deleteBoard(final Board board) {
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        if (board.getIdBoard().contains("/")) {
            String[] endpointSplit = board.getIdBoard().split("/");
            RequestManager.delete("boards/" + endpointSplit[endpointSplit.length - 2]);
        } else {
            RequestManager.delete("boards/" + board.getIdBoard());
        }
    }

    /**
     * Creates a board.
     * @return board
     */
    public static Board createBoard() {
        Board board = new Board();
        JSONObject data = new JSONObject();
        data.put("name", "BoardTest");
        data.put("team", "My TeamTest");
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        Response response = RequestManager.post("boards", data.toString());
        System.out.println(response.getBody().prettyPrint());
        board.processInformation(data);
        board.setIdBoard(response.jsonPath().get("id"));
        return board;
    }
}
