package org.fundacionjala.trello.ui.config;

import org.fundacionjala.core.utils.ReaderPropertiesFile;

public final class AppEnvironment {
    private static final String PATH = "gradle.properties";
    private static AppEnvironment singleInstance;
    private ReaderPropertiesFile reader;

    private AppEnvironment() {
        reader = new ReaderPropertiesFile(PATH);
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
     * Gets the BaseUrl from the file.properties.
     * @return base url.
     */
    public String getBaseUrl() {
        return reader.getEnvProperty("baseUrl");
    }

    /**
     * Gets the cucumberThreadCount from file.
     * @return cucumberThreadCount
     */
    public String getCucumberThreadCount() {
        return reader.getEnvProperty("cucumberThreadCount");
    }

    /**
     * Gets ilterTags value.
     * @return filterTags value.
     */
    public String getFilterTags() {
        return reader.getEnvProperty("filterTags");
    }
}
