package org.fundacionjala.trello.ui.entities;

import org.fundacionjala.trello.core.utils.IdGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class Board {
    private String name;
    private Set<String> updatedFields = new HashSet<>();

    /**
     * Sets name to a board.
     * @param boardName
     */
    public void setName(final String boardName) {
        this.name = boardName.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
        this.name = boardName.replaceAll(" ", "");
    }

    /**
     * Gets the name from a board.
     * @return UserName
     */
    public String getName() {
        return name;
    }

    /**
     * Composes strategy setter map.
     * @param boardInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> boardInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(boardInformation.get("Name")));
        return strategyMap;
    }

    /**
     * Process all information stored for a Board as a map.
     * @param userInformation
     */
    public void processInformation(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(userInformation);
        userInformation.keySet().forEach(key -> strategyMap.get(key).run());
        updatedFields = userInformation.keySet();
    }

    /**
     * Composes strategy getter map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> getName());
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
