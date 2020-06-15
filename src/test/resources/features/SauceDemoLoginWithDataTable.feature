#Author: Raihan Malegue raihan@raihan.com
Feature: Sace Demo login
  
  


  Scenario: invalid login
  Given user is on login page
    When user enter invalid username as below
    |username|
    |admin|
    |regular|
    And click on login button
    Then user should see the error message
  