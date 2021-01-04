package org.fundacionjala.trello.ui.config;

import junit.framework.TestCase;
import org.fundacionjala.trello.core.utils.ReaderJSONFile;

public class ReaderJSONFileTest extends TestCase {

    public void testGetData() {
        ReaderJSONFile readerJSONFile = new ReaderJSONFile("config/properties.json");
        assertEquals("user", readerJSONFile.getData("user1", "name"));
    }
}