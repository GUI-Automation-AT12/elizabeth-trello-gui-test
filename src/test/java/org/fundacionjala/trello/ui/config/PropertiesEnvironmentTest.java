package org.fundacionjala.trello.ui.config;

import junit.framework.TestCase;

public class PropertiesEnvironmentTest extends TestCase {

    public void testGetUsername() {
        AppEnvironment.getInstance().getUsername();
        assertEquals("username", AppEnvironment.getInstance().getUsername() );
    }
}