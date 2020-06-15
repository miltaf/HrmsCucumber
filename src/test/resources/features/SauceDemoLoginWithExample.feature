#Author: Raihan Malegue raihan@raihan.com
Feature: Sace Demo login
  
  Description: US-3421  The purpose of this feature file is
  						to automate sacue demo app login feature with valid and
  						invalid credential
  Acceptance Criteria: I want to automate sauce demo login functionlity

  #Scenario Outline: invalid login
    #Given user is on login page
    #When user enter invalid username as "<username>"
    #And user enter invalid password as "<password>"
    #And click on login button
    #Then user should see the error message
#
    #Examples: 
      #| username | password   |
      #| Admin    | admin123   |
      #| Sarmed   | sarmed@123 |
      #| Sarmed1  | sarmed@22  |
      #| Sarmed2  | sarmed@333 |

  Scenario: invalid login
    Given user is on login page
    When user validates below paragraph
    """
    Each day has a promise to brighten up the day but 
    first you must allow the sun to come your way
    """ 
    And user enter invalid password
    And click on login button
    Then user should see the error message
