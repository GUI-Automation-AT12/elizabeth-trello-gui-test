package org.fundacionjala.trello.ui.utils;

import org.fundacionjala.core.utils.ReaderJSONFile;

public final class ReaderUserFile extends ReaderJSONFile {
    private static final String PATH = "properties/Users.json";
    private static ReaderUserFile singleInstance = new ReaderUserFile();

    /**
     * Constructor.
     */
    private ReaderUserFile() {
        super(PATH);
    }

    /**
     * Gets instance or create a new one.
     * @return PropertiesReader instance.
     */
    public static ReaderUserFile getInstance() {
        if (singleInstance == null) {
            singleInstance = new ReaderUserFile();
        }
        return singleInstance;
    }

    /**
     * Gets the email from file.
     * @param alias
     * @return email
     */
    public String getEmail(final String alias) {
        return getProperty(alias, "email");
    }

    /**
     * Gets the Username from file.
     * @param alias
     * @return Username
     */
    public String getUsername(final String alias) {
        return getProperty(alias, "username");
    }

    /**
     * Gets the bio from file.
     * @param alias
     * @return bio
     */
    public String getBio(final String alias) {
        return getProperty(alias, "bio");
    }

    /**
     * Gets value from file.
     * @param alias
     * @param key
     * @return value
     */
    private String getProperty(final String alias, final String key) {
        return super.getData(alias, key);
    }

    /**
     * Gets the password from file.
     * @param alias
     * @return password
     */
    public String getPassword(final String alias) {
        return getProperty(alias, "password");
    }
}
