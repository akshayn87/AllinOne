package steps;

import org.junit.Assert;

import base.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.GenericLib;


public class DashBoarddefs {

	private DashBoardPage dashboardpage = new DashBoardPage(Driverfactory.getDriver());
	
	private LoginPage loginpage = new LoginPage(Driverfactory.getDriver());
	
	@Then("User click the UserProfile Icon")
	public void user_click_the_user_profile_icon() {
	    dashboardpage.userDropdown();
	    
	    
	}

	@Then("User Navigate to About Page")
	public void user_navigate_to_about_page() {
	   dashboardpage.navigatetoAboutPagefromUserDropDown();
	   dashboardpage.getOrangePageAttributes();
	   dashboardpage.closeAboutPage();
	}

	@Then("User Navigate to Support Page")
	public void user_navigatetoSupportPagefromUserDropDown() {
		dashboardpage.navigatetoSupportPagefromUserDropDown();
	}
	
	@Given("User on the Login Page")
	public void user_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User on the OrangeHRM Page");
	    GenericLib.waitForJSandJQueryToLoad(Driverfactory.getDriver());
	    String pageTitle =loginpage.getTitleOfPage();
	    System.out.println("Page Title :-"+pageTitle);
	}

	@Then("User enters the username {string}")
	public void user_enters_the_username(String username) {
		  System.out.println("User enter the user Name :"+username);
		  loginpage.enterUsername(username);
		
	}

	@Then("User enters the password {string}")
	public void user_enters_the_password(String password) {
		System.out.println("User enter the Password :"+password);
		  loginpage.enterPassword(password);
	}

	@Then("User clicks the Login Button")
	public void user_clicks_the_login_button() {
	   System.out.println("User clicks on the Login Button");
	   loginpage.clickLogin();
	   GenericLib.waitForJSandJQueryToLoad(Driverfactory.getDriver());
	}

	@Then("User get Susesfully Logged In to the Application")
	public void user_get_susesfully_logged_in_to_the_application() {
	    System.out.println("User sucessfully navigates to the dashboard and Asserts the title of the Page");
	    String Titleofpage = Driverfactory.getDriver().getTitle();
	    System.out.println("Url of Page :"+Driverfactory.getDriver().getCurrentUrl());
	    Assert.assertEquals("Passed", Titleofpage, "OrangeHRM");
	    
	}
	
	@Given("User on DashBoard")
	public void user_on_dash_board() {
	    loginpage.assertOnDashBoard();
	}
	@Then("User Logout from the Application")
	public void user_logout_from_the_application() {
	    loginpage.logoutApplication();
	}

	
	
}
