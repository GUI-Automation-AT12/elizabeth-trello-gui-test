package org.fundacionjala.trello.api.config;

import org.fundacionjala.core.utils.ReaderPropertiesFile;

public final class ApiEnvironment extends ReaderPropertiesFile {
    private static final String PATH = "APIgradle.properties";
    private static ApiEnvironment singleInstance;

    /**
     * Constructor.
     */
    private ApiEnvironment() {
        super(PATH);
    }

    /**
     * Gets instance or create a new one.
     * @return PropertiesReader instance.
     */
    public static ApiEnvironment getInstance() {
        if (singleInstance == null) {
            singleInstance = new ApiEnvironment();
        }
        return singleInstance;
    }

    /**
     * Gets the BaseUrl from the file.properties.
     * @return base url.
     */
    public String getBaseUrl() {
        return super.getEnvProperty("baseUrl");
    }

    /**
     * Gets the key from the file.properties.
     * @return key value.
     */
    public String getKey() {
        return super.getEnvProperty("key");
    }

    /**
     * Gets the User from the file.properties.
     * @return User value.
     */
    public String getUsername() {
        return super.getEnvProperty("username");
    }

    /**
     * Gets the password from the file.properties.
     * @return Password value.
     */
    public String getPassword() {
        return super.getEnvProperty("password");
    }

    /**
     * Gets the token from the file.properties.
     * @return Token value.
     */
    public String getToken() {
        return super.getEnvProperty("token");
    }

}
