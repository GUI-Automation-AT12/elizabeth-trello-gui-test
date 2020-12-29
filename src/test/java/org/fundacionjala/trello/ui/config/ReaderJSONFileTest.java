package org.fundacionjala.trello.ui.config;

import junit.framework.TestCase;

public class ReaderJSONFileTest extends TestCase {

    public void testGetData() {
        ReaderJSONFile readerJSONFile = new ReaderJSONFile("config/properties.json");
        assertEquals("user", readerJSONFile.getData("user1", "name"));
    }
}