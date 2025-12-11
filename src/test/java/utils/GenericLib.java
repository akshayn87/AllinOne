package utils;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import base.Constants;
import io.cucumber.java.Scenario;
import steps.Hook;

public class GenericLib {
	
	private static final Logger logger =LogManager.getLogger(GenericLib.class);
	private static Scenario scenario =Hook.scenario;
	
	
	public static void delay() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void delay(int waitFor) {

		try {
			Thread.sleep(waitFor);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

public static void navigateTo(WebDriver driver,String url){
		try {
		driver.navigate().to(url);	
		logger.info("navigated to Url :- "+url);

		} catch (Exception e) {
			logger.info("Unable to Navigate to URL");
		}
	}
	
	public static boolean isClickable(WebDriver driver,WebElement element) {
		try {
			
			
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.VERYSHORTWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return true;
		}catch(Exception e) {
			logger.info("Unable to click0");
			return false;
		}
	}
	
	
	public static WebElement waitForElementClickable(WebDriver driver,WebElement element,int waitfor) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.VERYSHORTWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		return element;
	}
	
	
	public static WebElement waitForElementClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.VERYSHORTWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		return element;
	}
	
	
	public static void waitForelementToDissapear(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.VERYSHORTWAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	
	public static void waitForelementsToDissapear(WebDriver driver,List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.VERYSHORTWAIT));
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}
	
	public static boolean waitForJSandJQueryToLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.MEDIUMWAIT));
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					Long r= (Long)((JavascriptExecutor)driver).executeScript("return $.active");
					return r ==0;
				}catch(Exception e) {
					logger.info("No jquery Present");
				    return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState")
						.toString().equals("complete");
			}
		};
		return wait.until(jQueryLoad)&& wait.until(jsLoad);
	}
	
	public static boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		}catch (NoSuchElementException e) {
		logger.info("unable to find"+element);
		return false;
		}
	}
	
	public static boolean isEnabled(WebElement element) {
		try {
			return element.isEnabled();
		}catch (NoSuchElementException e) {
		logger.info("unable to find"+element);
		return false;
		}
	}

	public static void clickOn(WebElement element) {
		try {
			element.click();
		}catch(StaleElementReferenceException e) {
			logger.error("Element is not attached to page Documentation");
		}catch (NoSuchElementException e) {
			logger.error("Element"+element+"was not found in DOM");
		}catch(Exception e){
			logger.error("Element"+element+"was not clickable");
		}
	}
	
	
	public static void clickOn(WebDriver driver,WebElement element,int waitFor) {
		try {
			waitForElementClickable(driver,element,waitFor).click();
		}catch(StaleElementReferenceException e) {
			logger.error("Element is not attached to page Documentation");
		}catch (NoSuchElementException e) {
			logger.error("Element"+element+"was not found in DOM");
		}catch(Exception e){
			logger.error("Element"+element+"was not clickable");
		}
	}
	
	
	
	public static void scrollAndClick(WebDriver driver,WebElement element) {
		try {
			waitForElementVisible(driver,element).click();
			scrollToElement(driver,element);
			element.click();
		}catch(StaleElementReferenceException e) {
			logger.error("Element is not attached to page Documentation");
		}catch (NoSuchElementException e) {
			logger.error("Element"+element+"was not found in DOM");
		}catch(Exception e){
			logger.error("Element"+element+"was not clickable");
		}
	}
	
	
	

	public static void mouseClick(WebDriver driver,WebElement element) {
		try {
			Actions actions = new Actions(driver).click(element);
			actions.build().perform();
		}catch(StaleElementReferenceException e) {
			logger.error("Element is not attached to page Documentation");
		}catch (NoSuchElementException e) {
			logger.error("Element"+element+"was not found in DOM");
		}catch(Exception e){
			logger.error("Element"+element+"was not clickable");
		}
	}
	
	
	public static void mouseDoubleClick(WebDriver driver,WebElement element) {
		try {
			Actions actions = new Actions(driver).doubleClick(element);
			actions.build().perform();
		}catch(StaleElementReferenceException e) {
			logger.error("Element is not attached to page Documentation");
		}catch (NoSuchElementException e) {
			logger.error("Element"+element+"was not found in DOM");
		}catch(Exception e){
			logger.error("Element"+element+"was not clickable");
		}
	}
	
	
	public static void mouseContextClick(WebDriver driver,WebElement element) {
		try {
			Actions actions = new Actions(driver).contextClick(element);
			actions.build().perform();
		}catch(StaleElementReferenceException e) {
			logger.error("Element is not attached to page Documentation");
		}catch (NoSuchElementException e) {
			logger.error("Element"+element+"was not found in DOM");
		}catch(Exception e){
			logger.error("Element"+element+"was not clickable");
		}
	}
	
	
	public static void mouseHoverOnElement(WebDriver driver,WebElement element) {
		try {
			Actions actions = new Actions(driver).contextClick(element);
			actions.moveToElement(element);
			actions.build().perform();
		}catch(StaleElementReferenceException e) {
			logger.error("Element is not attached to page Documentation");
		}catch (NoSuchElementException e) {
			logger.error("Element"+element+"was not found in DOM");
		}catch(Exception e){
			logger.error("Element"+element+"was not clickable");
		}
	}
	
	public static void javaScriptClick(WebDriver driver,WebElement element) {
		
		try {
		      if(element.isEnabled()&&(element.isDisplayed())) {
		    	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element );
		      }else {
		    	  logger.error("unable to click on Element");
		      }
		}catch(StaleElementReferenceException e) {
					logger.error("Element is not attached to page Documentation");
				}catch (NoSuchElementException e) {
					logger.error("Element"+element+"was not found in DOM");
				}catch(Exception e){
					logger.error("Element"+element+"was not clickable");
				}
	}
	
	
