package pages;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import base.Constants;
import base.Driverfactory;
import io.cucumber.java.Scenario;
import steps.Hook;
import utils.GenericLib;

public class HolidayMatrix {
	
	
	//Logger logger = LogManager.getLogger(HolidayMatrix.class);
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HolidayMatrix.class);
	
	
	private Scenario scenario;
	
	private WebDriver driver;
	
	public HolidayMatrix(WebDriver driver) {
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

	@FindBy(css ="select#drRegionalOffice")
	public WebElement eleRO;

	@FindBy(css ="select#drMonth")
	public WebElement eleMonth;

	@FindBy(css ="select#drYear")
	public WebElement eleYear;

	@FindBy(css ="input#btnGo")
	public WebElement eleGO;
	
	
	
	
	@FindBy(xpath ="//*[text()='Logout']")
	public WebElement eleLogout;
	

	
	
	public void navigateToUrl(String Url) {
		GenericLib.navigateTo(Driverfactory.getDriver(), Url);
		logger.info("Navigating to URLXXXX "+Url);
		Hook.scenario.log("Navigating to URL : "+Url);
		
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

	public void loadallcontents() {
		GenericLib.waitForJSandJQueryToLoad(Driverfactory.getDriver());
		logger.info("All the contents of the Website are loaded");
		Hook.scenario.log("All the contents of the Website are loaded");
	}

    public void selectRegionalOffice(String roffice) {
 
        GenericLib.selectDropDownByVisibleText(eleRO, roffice);
    }

	public void selectMonth(String month) {
		
		 GenericLib.selectDropDownByVisibleText(eleMonth, month);
	}

    public void selectYear(String year) {
        
         GenericLib.selectDropDownByVisibleText(eleYear, year);
    }

    public void submitGo() {
       
         GenericLib.clickOn(Driverfactory.getDriver(),eleGO,3000);
    }

    public void Display() {
		String screenshotName =Hook.scenario.getName().replaceAll(" ", "_");
					byte [] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
					Hook.scenario.attach(sourcePath, "image/png", screenshotName);
       
       // GenericLib.base64ScreenshotCapture(Driverfactory.getDriver(), "DisplayHolidays");
    }
	
	
}
