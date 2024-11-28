
@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When  I add product <productName> to the cart
    And   Checkout <productName> and submit the Order
    Then  "THANKYOU FOR THE ORDER." is displayed on confirmationPage

    Examples: 
      | name 												| password  | productName |
      | ankit.solanki@appfoster.com | ankit123 	| ZARA COAT 3	|
