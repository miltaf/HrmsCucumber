#Author: Mahboobullah Iltaf. iltaf.mahboob@gmail.com
@sprintAI-17
Feature: Add Emergency Contacts

Background:
Given user is logged with valid admin credentials
And user navigates to EmployeeList

Scenario: Add Employee Emergency contacts

And user click on Emergency Contacts of the selected employee

When user click on Add button

And user add Emergency contact's "name", "relationship" to employee and "Home Telephone", "Mobile number" and "Work Telephone" numbers

And user click on Save

Then employee Emergency Contact Details is added
