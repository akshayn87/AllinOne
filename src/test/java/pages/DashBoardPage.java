package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Constants;
import base.Driverfactory;
import io.cucumber.java.Scenario;
import steps.Hook;
import utils.GenericLib;
import org.openqa.selenium.WebDriverException;

public class DashBoardPage {
	
	private WebDriver driver;
	private Scenario scenario;
	
	private static final org.apache.logging.log4j.Logger logger =LogManager.getLogger(DashBoardPage.class);

	
	public DashBoardPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (css="span.oxd-userdropdown-tab")
	private WebElement eleUserDropdown;
	
	
	@FindBy(css="ul.oxd-dropdown-menu>li:nth-child(1)>a")
	private WebElement aboutPagefromuserdropdown;
	
	@FindBy(css="ul.oxd-dropdown-menu>li:nth-child(2)>a")
	private WebElement supportPagefromuserdropdown;
	
	@FindBy(css="div.oxd-sheet>div>h6")
	private WebElement AboutPageTitle;
	
	
	@FindBy(css=" div.orangehrm-about>div>p.orangehrm-about-title")
	private List<WebElement> attributetitles;
	
	
	
	@FindBy(css="div.orangehrm-about>div>p.orangehrm-about-text")
	private List<WebElement> attributetexts;
	
	@FindBy(css ="button.oxd-dialog-close-button")
	private WebElement closeable;
	// div.orangehrm-about>div>p.orangehrm-about-title
	// div.orangehrm-about>div>p.orangehrm-about-text
	
	
	public void userDropdown() {
		//Assert on userDropdown
		logger.info("User Drop Down Method");
		GenericLib.waitForElementClickable(Driverfactory.getDriver(), eleUserDropdown, Constants.VERYSHORTWAIT).click();
		GenericLib.base64ScreenshotCapture(Driverfactory.getDriver());
		//Click on UserDropdown
		
	}
	
	public void navigatetoAboutPagefromUserDropDown() {
		logger.info("Navigate to About Page from User Drop Down");
		//Click About page Link from flex Drop down
		GenericLib.waitForElementClickable(Driverfactory.getDriver(), aboutPagefromuserdropdown, Constants.VERYSHORTWAIT).click();
		GenericLib.shootPageFullCaptureBase64(Driverfactory.getDriver());
		GenericLib.base64ScreenshotCapture(Driverfactory.getDriver());
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public HashMap getOrangePageAttributes() {
		logger.info("Get About Page Attributes");
		
		GenericLib.waitForElementVisible(Driverfactory.getDriver(), AboutPageTitle);
		
		HashMap<String,String> attributes = new LinkedHashMap<String,String> ();
		List<String> titles = new ArrayList<String>();
		List<String> texts = new ArrayList<String>();
		
		for(WebElement title:attributetitles) {
			titles.add(title.getText());
		}
		
		for(WebElement text:attributetexts) {
			texts.add(text.getText());
		}
		
		for (int i = 0; i < titles.size(); i++) {
			attributes.put(titles.get(i), texts.get(i));
		}
		
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
		    logger.info(entry.getKey()+" : "+entry.getValue());
		}
		
		logger.info(attributes.toString());
		return attributes;
		
		
	}
	
	public void navigatetoSupportPagefromUserDropdown() {
		WebDriverException wde = new WebDriverException();
		wde.getBuildInformation();
		wde.getBuildInformation().getBuildRevision();
		wde.getBuildInformation().getReleaseLabel();
		wde.getBuildInformation().toString();
		
		Select select = new Select(eleUserDropdown);
		List<WebElement> options =select.getOptions();
		WebElement option =options.get(0);
		int  listsize =options.size();
		select.selectByVisibleText("user");
		select.selectByIndex(0);
		select.selectByValue("RED");
		WebElement Firstoption =select.getFirstSelectedOption();
		
		driver.switchTo().activeElement();
		driver.switchTo().frame(0); //index
		driver.switchTo().frame("red"); //name
		driver.switchTo().frame(eleUserDropdown);//Dropdown
		driver.switchTo().defaultContent();
		//Selects either the first frame on the page, or the main document when a page containsiframes. 
		driver.switchTo().parentFrame();
		//Change focus to the parent context. If the current context is the top level browsing context,the context remains unchanged
		
		driver.switchTo().activeElement();
		driver.switchTo().activeElement();
		
		driver.switchTo().frame("parent").switchTo().frame("child1").switchTo().frame("grandchild1");
		driver.switchTo().parentFrame().switchTo().parentFrame();
		driver.switchTo().frame("child2").switchTo().frame("grandchild2");
		
		
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        // print your number of frames
        System.out.println(iframes.size());

        // you can reach each frame on your site
        for (WebElement iframe : iframes) {

            // switch to every frame
            driver.switchTo().frame(iframe);

            // now within the frame you can navigate like you are used to
            System.out.println(driver.findElement(By.id("tinymce")).getText());
        }
        
        String red =driver.switchTo().window("red").getWindowHandle();
        
        Set<String> handles =driver.switchTo().window("red").getWindowHandles();
	}
	
	public void closeAboutPage() {
		GenericLib.waitForElementClickable(Driverfactory.getDriver(), closeable, Constants.VERYSHORTWAIT).click();
	}

	public void navigatetoSupportPagefromUserDropDown() {
		logger.info("Navigate to Support Page from User Drop Down");
		userDropdown();
		//Click About page Link from flex Drop down
		GenericLib.waitForElementClickable(Driverfactory.getDriver(), supportPagefromuserdropdown, Constants.VERYSHORTWAIT).click();
		GenericLib.shootPageFullCapture(Driverfactory.getDriver());
		GenericLib.base64ScreenshotCapture(Driverfactory.getDriver(),"Capture Support Page");
		logger.info("Support Page Url "+driver.getCurrentUrl());
	
		
	}
	
	

}
