package org.fundacionjala.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderJSONFile {
    private static final Logger LOGGER = LogManager.getLogger(ReaderJSONFile.class);
    private String pathFile;
    private FileReader reader;
    private JSONParser jsonParser = new JSONParser();

    /**
     * Constructor.
     * @param path
     */
    public ReaderJSONFile(final String path) {
        this.pathFile = path;
    }

    /**
     * Get data from json file.
     * @param alias
     * @param key
     * @return value
     */
    public String getData(final String alias, final String key) {
        String value = " ";
        try {
            reader = new FileReader(pathFile);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONObject jsonData = (JSONObject) jsonObject.get(alias);
            value = jsonData.get(key).toString();

        } catch (FileNotFoundException fe) {
            LOGGER.error(fe.getMessage());
            throw new RuntimeException("Error when reading JSON file");
        } catch (IOException ioe) {
            LOGGER.error(ioe.getMessage());
            throw new RuntimeException("Error when reading JSON file");
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage());
            throw new RuntimeException("Error Parse JSON file");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Error in JSON reader file");
        }
        return value;
    }
}
