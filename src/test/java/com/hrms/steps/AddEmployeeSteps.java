package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user navigates to AddEmployeePage")
	public void user_navigates_to_AddEmployeePage() {
		dashboard.navigateToAddEmployee();
	}

	// this method has hardcoded values
	@When("user enters employees first name and last name")
	public void user_enters_employees_first_name_and_last_name() {
		sendText(addEmp.firstName, "James");
		sendText(addEmp.lastName, "Smith");
	}

	// this method is enhanced method and parameter values are supplied from FF
	@When("user enters employees {string} and {string}")
	public void user_enters_employees_first_name_and_last_name(String firstName, String lastName) {
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		click(addEmp.saveBtn);
	}

	// this method has hardcoded values
	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
		String actual = pdetails.profilePic.getText();
		String expectedName = "James Smith";
		Assert.assertEquals(expectedName, actual);
	}

	// this method is enhanced method and parameter values are supplied from FF
	@Then("{string} is added successfully")
	public void employee_is_added_successfully(String expectedName) {
		String actual = pdetails.profilePic.getText();
		Assert.assertEquals(expectedName, actual);
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
		addEmp.employeeId.clear();
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
		jsClick(addEmp.checkboxLoginDetails);
	}

	@When("user enters login credentials as {string} and {string}")
	public void user_enters_login_credentials(String uid, String pwd) {
		addEmp.createEmpLoginCR(uid, pwd);
	}

	@When("user enter employees {string}, {string} and {string}")
	public void enteringEmployee(String fName, String mName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
	}

	@Then("{string}, {string} and {string} is added successfully")
	public void and_is_added_successfully(String fname, String middleName, String laName) {
		System.out.println("I added the employee !!!!!!!!!!!!!!!!!!!!!!!");
		wait(2);
	}

	@When("user enters employee details and click on save then employee is added")
	public void user_enters_employee_details_and_click_on_save(DataTable dataTable) {

		List<Map<String, String>> addEmployeeList = dataTable.asMaps();

		for (Map<String, String> map : addEmployeeList) {

			String fname = map.get("FirstName");
			String mname = map.get("MiddleName");
			String lname = map.get("LastName");

			sendText(addEmp.firstName, fname);
			sendText(addEmp.middleName, mname);
			sendText(addEmp.lastName, lname);
			click(addEmp.saveBtn);
			// adding assertion

			String actual = pdetails.profilePic.getText();
			String expected = fname + " " + mname + " " + lname;
			Assert.assertEquals("Employee is not addedd successfully", expected, actual);
			jsClick(dashboard.addEmp);
			wait(5);
		}
	}

	@Then("employee is added")
	public void employee_is_added() {
		System.out.println("-----Employee is added using datatable");
	}

	@When("user enters employee data from {string} excel sheet then employee is added")
	public void user_enters_employee_data_from_excel_sheet_then_employee_is_added(String sheetName) {
		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(Constants.TESTDATA_FILEPATH, sheetName);

		for (Map<String, String> data : excelList) {
			String fname = data.get("FirstName");
			String mname = data.get("MiddleName");
			String lname = data.get("LastName");

			sendText(addEmp.firstName, fname);
			sendText(addEmp.middleName, mname);
			sendText(addEmp.lastName, lname);
			click(addEmp.saveBtn);

			String actual = pdetails.profilePic.getText();
			String expected = fname + " " + mname + " " + lname;
			Assert.assertEquals("Employee is not addedd successfully", expected, actual);
			jsClick(dashboard.addEmp);

		}

	}
}
