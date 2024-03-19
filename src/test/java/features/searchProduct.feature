Feature: Search the place the order for the products


  Scenario Outline: Search experience for profuct on home and offers page
    Given user is on GreeCart application
    And user search product <name> short name
    Then user search the same product <name> on offers page and check product exist
    
    Examples:
    | name |
    | Tom  |
    | Beet |
  


