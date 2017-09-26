Feature: Login Action

  Scenario: Registration
    Given User is on Home Page
    When User Navigate to registrationPage
    And User enters First Name, Second Name, Last Name
    And User enters "Russia"/ as a Country
    And User enters "6969 Penetration street"/ as an Adress
    And User enters "9166666666"/ as a Phone number
    And User enters an Email
    And User enters "blablabla" as a Password and retypes that as well
    And User pushes Create account button
    Then User gets redirected to login page

  Scenario: Successful LogOut
    When User LogOut from the Application
    Then Message displayed LogOut Successfully