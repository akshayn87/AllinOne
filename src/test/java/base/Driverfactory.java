package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import steps.Hook;

public class Driverfactory {
	
	
	private WebDriver driver;
	private static Scenario scenario;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	
	public WebDriver init_Driver(String browserName) {
		System.out.println("Browser Launched :"+browserName);
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ch =new ChromeOptions();
			ch.addArguments("--remote--allow-origins=*");
			DesiredCapabilities cap = new DesiredCapabilities();
			ch.merge(cap);
			tlDriver.set(new ChromeDriver(ch) );
		}else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver() );
		}else {
			System.out.println("Enter the correct name for the Browser");
		}
		
	
		return getDriver();
	}
	
	public static  synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
	
	public static synchronized Scenario getScenario() {
		//scenario =Hooks.scenario;
		return scenario;
	}
	

}
