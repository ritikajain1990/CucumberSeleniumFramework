

Feature: Add a product and place the order
  

  @smoke
  Scenario: User and add and place the order
    Given user is on GreeCart application
    And user search product <name> to add to cart
    When user add <quantity> product to the cart 
    Then user verify the added product in Checkout Outpage
    And place the order
    When user selects <country> and agree terms
    Then verify order is placed successfully
    
    Examples:
    | name | quantity |country|
    | Tom  | 4        | India|
    
    
    