public static void javaScriptHoverOnElement(WebDriver driver,WebElement element) {
		
		try {
		      if(element.isEnabled()) {
		    	 String mouseOverScript ="if(document.createEvent){var evObj =document.createEvent('MouseEvents');evObj.initEvent('mouseover',true,false);arguments[0].dispatchEvent(evObj);}else if(document.createEventObject{ arguments[0].fireEvent('onmouseover');}";
		    			 ((JavascriptExecutor)driver).executeScript(mouseOverScript,element );
		      }else {
		    	  logger.error("unable to click on Element");
		      }
		}catch(StaleElementReferenceException e) {
					logger.error("Element is not attached to page Documentation");
				}catch (NoSuchElementException e) {
					logger.error("Element"+element+"was not found in DOM");
				}catch(Exception e){
					logger.error("Element"+element+"was not clickable");
				}
	}
	
	
public static void javaScriptSendKeys(WebDriver driver,WebElement element,String valueToSend) {
	
	try {
	      if(element.isEnabled()&&(element.isDisplayed())) {
	    	  ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '"+valueToSend+"')",element );
	      }else {
	    	  logger.error("unable to click on Element");
	      }
	}catch(StaleElementReferenceException e) {
				logger.error("Element is not attached to page Documentation");
			}catch (NoSuchElementException e) {
				logger.error("Element was not found in DOM");
			}catch(Exception e){
				logger.error("Unable to send text to Element");
			}
}

public static void sendText(WebElement element ,String textToSent) {
	
	try {
	      element.sendKeys(textToSent);
	}catch(StaleElementReferenceException e) {
				logger.error("Element is not attached to page Documentation");
			}catch (NoSuchElementException e) {
				logger.error("Element"+element+"was not found in DOM");
			}catch(Exception e){
				logger.error("Element"+element+"was not clickable");
			}
}

