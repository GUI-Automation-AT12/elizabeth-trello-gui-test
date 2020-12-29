package org.fundacionjala.trello.ui.entities;

import org.fundacionjala.trello.core.utils.IdGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class User {
    private String userName;
    private String bio;
    private Set<String> updatedFields = new HashSet<>();

    /**
     * Sets UserName to a User.
     * @param userName
     */
    public void setUserName(final String userName) {
        this.userName = userName.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
        this.userName = userName.replaceAll(" ", "");
    }

    /**
     * Gets the UserName from a User.
     * @return UserName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets UserName to a User.
     * @param bio
     */
    public void setBio(final String bio) {
        userName = bio.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
    }

    /**
     * Gets the UserName from a User.
     * @return UserName
     */
    public String getBio() {
        return userName;
    }

    /**
     * Process all information stored for a User as a map.
     * @param userInformation
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("User name", () -> setUserName(userInformation.get("User name")));
        strategyMap.put("Name", () -> setUserName(userInformation.get("Name")));
        strategyMap.put("Initials", () -> setBio(userInformation.get("Initials")));
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
        strategyMap.put("User name", () -> getUserName());
        strategyMap.put("Name", () -> getUserName());
        strategyMap.put("Initials", () -> getBio());
        return strategyMap;
    }

    public Map<String, String> getUpdatedInfo() {
        Map<String, String> userInfo = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetter();
        updatedFields.forEach(field -> userInfo.put(field, strategyMap.get(field).get()));
        return userInfo;
    }
}
