@UI

  Feature: Login Functionality for Swag labs

    @Login
    Scenario Outline: Login Screen validation for Swag Labs for <standard_user>

      Given user launches swag labs
      And user logs into swag labs
      Then verify the user details

      Examples:
      |standard_user|
      |standard_user|

