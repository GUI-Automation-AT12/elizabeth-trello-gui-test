package org.fundacionjala.trello.ui.config;

public class WebDriverEnvironment {
    private static final String PATH = "properties/properties.json";
    private static final String ALIAS = "browser";
    private static WebDriverEnvironment singleInstance;
    private ReaderJSONFile reader;

    private WebDriverEnvironment() {
        reader = new ReaderJSONFile(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static WebDriverEnvironment getInstance() {
        if (singleInstance == null) {
            singleInstance = new WebDriverEnvironment();
        }
        return singleInstance;
    }

    private String getProperty(final String key) {
        return reader.getData(ALIAS, key);
    }

    public int getImplicitTime() {
        return Integer.parseInt(getProperty("implicitTime"));
    }

    public int getExplicitTime() {
        return Integer.parseInt(getProperty("explicitTime"));
    }

    public String getBrowserName() {
        return getProperty("name");
    }
}
