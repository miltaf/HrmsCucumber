#Author: syntaxteam
@sprint6 @addEmployee
Feature: Add new Employee

  Background: 
    Given user is logged with valid admin credentials
    And user navigates to AddEmployeePage

  @smoke
  Scenario: Add Employee with first and lastname
    When user enters employees "John" and "Doe"
    And user clicks save button
    Then "John Doe" is added successfully

  @regression
  Scenario: Add Employee without employee id
    When user enters employees "Jane" and "Smith"
    And user deletes employee id
    And user clicks save button
    Then "Jane Smith" is added successfully

  @smoke
  Scenario: AddEmployee and create Login Credentials
    When user enters employees "James" and "Smith"
    And user clicks on create login checkbox
    And user enters login credentials as "James123" and "James123.."
    And user clicks save button
    Then "James Smith" is added successfully

  #to perform DDT in cucumber we use Scenario Outline with Examples
  @regression
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
  @regression
  Scenario: Adding multiple employees
    When user enters employee details and click on save then employee is added
      | FirstName | MiddleName | LastName |
      | John      | J          | Doe      |
      | Jane      | J          | Smith    |

  @regression
  Scenario: Adding multiple employees from excel
    When user enters employee data from "EmployeeLoginCredentials" excel sheet then employee is added
