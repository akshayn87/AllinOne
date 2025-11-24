package pages;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Constants;
import base.Driverfactory;
import io.cucumber.java.Scenario;
import steps.Hook;
import utils.GenericLib;

public class LoginPage {
	
	
	Logger logger = LogManager.getLogger(LoginPage.class);
	
	private Scenario scenario;
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath ="//input[@name='username']")
	public WebElement username;

	@FindBy(name ="password")
	public WebElement password;
	
	@FindBy(tagName ="button")
	public WebElement loginBtn;
	
	@FindBy(xpath ="(//*[text()='Dashboard'])[2]")
	public WebElement DashBoard;
	
	
	
	@FindBy(xpath ="//*[text()='Logout']")
	public WebElement eleLogout;
	

	
	
	public void enterUsername(String username) {
		GenericLib.clickOn(Driverfactory.getDriver(), this.username, Constants.VERYSHORTWAIT);
		this.username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLogin() {
		this.loginBtn.click();
	}

	public String getTitleOfPage() {
		return driver.getTitle();
		
	}

	public void assertOnDashBoard() {
		try {
		assertEquals(this.DashBoard.getText(), "DashBoard");
		}catch(Exception ignore ){
			logger.error("Unable to navigate to the Dash Board Page");
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public void logoutApplication() {
		Hook.scenario.log("Logging out the Application");
		GenericLib.shootPageFullCaptureBase64(Driverfactory.getDriver());
		GenericLib.base64ScreenshotCapture(Driverfactory.getDriver());
		GenericLib.waitForElementClickable(Driverfactory.getDriver(), eleLogout,Constants.VERYSHORTWAIT).click();
		logger.info("Logged out of the Application");
		String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		equals(Driverfactory.getDriver().getCurrentUrl().equalsIgnoreCase(url));
		GenericLib.delay(Constants.SHORTWAIT);
		GenericLib.base64ScreenshotCapture(Driverfactory.getDriver());
		//GenericLib.base64ScreenshotCapture(driver, scenario);
	}
	
	
}
