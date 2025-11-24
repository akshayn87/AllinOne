package runner;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.vimalselvam.cucumber.listener.Reporter;

import config.ConfigReader;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//
//@CucumberOptions(features = "src/test/java/features", tags = "@UserDropdown", glue = "steps", plugin = { "pretty",
//		"html:target/cucumber-html-report.html", "json:target/cucumber.json", "rerun:target/rerun.txt",
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true)

@CucumberOptions(features = "src/test/java/features", tags = "@Sanity01", glue = "steps", plugin = { "pretty",
		"html:target/cucumber-html-report.html", "json:target/cucumber.json",
		"rerun:target/rerun.txt" }, monochrome = true)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
