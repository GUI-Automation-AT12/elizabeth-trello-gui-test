package org.fundacionjala.core.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReaderPropertiesFile {

    private static final Logger LOGGER = LogManager.getLogger(ReaderPropertiesFile.class);
    private Properties property;
    private FileReader reader;

    /**
     * Constructor.
     * @param pathFile
     */
    public ReaderPropertiesFile(final String pathFile) throws RuntimeException {
        try {
            reader = new FileReader(pathFile);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Error when reading properties file");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Error when getting properties file");
        } finally {
            closeReader();
        }
    }

    /**
     * Gets data of property.
     * @param env
     * @return value of property
     */
    public String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    /**
     * Close the reader.
     */
    private void closeReader() throws RuntimeException {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Error when closing properties file");
        }
    }
}