public static void sendText(WebElement element ,int textToSent) {
	
	try {
	      element.sendKeys(Integer.toString(textToSent));
	}catch(StaleElementReferenceException e) {
				logger.error("Element is not attached to page Documentation");
			}catch (NoSuchElementException e) {
				logger.error("Element"+element+"was not found in DOM");
			}catch(Exception e){
				logger.error("Element"+element+"was not present");
			}
}

public static void clearAndsendText(WebElement element ,String textToSent) {
	
	try {
		  element.click();
		  element.clear();
	      element.sendKeys(textToSent);
	}catch(StaleElementReferenceException e) {
				logger.error("Element is not attached to page Documentation");
			}catch (NoSuchElementException e) {
				logger.error("Element"+element+"was not found in DOM");
			}catch(Exception e){
				logger.error("Element"+element+"was not clickable");
			}
}


public static void clearAndsendText(WebElement element ,int textToSent) {
	
	try {
		  element.click();
		  element.clear();
	      element.sendKeys(Integer.toString(textToSent));
	}catch(StaleElementReferenceException e) {
				logger.error("Element is not attached to page Documentation");
			}catch (NoSuchElementException e) {
				logger.error("Element"+element+"was not found in DOM");
			}catch(Exception e){
				logger.error("Element"+element+"was not clickable");
			}
}


public static void selectCheckbox(WebElement element) {
	try {
		if(element.isSelected()) {
			logger.error("Checkbox"+element+"is already selected");
		}else {
			element.click();
		}
	}catch(Exception e) {
		logger.info("Unable to select the check box");
	}
	
}

public static void selectCheckBoxValue(WebElement element,String valueToSelect) {
	try {
		List<WebElement> allOptions =element.findElements(By.tagName("span"));
		for(WebElement option:allOptions) {
		logger.info("Option Value "+option);
		if(valueToSelect.equals(option.getText())) {
			break;
		}
		
		}
	}catch(NoSuchElementException e) {
	logger.error("No Element found to select Check Box from List");	
	}
	
}

public static String getSelectedOption(WebElement element) {
	
	Select select = new Select(element);
	WebElement selectedElement =select.getFirstSelectedOption();
	return selectedElement.getText();
}



