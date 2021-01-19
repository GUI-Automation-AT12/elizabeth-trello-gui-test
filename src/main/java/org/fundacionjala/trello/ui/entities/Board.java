package org.fundacionjala.trello.ui.entities;

import org.fundacionjala.core.utils.IdGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class Board {
    private String name;
    private String idBoard;
    private String team;
    private String privacy;
    private Set<String> updatedFields = new HashSet<>();

    /**
     * Sets name to a board.
     * @param boardName
     */
    public void setName(final String boardName) {
        this.name = boardName.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
        this.name = name.replaceAll(" ", "");
    }

    /**
     * Gets the name from a board.
     * @return UserName
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the id from a board.
     * @return id
     */
    public String getIdBoard() {
        return idBoard;
    }

    /**
     * Sets id a board.
     * @param id
     */
    public void setIdBoard(final String id) {
        this.idBoard = id;
    }

    /**
     * Gets team of a board.
     * @return team
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets teams of a board.
     * @param newteam
     */
    public void setTeam(final String newteam) {
        this.team = newteam;
    }

    /**
     * Gets privacy of a board.
     * @return privacy
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * Sets privacy of a board.
     * @param newprivacy
     */
    public void setPrivacy(final String newprivacy) {
        this.privacy = newprivacy;
    }

    /**
     * Gets updated fields.
     * @return updatedFields Map
     */
    public Set<String> getUpdatedFields() {
        return updatedFields;
    }

    /**
     * Sets Map of updated fields.
     * @param fields
     */
    public void setUpdatedFields(final Set<String> fields) {
        this.updatedFields = fields;
    }

    /**
     * Composes strategy setter map.
     * Sets the attributes of a board and save data in a Map.
     * @param boardInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> boardInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setName(boardInformation.get("name")));
        strategyMap.put("team", () -> setTeam(boardInformation.get("team")));
        strategyMap.put("privacy", () -> setPrivacy(boardInformation.get("privacy")));
        System.out.println(strategyMap.toString());
        return strategyMap;
    }

    /**
     * Process all information stored for a Board as a map.
     * @param boardInformation
     */
    public void processInformation(final Map<String, String> boardInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(boardInformation);
        boardInformation.keySet().forEach(key -> strategyMap.get(key).run());
        updatedFields = boardInformation.keySet();
    }

    /**
     * Composes strategy getter map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> getName());
        strategyMap.put("team", () -> getTeam());
        strategyMap.put("privacy", () -> getPrivacy());
        return strategyMap;
    }

    /**
     * Gets updated information of board.
     * @return userinfo
     */
    public Map<String, String> getUpdatedInfo() {
        Map<String, String> boardInfo = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetter();
        updatedFields.forEach(field -> boardInfo.put(field, strategyMap.get(field).get()));
        return boardInfo;
    }
}
