package Cucumber;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
plugin ={"html:Reports/CucumberReport.html"})

public class TestRunner {

}
