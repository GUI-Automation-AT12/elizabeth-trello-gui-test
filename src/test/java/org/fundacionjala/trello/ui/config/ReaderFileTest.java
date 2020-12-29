package org.fundacionjala.trello.ui.config;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.Properties;

public class ReaderFileTest extends TestCase {

    public void testPrint() throws IOException {
        //ReaderFile readerFile = new ReaderFile("config/properties.json");
        ReaderFile readerFile = new ReaderFile("gradle.properties");
        readerFile.print();
    }
}