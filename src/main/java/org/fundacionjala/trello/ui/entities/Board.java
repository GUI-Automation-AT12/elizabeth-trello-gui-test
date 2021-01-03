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
     * Sets name to a User.
     * @param name
     */
    public void setName(final String name) {
        this.name = name.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
        this.name = name.replaceAll(" ", "");
    }

    /**
     * Gets the UserName from a User.
     * @return UserName
     */
    public String getName() {
        return name;
    }

    /**
     * Process all information stored for a User as a map.
     * @param boardInformation
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

    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> getName());
        return strategyMap;
    }

    public Map<String, String> getUpdatedInfo() {
        Map<String, String> userInfo = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetter();
        updatedFields.forEach(field -> userInfo.put(field, strategyMap.get(field).get()));
        return userInfo;
    }
}
