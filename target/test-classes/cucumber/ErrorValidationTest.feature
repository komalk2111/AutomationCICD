
@tag
Feature: Error validation
  I want to use this template for my feature file

 

  @Regression
  Scenario Outline: Title of your scenario outline
    Given I Landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      |     name             |     password         | 
      | Apurva@gmail.com     |   Apurva12           |     