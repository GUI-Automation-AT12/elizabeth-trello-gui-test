package org.fundacionjala.trello.ui.config;

import org.fundacionjala.trello.core.utils.ReaderJSONFile;

public class ReaderUserFile {
    private static final String PATH = "properties/Users.json";
    private static ReaderJSONFile reader;

    /**
     * Constructor
     */
    private ReaderUserFile() {
    }

    /**
     * Gets the email from file.
     * @return email
     */
    public static String getEmail(final String alias) {
        return getProperty(alias, "email");
    }

    /**
     * Gets the Username from file.
     * @return Username
     */
    public static String getUsername(final String alias) {
        return getProperty(alias, "username");
    }

    /**
     * Gets the bio from file.
     * @return bio
     */
    public static String getBio(final String alias) {
        return getProperty(alias, "bio");
    }

    /**
     * Gets value from file.
     * @return value
     */
    private static String getProperty(final String alias, final String key) {
        reader = new ReaderJSONFile(PATH);
        return reader.getData(alias, key);
    }

    /**
     * Gets the password from file.
     * @return password
     */
    public static String getPassword(String alias) {
        return getProperty(alias, "password");
    }
}
