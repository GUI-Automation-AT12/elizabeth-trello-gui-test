package org.fundacionjala.trello.ui.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Cucumber TestNG runner class.
 */
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"org.fundacionjala.trello.ui.stepsDefs"},
        plugin = {"pretty",
                  "html:test-output",
                  "json:target/cucumber-report/cucumber.json"},
        tags = "not @Skipped"
)

public final class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    /**
     * Executes code before all scenarios.
     */
    @BeforeTest
    public void beforeAllScenarios() {
        //System.setProperty("dataproviderthreadcount", ApiEnvironment.getInstance().getCucumberThreadCount());
    }

    /**
     * Executes code after all scenarios.
     */
    @AfterTest
    public void afterAllScenarios() {

    }
}
