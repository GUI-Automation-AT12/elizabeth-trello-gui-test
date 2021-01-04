package org.fundacionjala.trello.ui.config;

import org.fundacionjala.trello.core.utils.ReaderJSONFile;

public final class AppEnvironment {
    private static final String PATH = "properties/App-properties.json";
    private static final String ALIAS = "app";
    private static AppEnvironment singleInstance;
    private ReaderJSONFile reader;

    private AppEnvironment() {
        reader = new ReaderJSONFile(PATH);
    }

    /**
     * Gets instance or create a new.
     * @return AppEnvironment instance
     */
    public static AppEnvironment getInstance() {
        if (singleInstance == null) {
            singleInstance = new AppEnvironment();
        }
        return singleInstance;
    }

    /**
     * Gets the BaseUrl from file.
     * @return base url
     */
    public String getBaseUrl() {
        return getProperty("baseUrl");
    }

    /**
     * Gets the Username from file.
     * @return Username
     */
    public String getUsername() {
        return getProperty("username");
    }

    /**
     * Gets the password from file.
     * @return Password
     */
    public String getPassword() {
        return getProperty("password");
    }

    /**
     * Gets the cucumberThreadCount from file.
     * @return cucumberThreadCount
     */
    public String getCucumberThreadCount() {
        return getProperty("cucumberThreadCount");
    }

    private String getProperty(final String key) {
        return reader.getData(ALIAS, key);
    }
}
