@Regression
 Feature: User Login Functionalities for Sauce Demo Labs

   @TestCase1
   Scenario: User Login in to Sauce labs with valid credentials

     Given User logs tries login into application
     When user should login to the Application successfully
     Then User should be shown the products


   @TestCase1
   Scenario: User Login in to Sauce labs with valid again

     Given User logs tries login into application
     When user should login to the Application successfully
     Then User should be shown the products


   @TestCase1
   Scenario: User Login in to Sauce labs with valid with sauce url

     Given User logs tries login into application
     When user should login to the Application successfully
     Then User should be shown the products in screen