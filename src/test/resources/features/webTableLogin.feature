Feature: User should be able to login using correct credentials

  Background: user is on the login page
    Given user is on the login page of web table app

  Scenario: Positive login scenario

    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains orders


  Scenario: Positive login scenario

    When user enters username "Test" password "Tester" and logins
    Then user should see url contains orders
    #1- implement this new step
  #2- create login method in WebTableLoginPage
  # this  login method should have multiple overloaded versions



  Scenario: User should be able to login and see the actual url contains orders

    When user enters below credentials
      | username     | Test   |
      | password     | Tester |

    Then user should see url contains orders