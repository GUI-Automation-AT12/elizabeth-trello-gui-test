package org.fundacionjala.trello.ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.fundacionjala.trello.ui.Context.Context;
import org.fundacionjala.trello.api.utils.BoardHelper;
import org.fundacionjala.trello.ui.entities.Board;

public class BoardsHooks {

    private Context context;

    public BoardsHooks(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Deletes a board
     */
    @After(value = "@DeleteBoard", order = 1)
    public void deleteBoard(){
        BoardHelper.deleteBoard(context.board);
    }

    /**
     * Creates a board
     */
    @Before(value = "@CreateBoard", order = 0)
    public void createBoard(){
        context.board = new Board();
        context.board = BoardHelper.createBoard();
    }
}
