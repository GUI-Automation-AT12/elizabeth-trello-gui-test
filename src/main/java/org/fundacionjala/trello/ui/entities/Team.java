package org.fundacionjala.trello.ui.entities;

import org.fundacionjala.core.utils.IdGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class Team {
    private String id;
    private String teamName;
    private String teamType;
    private String descTeam;
    private String shortName;
    private String website;
    private String members;
    private Set<String> updatedFields = new HashSet<>();

    /**
     * Sets name to a board.
     * @param name
     */
    public void setTeamName(final String name) {
        this.teamName = name.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
        this.teamName = this.teamName.replaceAll(" ", "");
    }

    /**
     * Gets the name from a team.
     * @return teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Gets the type of a Team.
     * @return id
     */
    public String getTeamType() {
        return teamType;
    }

    /**
     * Sets type of a Team.
     * @param type
     */
    public void setTeamType(final String type) {
        this.teamType = type;
    }

    /**
     * Gets description of a Team.
     * @return team
     */
    public String getDescTeam() {
        return descTeam;
    }

    /**
     * Sets description of a team.
     * @param desc
     */
    public void setDescTeam(final String desc) {
        this.descTeam = desc;
    }

    /**
     * Gets member of a team.
     * @return privacy
     */
    public String getMembers() {
        return members;
    }

    /**
     * Sets members of a Team.
     * @param newmembers
     */
    public void setMembers(final String newmembers) {
        this.members = newmembers;
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
     * Gets the id from a Team.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id a Team.
     * @param idTeam
     */
    public void setId(final String idTeam) {
        this.id = idTeam;
    }
    /**
     * Gets the shortName from a Team.
     * @return id
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets shortName a Team.
     * @param name
     */
    public void setShortName(final String name) {
        this.shortName = name.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
        this.shortName = this.shortName.replaceAll(" ", "");
    }

    /**
     *
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param setWebsite
     */
    public void setWebsite(final String setWebsite) {
        this.website = setWebsite;
    }

    /**
     * Composes strategy setter map.
     * Sets the attributes of a board and save data in a Map.
     * @param teamInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setTeamName(teamInformation.get("name")));
        strategyMap.put("type", () -> setTeamType(teamInformation.get("type")));
        strategyMap.put("description", () -> setDescTeam(teamInformation.get("description")));
        strategyMap.put("shortName", () -> setShortName(teamInformation.get("shortName")));
        strategyMap.put("website", () -> setWebsite(teamInformation.get("website")));
        return strategyMap;
    }

    /**
     * Process all information stored for a Board as a map.
     * @param teamInformation
     */
    public void processInformation(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(teamInformation);
        teamInformation.keySet().forEach(key -> strategyMap.get(key).run());
        updatedFields = teamInformation.keySet();
    }

    /**
     * Composes strategy getter map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetter() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> getTeamName());
        strategyMap.put("type", () -> getTeamType());
        strategyMap.put("description", () -> getDescTeam());
        strategyMap.put("shortName", () -> getShortName());
        strategyMap.put("website", () -> getWebsite());
        return strategyMap;
    }

    /**
     * Gets updated information of board.
     * @return teamInfo
     */
    public Map<String, String> getUpdatedInfo() {
        Map<String, String> teamInfo = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetter();
        updatedFields.forEach(field -> teamInfo.put(field, strategyMap.get(field).get()));
        return teamInfo;
    }
}
