Feature: Login OLD

  #previously written test
  Scenario: valid admin login
    When user enter valid admin username and password
    And user click on login button
    Then admin user is successfully logged in

  Scenario: valid ess login
    When user enter valid ess username and password
    And user click on login button
    Then ess user is successfully logged in

  #enhancing test with Scenario Outline to login as admin and ess user
  Scenario Outline: 
    When user enter valid "<Username>" and "<Password>"
    And user click on login button
    Then "<FirstName>" is successfully logged in

    Examples: 
      | Username | Password    | FirstName |
      | Mahady   | Mahady123!! | John      |
      | abd77    | Syntax123!  | Abdullah  |

  Scenario: Login with valid username and invalid password
    When User enter valid username and invalid password
    And user click on login button
    Then User see Invalid Credentials text on login page

  #enhancing test with Scenario Outline to login as admin and ess user
  Scenario: Login with invalid credentials
    When I enter invalid username and password and see error message
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Hello    | Syntax123! | Invalid Credentials |
