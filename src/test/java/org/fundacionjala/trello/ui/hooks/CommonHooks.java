package org.fundacionjala.trello.ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.fundacionjala.trello.core.utils.WebDriverManager;

public class CommonHooks {


    public static final int BOUND = 50;

    /**
     * Constructor for the CommonHooks.
     */
    public CommonHooks() {
    }

    /**
     *
     */
    @Before( )
    public void Setup() {
    }

    /**
     * Closes browser
     */
    @After()
    public void afterScenario() {
        WebDriverManager.getInstance().quit();
    }
}
