Feature: Check Dashboard Functionality
  I want to check the Functions on the Dashboard Page

  @UserDropdown @Sanity01
  Scenario: Check the User Dropdown
    Given User on the Login Page
    Then User enters the username "Admin"
    And User enters the password "admin123"
    And User clicks the Login Button
    Then User get Susesfully Logged In to the Application
    Then User click the UserProfile Icon
    Then User Navigate to About Page
    Then User Navigate to Support Page
 
