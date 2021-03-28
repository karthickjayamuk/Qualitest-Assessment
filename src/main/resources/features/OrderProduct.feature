Feature: Order Product HappyPath Scenarios

  Scenario Outline: Order T-Shirt (and Verify in Order History)
    Given I am at the ProductHomePage "http://automationpractice.com/index.php"
    And I click SignIn button
    And I Login with eMail "<eMail>" and password "<password>"
    And I navigate to "T-SHIRTS" page
    When I choose "Faded Short Sleeve T-shirts" tShirt product
    And Update productDetails
      | Quantity | <Quantity> |
      | Size     | <Size>     |
      | Color    | <Color>    |
    And add product into Cart
    And complete the checkout and payment using "Pay by Bank wire"
    Then I get the order Reference number
    And verify order exist in Order History

    Examples: 
      | eMail                     | password | Quantity | Size | Color |
      | karthickjayamuk@gmail.com | pass123  |        1 | S    | Blue  |
