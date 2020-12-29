package org.fundacionjala.trello.ui.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderJSONFile {
    private String pathFile;
    private FileReader reader;
    private JSONParser jsonParser = new JSONParser();

    public ReaderJSONFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getData(final String alias, final String key) {
        String value = " ";
        try {
            reader = new FileReader(pathFile);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONObject jsonData = (JSONObject) jsonObject.get(alias);
            value = jsonData.get(key).toString();

        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value;
    }
}
