Feature: Update Account Details Happy Path

  Scenario Outline: Update Personal Information (First Name) in my Account
    Given I am at the ProductHomePage "http://automationpractice.com/index.php"
    And I click SignIn button
    And I Login with eMail "<eMail>" and password "<password>"
    And I click MyAccount
    And I click My Personal Information
    When I Update my firstName as "<newName>"
    And enter account password "<password>"
    And click on save
    Then verify update confirmation "Your personal information has been successfully updated." is displayed

    Examples: 
      | eMail                     | password | newName       |
      | karthickjayamuk@gmail.com | pass123  | KarthickSrini |
