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

  @ValidateRBIHolidayMatrix
  Scenario Outline: Validate the RBI Holiday Matrix 
    Given User navigate to the url
    When All the contents is loaded "<step>"
    Then User selects the Regional Office "<regionaloffice>"
    And  User selects the Month "<month>"
    And  User selects the Year "<year>"
    When User clicks the GO Button
    Then Display the Holidays on Screen
    And  User captures the full Screen Display 

    Examples:
  | step | regionaloffice | month  | year|
  | 1    |Nagpur|December|2025|
  | 2    |New Delhi|November|2025|
  | 3    |Select All|May|2025|

Scenario Outline: Add items to cart
  Given I am on the product page
  When I add "<quantity>" of "<product>" to cart
  Then I should see "<total>" in cart

Examples:
  | quantity | product | total  |
  | 1              | Phone    | 500    |
  | 2             | Laptop   | 2000  |

  @CucumberExpression
  Scenario: Some cukes
  Given I have 48 cukes in my belly 

  Scenario: Explain DataTables
  Given the following animals:
  | cow   |
  | horse |
  | sheep |

  Scenario: Explain DataTables Maps
  Given the following full names:
  |Key| Value|
  | Name   | Akshay|
  | Gender | M |
  | Age | 38 |

#In Scenario Outline, you can use tags on different sets of examples like below:

Scenario Outline: Add items to cart
  Given I am on the product page
  When I add "<quantity>" of "<product>" to cart
  Then I should see "<total>" in cart

Examples:
  | quantity | product | total  |
  | 1              | Phone    | 500    |
  | 2             | Laptop   | 2000  |

  Scenario Outline: Login validation
  Given I am on the login page
  When I enter "<username>" and "<password>"
  Then I should see "<message>"

Examples: Valid credentials
  | username | password | message    |
  | user1    | pass1    | Welcome user1 |
  | user2    | pass2    | Welcome user2 |

Examples: Invalid credentials
  | username | password | message    |
  | user3    | pass3    | Invalid credentials |
  | user4    | pass4    | Invalid credentials |
 
 #https://www.miquido.com/blog/cucumber-features/
 #Scenario Context
# Using the Scenario Context we can share data between steps. 
# Let’s assume we have a two steps scenario in which we want 
# to pass value “data” from step 1 to step 2 (Code Block 7).
