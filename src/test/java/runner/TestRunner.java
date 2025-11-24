package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
// @CucumberOptions(features = "src/test/java/features", tags = "@UserDropdown", glue = "steps", plugin = { "pretty",
// 		"html:target/cucumber-html-report.html", "json:target/cucumber.json", "rerun:target/rerun.txt",
// 		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true)
// public class TestRunner {

// }
@CucumberOptions(features = "src/test/java/features", tags = "@Sanity01", glue = "steps", plugin = { "pretty",
		"html:target/cucumber-html-report.html", "json:target/cucumber.json", "rerun:target/rerun.txt"}, monochrome = true)
public class TestRunner {

}



