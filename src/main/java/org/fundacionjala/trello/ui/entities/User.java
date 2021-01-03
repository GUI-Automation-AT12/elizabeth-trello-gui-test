package org.fundacionjala.trello.ui.entities;

import org.fundacionjala.trello.core.utils.IdGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class User {
    private String username;
    private String bio;
    private Set<String> updatedFields = new HashSet<>();

    /**
     * Sets UserName to a User.
     * @param username
     */
    public void setUsername(final String username) {
        this.username = username.replaceAll(" ", "_");
        this.username = this.username.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
    }

    /**
     * Gets the UserName from a User.
     * @return UserName
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets UserName to a User.
     * @param bio
     */
    public void setBio(String bio) {
        this.bio = bio.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
    }

    /**
     * Gets the UserName from a User.
     * @return UserName
     */
    public String getBio() {
        return bio;
    }

    /**
     * Process all information stored for a User as a map.
     * @param userInformation
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> setUsername(userInformation.get("username")));
        strategyMap.put("bio", () -> setBio(userInformation.get("bio")));
        return strategyMap;
    }

    /**
     * Process all information stored for a User as a map.
     * @param userInformation
     */
    public void processInformation(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(userInformation);
        userInformation.keySet().forEach(key -> strategyMap.get(key).run());
        updatedFields = userInformation.keySet();
    }

    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> getUsername());
        strategyMap.put("bio", () -> getBio());
        return strategyMap;
    }

    public Map<String, String> getUpdatedInfo() {
        Map<String, String> userInfo = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetter();
        updatedFields.forEach(field -> userInfo.put(field, strategyMap.get(field).get()));
        return userInfo;
    }
}
