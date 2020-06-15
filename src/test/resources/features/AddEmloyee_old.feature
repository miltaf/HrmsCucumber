#Author: syntaxteam
Feature: Add new Employee OLD

  Background: 
    Given user is logged with valid admin credentials
    And user navigates to AddEmployeePage

  Scenario: Add Employee with first and lastname
    When user enters employees "John" and "Smith"
    And user clicks save button
    Then "John Smith" is added successfully

  Scenario: Add Employee without employee id
    When user enters employees "John" and "Smith"
    And user deletes employee id
    And user clicks save button
    Then "John Smith" is added successfully

  Scenario: AddEmployee and create Login Credentials
    When user enters employees first name and last name
    And user clicks on create login checkbox
    And user enters login credentials
    And user clicks save button
    Then employee is added successfully

  #to perform DDT in cucumber we use Scenario Outline with Examples
  Scenario Outline: Adding multiple employees
    When user enter employees "<FirstName>", "<MiddleName>" and "<LastName>"
    And user clicks save button
    Then "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName  |
      | James     | J          | Smith     |
      | Faisal    | F          | Sakhi     |
      | Sohil     | S          | Instuctor |
      | Yunus     | Emre       | Yakut     |

  #adding multiple employees using Cucumber DataTable
  Scenario: Adding multiple employees
    When user enters employee details and click on save then employee is added
      | FirstName | MiddleName | LastName |
      | John      | J          | Doe      |
      | Jane      | J          | Smith    |

  Scenario: Adding multiple employees from excel
    When user enters employee data from "EmployeeLoginCredentials" excel sheet then employee is added
    
