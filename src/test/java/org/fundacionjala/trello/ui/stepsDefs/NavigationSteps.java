package org.fundacionjala.trello.ui.stepsDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.utils.PageTransporter;

import java.net.MalformedURLException;

public class NavigationSteps {

    /**
     * Go to page.
     * @throws MalformedURLException
     */
    @Given("^I am on the (.*?) page$")
    public void goTheLoginPage(final String pageName) throws MalformedURLException {
        PageTransporter.navigateToPage(pageName);
    }

    /**
     * Go to page.
     * @param pageName
     * @throws MalformedURLException
     */
    @When("^I navigate to (.*?) Page$")
    public void iNavigateToMyProfilePage(final String pageName) throws MalformedURLException {
        PageTransporter.navigateToPage(pageName);
    }
}
