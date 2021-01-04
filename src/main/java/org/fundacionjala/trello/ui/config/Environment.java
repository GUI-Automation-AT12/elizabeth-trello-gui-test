package org.fundacionjala.trello.ui.config;

import org.fundacionjala.trello.core.utils.ReaderPropertiesFile;

public final    class Environment {
    private static final String PATH = "gradle.properties";
    private static Environment singleInstance;
    private ReaderPropertiesFile reader;

    /**
     * Constructor.
     */
    private Environment() {
        reader = new ReaderPropertiesFile(PATH);
    }

    /**
     * Gets instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static Environment getInstance() {
        if (singleInstance == null) {
            singleInstance = new Environment();
        }
        return singleInstance;
    }

    /**
     *Gets the BaseUrl from the file.properties.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return reader.getEnvProperty("baseUrl");
    }

    /**
     *Gets the User from the file.properties.
     *
     * @return User value.
     */
    public String getUsername() {
        return reader.getEnvProperty("username");
    }

    /**
     *Gets the password from the file.properties.
     *
     * @return Password value.
     */
    public String getPassword() {
        return reader.getEnvProperty("password");
    }

    /**
     *Gets the cucumberThreadCount from the file.properties.
     * @return cucumberThreadCount value.
     */
    public String getCucumberThreadCount() {
        return reader.getEnvProperty("cucumberThreadCount");
    }
}
