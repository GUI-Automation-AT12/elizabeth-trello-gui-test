package org.fundacionjala.trello.core.config;

import org.fundacionjala.trello.core.utils.ReaderJSONFile;


public final class WebDriverEnvironment {
    private static final String PATH = "properties/chrome-properties.json";
    private static final String ALIAS = "browser";
    private static WebDriverEnvironment singleInstance;
    private ReaderJSONFile reader;

    /**
     * Constructor.
     */
    private WebDriverEnvironment() {
        reader = new ReaderJSONFile(PATH);
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
        return reader.getData(ALIAS, key);
    }

    /**
     * Gets implicitTime.
     * @return implicitTime
     */
    public int getImplicitTime() {
        return Integer.parseInt(getProperty("implicitTime"));
    }

    /**
     * Gets explicitTime.
     * @return explicitTime
     */
    public int getExplicitTime() {
        return Integer.parseInt(getProperty("explicitTime"));
    }

    /**
     * Gets browserName.
     * @return browserName
     */
    public String getBrowserName() {
        return getProperty("name");
    }
}