public static void selectDropDownByVisibleText(WebElement element,String sVisibleTextOptionToSelect) {
	try {
		Select select = new Select(element);
		select.selectByVisibleText(sVisibleTextOptionToSelect);
		
	}catch(NoSuchElementException e){
		logger.error("Option value not found in dropdown");
	}
}



	public static void scrollToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	public static int getSizeOfDropDown(WebElement element) {
		try {
			Select dropdownOptions = new Select(element);
			return dropdownOptions.getOptions().size();
		}catch(NoSuchElementException | TimeoutException e) {
			logger.info("Unable to find"+element);
			return 0;
		}
	}
	
	public static WebElement waitForElementVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.VERYSHORTWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		return element;
	}
	

	public static String getAllValuesFromDropDown(WebElement element) {
		Select dropdown = new Select(element);
		ArrayList<String> textList = new ArrayList<>();
		List<WebElement> list =dropdown.getOptions();
		for(WebElement elements:list) {
			textList.add(elements.getText());
		}
		return String.valueOf(textList);
	}
	
	public static boolean verifyValuesInDropdown(List<WebElement> listOfElements,String[] strValues) {
		boolean bValue =false;
		List<String> list = new ArrayList<>();
		for(String strValue:strValues) {
			boolean bflag=false;
			for(WebElement element:listOfElements) {
				String elementValue =element.getText();
			if(strValue.equals(elementValue)) {
				bflag =true;
			}
		}
		if(!bflag) {
			list.add(strValue);
		}
		if(list.size()>0) {
			for(String strList:list) {
				logger.error("value not present in dropdown :"+strList);
			}
			bValue=false;
		}else {
			logger.error("All value(s) found in dropdown");
		   bValue=true;
		}
	//return bValue;
	
	}
	return bValue;
	}
	
	
	public static String [] removeItemFromArray(String[] input,String item) {
		
		if(input == null) {
			return null;
		}else if (input.length <=0) {
			return input;
		}else {
			String [] output = new String[input.length -1];
			int count =0;
			for(String i:input) {
				if(!i.equals(item)) {
				output[count++] =i;
			}
		}
		return output;
	}
}
	
	public static String getText(WebElement element) {
		try {
			return element.getText();
		}catch(NoSuchElementException |TimeoutException e) {
			logger.error("unable to find "+element);
			return null;
		}
	}
	
	public static String getAttributeText(WebElement element,String attribute) {
		try {
			return element.getAttribute(attribute);
		}catch(NoSuchElementException |TimeoutException e) {
			logger.error("unable to find "+element);
			return null;
		}
	}
	
	
	public static int getListOfElementsSize(List<WebElement> element) {
		try {
			return element.size();
		}catch(NoSuchElementException |TimeoutException e) {
			logger.error("unable to find "+element);
			return 0;
		}
	}
	
	public static WebElement getCommonXpath(WebDriver driver,String linkText) {
		try {
			WebElement element = driver.findElement(By.xpath("//a[contains(text(),\""+linkText+"\")]"));
		    return waitForElementClickable(driver,element);
		}catch(NoSuchElementException |TimeoutException e) {
			logger.error("unable to find "+linkText);
			return null;
		}
	}
	
	
	public static void waitForElementVisible(WebDriver driver,List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.VERYSHORTWAIT));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}
	
	
	
	public static boolean isAlertPresent(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.SHORTWAIT));
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(NoAlertPresentException ex){
			logger.error("NoAlertPresentException "+ex);
			return false;
		}
	}
	
	
	public static void dismissAlert(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.SHORTWAIT));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().dismiss();
		}catch(NoAlertPresentException ex){
			logger.error("NoAlertPresentException "+ex);
			
		}
	}
	
	

	public static void acceptAlert(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.SHORTWAIT));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();;
		}catch(NoAlertPresentException ex){
			logger.error("NoAlertPresentException "+ex);
			
		}
	}
	
	public static String getCurrentDateAndTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal =Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal =Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	
	public static String convertStringTodateAndAddYears(String strDate,int yearsToBeAdded) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
		Calendar cal =Calendar.getInstance();
		cal.setTime(dateFormat.parse(strDate));
		cal.add(Calendar.YEAR, yearsToBeAdded);
		return dateFormat.format(cal.getTime());
	}catch(ParseException e) {
		e.printStackTrace();
		return null;
	}
	}
	
	
	public static String convertStringTodateAndAddMonths(String strDate,int monthsToBeAdded) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
		Calendar cal =Calendar.getInstance();
		cal.setTime(dateFormat.parse(strDate));
		cal.add(Calendar.MONTH, monthsToBeAdded);
		return dateFormat.format(cal.getTime());
	}catch(ParseException e) {
		e.printStackTrace();
		return null;
	}
	}
	
	public static String convertStringTodateAndAddDays(int daysToBeAdded) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
		Calendar cal =Calendar.getInstance();
		cal.add(Calendar.DATE, daysToBeAdded);
		return dateFormat.format(cal.getTime());
	}
	
	
	public static Date convertStringToDate (String strDate) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
		Date startDate =dateFormat.parse(strDate);
	
		return startDate;
	}catch(ParseException e) {
		e.printStackTrace();
		return null;
	}	
	}
	
	
	public static String getDayOfWeek() {
		return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
	
	
	public static String forPercentages (double value,Locale locale) {
		NumberFormat nf =NumberFormat.getPercentInstance(locale);
		return nf.format(value);
	}
	public static String takeScreenshotAndReturnPath(WebDriver driver,String filename) throws IOException{
		File sourceScreenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationScreenshotFile = new File(Constants.BASEPATH+System.currentTimeMillis()+".png");
		FileUtils.copyFile(sourceScreenshotFile,destinationScreenshotFile);
		//Here we will use getAbsolutePath() method to convert the File to String and then return it
		logger.info(destinationScreenshotFile.getAbsolutePath());
		return destinationScreenshotFile.getAbsolutePath();
		}

	
	public static String captureScreenShot(WebDriver driver,String basePath) {
		try {
			File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File fileDest = new File(basePath+System.currentTimeMillis()+".png");
			String errFilePath =fileDest.getAbsolutePath();
			logger.info(errFilePath);
			FileUtils.copyFile(srcFile, fileDest);
			return errFilePath;
		}catch (Exception e) {
			logger.error("Screenshot Capture error");
		     return null;
		}
	}
	
	
	
	public static String shootPageFullCapture(WebDriver driver){
		try {
		BufferedImage image = Shutterbug.shootPage(driver,Capture.FULL_SCROLL,500,true).getImage();
		ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
		ImageIO.write(image, "png", outputStream);
		String destinationScreenshotFile =Constants.BASEPATH;
		Shutterbug.shootPage(driver,Capture.FULL,2000,true).save(destinationScreenshotFile);
		String encodedBase64= new String(Base64.getEncoder().encode(outputStream.toByteArray()));
		logger.info(destinationScreenshotFile);
		return encodedBase64;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static void shootPageFullCaptureBase64(WebDriver driver){
		try {
			String screenshotName =scenario.getName().replaceAll(" ", "_");
		BufferedImage image = Shutterbug.shootPage(driver,Capture.FULL,5000,true).getImage();
		ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
		ImageIO.write(image, "png", outputStream);
		String destinationScreenshotFile =Constants.BASEPATH;
		//For More details visit below
		//https://github.com/assertthat/selenium-shutterbug
		//Shutterbug.shootPage(driver,Capture.FULL,2000,true).save(destinationScreenshotFile);
		byte[] bos =outputStream.toByteArray();
		scenario.attach(bos, "image/png", screenshotName);
		logger.info(destinationScreenshotFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	


	public static void base64ScreenshotCapture(WebDriver driver) {
	try {
		scenario.log("Capture Base64 Screenshots ");
		String screenshotName =scenario.getName().replaceAll(" ", "_");
		byte [] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.log("Capture the Screenshot for :- "+scenario.getName());
		scenario.attach(sourcePath, "image/png", screenshotName);
	}catch(NullPointerException e) {
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
	
	public static void base64ScreenshotCapture(WebDriver driver,String screenshotName) {
		try {
			scenario.log("Capture Base64 Screenshots ");
			byte [] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.log("Capture the Screenshot for :- "+screenshotName);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		}
	
	
	public static String compareApiWithUi(Map<String,String> apiResponseMap,Map<String,String> uiResponseMap) {
		Set <Map.Entry<String,String>> firstMap = new HashSet<>(apiResponseMap.entrySet());
		Set <Map.Entry<String,String>> secondMap = new HashSet<>(apiResponseMap.entrySet());
		firstMap.removeAll(uiResponseMap.entrySet());
		secondMap.removeAll(apiResponseMap.entrySet());
		
		firstMap.addAll(secondMap);
		return Arrays.deepToString(firstMap.toArray());
	
	}
	
	
	public static String compareMapOfMapsApiWithUi(LinkedHashMap<String,LinkedHashMap<String,String>> apiResponseMap,LinkedHashMap<String,LinkedHashMap<String,String>> uiResponseMap) {
		Set <Map.Entry<String,LinkedHashMap<String,String>>> firstMap = new HashSet<>(apiResponseMap.entrySet());
		Set <Map.Entry<String,LinkedHashMap<String,String>>> secondMap = new HashSet<>(apiResponseMap.entrySet());
		firstMap.removeAll(uiResponseMap.entrySet());
		secondMap.removeAll(apiResponseMap.entrySet());
		
		firstMap.addAll(secondMap);
		return Arrays.deepToString(firstMap.toArray());
	
	}
	
	
	
}
