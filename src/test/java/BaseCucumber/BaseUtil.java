package BaseCucumber;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class BaseUtil {
	public WebDriver Driver;
	public static Scenario scenario;
	public String strBrowser="chrome";
	public String strURL;
	public static final int shortwait =10;
	public static final int mediumwait =10;
	public static final int longwait =10;
	public ArrayList<byte []> byteList = new ArrayList<>();


}
