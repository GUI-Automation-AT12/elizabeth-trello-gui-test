package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.utils.PageTransporter;

import java.net.MalformedURLException;

public class NavigationSteps {

    @Given("^I am on the (.*?) page$")
    public void goTheLoginPage(final String pageName) throws MalformedURLException {
        PageTransporter.navigateToPage(pageName);
    }

    @When("^I navigate to (.*?) Page$")
    public void iNavigateToMyProfilePage(final String pageName) throws MalformedURLException {
        PageTransporter.navigateToPage(pageName);
    }
}
