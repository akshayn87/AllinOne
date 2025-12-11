package steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import base.Driverfactory;
import config.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.HolidayMatrix;
import pages.LoginPage;
import utils.ExtentReporter;
import utils.GenericLib;
import steps.Hook;


public class DashBoarddefs {

	private DashBoardPage dashboardpage = new DashBoardPage(Driverfactory.getDriver());
	
	private LoginPage loginpage = new LoginPage(Driverfactory.getDriver());
	
	private HolidayMatrix hmatrix = new HolidayMatrix(Driverfactory.getDriver());
	
	private ConfigReader cgr = new ConfigReader();
     ExtentReporter extent = new ExtentReporter();

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

	@Given("I have {int} cukes in my belly")
    public void i_have_n_cukes_in_my_belly(int cukes) {
        System.out.format("Cukes: %n\n", cukes);
    }

    @Given("User navigate to the url")
    public void User_navigate_to_the_url() {
		String url = "https://www.rbi.org.in/Scripts/HolidayMatrixDisplay.aspx";
        extent.LogTest(Driverfactory.getDriver(), "User navigate to the url");
		hmatrix.navigateToUrl(url);
	}

   @Given("the following animals:")
public void the_following_animals(List<String> animals) {
}

 @Given("the following full names:")
    public void the_following_full_names(DataTable dataTable) {
		List <Map <String,String>> data = dataTable.asMaps();
		for(Map<String,String> form :data){
			String ColumnName = form.get("Key");
			String ValueName = form.get("Value");
			System.out.println(ColumnName +":"+ ValueName);
		}

        // Write code here that turns the phrase above into concrete actions
    }


    @Given("user is logged in")
    public void user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("user will be logged out")
    public void user_will_be_logged_out() {
        // Write code here that turns the phrase above into concrete actions
    }

  

  

    @Given("I am on the product page")
    public void I_am_on_the_product_page() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I add {string} of {string} to cart")
    public void I_add_of_to_cart(String s, String s2) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see {string} in cart")
    public void I_should_see_in_cart(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("I am on the login page")
    public void I_am_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see {string}")
    public void I_should_see(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I enter {string} and {string}")
    public void I_enter_and(String s, String s2) {
        // Write code here that turns the phrase above into concrete actions
    }

     @Then("User selects the Regional Office {string}")
    public void User_selects_the_Regional_Office(String string) {
             extent.LogTest(Driverfactory.getDriver(), "User selects the Regional Office "+string);
             hmatrix.selectRegionalOffice(string);
   
    }

    

    @Then("User selects the Month {string}")
    public void User_selects_the_Month(String month) {
        extent.LogTest(Driverfactory.getDriver(), "User selects the Month ");
        hmatrix.selectMonth(month);
    }

    @Then("User selects the Year {string}")
    public void User_selects_the_Year(String year) {
        extent.LogTest(Driverfactory.getDriver(), "User selects the Year ");
        hmatrix.selectYear(year);
    }

    @When("User clicks the GO Button")
    public void User_clicks_the_GO_Button() {
           extent.LogTest(Driverfactory.getDriver(), "User clicks the GO Button ");
           hmatrix.submitGo();
    }

    @Then("Display the Holidays on Screen")
    public void Display_the_Holidays_on_Screen() {
           extent.LogTest(Driverfactory.getDriver(), "Display the Holidays on Screen ");
           hmatrix.Display();
    }

    @Then("User captures the full Screen Display")
    public void User_captures_the_full_Screen_Display() {
          extent.LogTest(Driverfactory.getDriver(), "User captures the full Screen Display");
    }

   

    @When("All the contents is loaded {string}")
    public void All_the_contents_is_loaded(String string) {
              hmatrix.loadallcontents();
        extent.LogTest(Driverfactory.getDriver(), "All the content is loaded"+string);
  
    }

   
   
  
	
	
}
