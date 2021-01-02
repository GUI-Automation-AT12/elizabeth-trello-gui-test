package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.trello.ui.utils.Transporter;

import java.net.MalformedURLException;

public class NavigationSteps {

    @Given("^I am on the (.*?) page$")
    public void goTheLoginPage(final String pageName) throws MalformedURLException {
        Transporter.navigateToPage(pageName);
    }
}
