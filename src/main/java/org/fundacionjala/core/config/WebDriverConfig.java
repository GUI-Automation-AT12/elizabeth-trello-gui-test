package org.fundacionjala.core.config;

import org.fundacionjala.core.utils.ReaderJSONFile;

public final class WebDriverConfig extends ReaderJSONFile {
    private static final String PATH = "properties/browser-properties.json";
    private static WebDriverConfig singleInstance;

    /**
     * Constructor.
     */
    private WebDriverConfig() {
        super(PATH);
    }

    /**
     * Gets instance or create a new one.
     * @return PropertiesReader instance.
     */
    public static WebDriverConfig getInstance() {
        if (singleInstance == null) {
            singleInstance = new WebDriverConfig();
        }
        return singleInstance;
    }

    /**
     * Gets implicitTime.
     * @return implicitTime
     */
    public int getImplicitTime(final String browser) {
        return Integer.parseInt(super.getData(browser, "implicitTime"));
    }

    /**
     * Gets explicitTime.
     * @return explicitTime
     */
    public int getExplicitTime(final String browser) {
        return Integer.parseInt(super.getData(browser, "explicitTime"));
    }

}
