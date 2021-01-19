package org.fundacionjala.trello.ui.Context;


import org.fundacionjala.trello.ui.entities.Board;
import org.fundacionjala.trello.ui.entities.Team;
import org.fundacionjala.trello.ui.entities.User;

public class Context {
    private User user;
    private Board board;
    private Team team;

    /**
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     *
     * @return team
     */
    public Team getTeam() {
        return team;
    }

    /**
     *
     * @param newuser
     */
    public void setUser(final User newuser) {
        this.user = newuser;
    }

    /**
     *
     * @param newboard
     */
    public void setBoard(final Board newboard) {
        this.board = newboard;
    }

    /**
     *
     * @param newteam
     */
    public void setTeam(final Team newteam) {
        this.team = newteam;
    }
}
