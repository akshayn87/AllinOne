package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", tags = "@ValidateRBIHolidayMatrix", glue = "steps", plugin = { "pretty",
		"html:target/cucumber-html-report.html", "json:target/cucumber.json", "rerun:target/rerun.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true,publish = false)

// @CucumberOptions(features = "src/test/java/features", tags = "@ValidateRBIHolidayMatrix", glue = "steps", plugin = { "pretty",
// 		"html:target/cucumber-html-report.html", "json:target/cucumber.json",
// 		"rerun:target/rerun.txt" }, monochrome = true)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
public TestNGRunner(){
	
}
}
