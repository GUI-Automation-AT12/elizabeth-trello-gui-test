package org.fundacionjala.trello.ui.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"org/fundacionjala/trello/ui/stepsDefs"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:path/report.html"}
)
public class TestRunner {

}
