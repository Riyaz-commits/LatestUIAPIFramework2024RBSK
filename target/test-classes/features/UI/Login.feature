@UI @Regression

  Feature: Login Functionality for Swag labs

    @Login1
    Scenario Outline: Login Screen validation for Swag Labs for <standard_user> and perform checkout

      Given user launches swag labs in chrome
      And user logs into swag labs successfully
      Then verify the user details afer login
      And user enter the information in the checkout page

      Examples:
      |standard_user|
      |standard_user|

    @Login
    Scenario Outline: Login Screen validation for Swag Labs for <standard_user> with user 2

      Given user launches swag labs
      And user logs into swag labs
      Then verify the user details

      Examples:
        |standard_user|
        |standard_user|
