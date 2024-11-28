@ErrorValidations 
Feature: Validating the Errors
  I want to use this template for my feature file
  
	@ErrorValidations  
  Scenario Outline: Negative tests of submitting the order
  	Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then  "Incorrect email or password." message is displayed

    Examples: 
      | name 												| password  |
      | ankit.solanki@appfoster.com | ankit13 	|
