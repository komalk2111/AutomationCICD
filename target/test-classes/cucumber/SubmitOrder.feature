
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

Background: 
Given I Landed on Ecommerce page
 

  @tag2
  Scenario Outline: Positive Test of submmiting order
    Given Logged in with username <name> and password <password>
    When  I add product <productname> to cart
    And   Checkout <productname>and submit the order
    Then  "Thankyou for the order." message is displayed on ConfirmationPage

    Examples: 
      |     name             |     password         |  productname      |
      | Apurva@gmail.com     |   Apurva1234         |  ZARA COAT 3     |
    
