package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.GenericLib;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.Constants;
import base.Driverfactory;
import config.ConfigReader;

public class Hook {
	
	 private Driverfactory driverfactory; 
	 private WebDriver driver;
	 private ConfigReader reader;
	 Properties prop;
	 private static final Logger logger =LogManager.getLogger(Hook.class);
	 public static Scenario scenario;

	 @Before(order =0)
		public void getProperty() {
			reader = new ConfigReader();
			prop =reader.init_prop();
		}

	@Before(order =1)
	public void lauchBrowser(Scenario scenario) {
		String browserName =prop.getProperty("browser");
		System.out.println("Selected :"+browserName);
		logger.info("Selected :"+browserName);
		 driverfactory = new Driverfactory();
		 driver =driverfactory.init_Driver(browserName);
		 driver.manage().window().maximize();
		 String url =prop.getProperty("url");
		 System.out.println("Navigated to :-"+url);
		 driver.get(url);
		 //Intialize Scenario for @Before annotation will provide to capture and log on the report
		 //Hooks.scenario =scenario will enable the logs at report level
		 //For class say LoginPage declare as scenario =Hooks.scenario
		 //Declare public static Scenario scenario = Hooks.scenario;
		 Hook.scenario =scenario;
		 
	}
	


	
	@After(order = 0)
	public synchronized void tearDown(Scenario scenario) {	
			if(scenario.isFailed()) {
				String screenshotName =scenario.getName().replaceAll(" ", "_");
				byte [] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath, "image/png", screenshotName);
			}
			
		logger.info("Testing is "+scenario.getStatus());
		driver.quit();
	}

}
