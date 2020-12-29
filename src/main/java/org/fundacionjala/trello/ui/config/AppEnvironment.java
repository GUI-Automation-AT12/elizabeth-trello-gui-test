package org.fundacionjala.trello.ui.config;

public class AppEnvironment {
    private static final String PATH = "properties/properties.json";
    private static final String ALIAS = "app";
    private static AppEnvironment singleInstance;
    private ReaderJSONFile reader;

    private AppEnvironment() {
        reader = new ReaderJSONFile(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static AppEnvironment getInstance() {
        if (singleInstance == null) {
            singleInstance = new AppEnvironment();
        }
        return singleInstance;
    }

    /**
     * get the BaseUrl from the file.properties.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return getProperty("baseUrl");
    }

    /**
     * get the User from the file.properties.
     *
     * @return User value.
     */
    public String getUsername() {
        return getProperty("username");
    }

    /**
     * get the password from the file.properties.
     *
     * @return Password value.
     */
    public String getPassword() {
        return getProperty("password");
    }

    /**
     * get the cucumberThreadCount from the file.properties.
     * @return cucumberThreadCount value.
     */
    public String getCucumberThreadCount() {
        return getProperty("cucumberThreadCount");
    }

    private String getProperty(final String key) {
        return reader.getData(ALIAS, key);
    }
}
