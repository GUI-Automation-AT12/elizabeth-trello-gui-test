package org.fundacionjala.core.config;

import org.fundacionjala.core.utils.ReaderPropertiesFile;


public final class WebDriverEnvironment extends ReaderPropertiesFile {
    private static final String PATH = "gradle.properties";
    private static WebDriverEnvironment singleInstance = new WebDriverEnvironment();

    /**
     * Constructor.
     */
    private WebDriverEnvironment() {
        super(PATH);
    }

    /**
     * Gets instance or create a new one.
     * @return PropertiesReader instance.
     */
    public static WebDriverEnvironment getInstance() {
        if (singleInstance == null) {
            singleInstance = new WebDriverEnvironment();
        }
        return singleInstance;
    }

    /**
     * Gets value of reader.
     * @param key
     * @return value of reader
     */
    private String getProperty(final String key) {
        return super.getEnvProperty(key);
    }

    /**
     * Gets browserName.
     * @return browserName
     */
    public String getBrowserName() {
        return super.getEnvProperty("browser");
    }
}
