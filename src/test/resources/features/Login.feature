#Author: asel@syntaxtechs.com
@sprint5 @login
Feature: Login

  @smoke
  Scenario Outline: valid admin and ess login
    When user enter "<Username>" and "<Password>"
    And user click on login button
    Then "<FirstName>" is successfully logged in

    Examples: 
      | Username | Password    | FirstName |
      | Mahady   | Mahady123!! | John      |
      | abd77    | Syntax123!  | Abdullah  |

  @reporting
  Scenario Outline: Error message validation while invalid login
    When user enter "<Username>" and "<Password>"
    And user click on login button
    Then user see "<ErrorMessage>"

    Examples: 
      | Username | Password   | ErrorMessage             |
      | Admin    | Admin123   | Invalid Credentials      |
      | Hello    | Syntax123! | Invalid Credentials      |
      | Admin    |            | Password cannot be empty |
      |          | Syntax123! | Username cannot be empty |
