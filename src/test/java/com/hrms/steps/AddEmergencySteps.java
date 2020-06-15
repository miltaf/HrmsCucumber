package com.hrms.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmergencySteps extends CommonMethods {

	@Given("user navigates to EmployeeList")
	public void user_navigates_to_EmployeeList() {
		jsClick(dashboard.PIM);
		jsClick(dashboard.empListPage);
	}

	@Given("user click on Emergency Contacts of the selected employee")
	public void user_click_on_Emergency_Contacts_of_the_selected_employee() {
		click(addEmerg.EmployeeInfo);
		click(addEmerg.emergContact);
	}

	@When("user click on Add button")
	public void user_click_on_Add_button() {
		click(addEmerg.addContact);
	}

	@When("user add Emergency contact's {string}, {string} to employee and {string}, {string} and {string} numbers")
	public void user_add_Emergency_contact_s_to_employee_and_and_numbers(String name, String relationship, String homeTelephone, String mobileNo, String workNo) {

		sendText(addEmerg.contactName, "Ahmad Popal");
		sendText(addEmerg.contactRelationship, "Brother");
		sendText(addEmerg.contactHomePhone, "+120342849232");
		sendText(addEmerg.contactMobilePhone, "+15712984728");
		sendText(addEmerg.contactWorkPhone, "+44283028302");
		
}

	@When("user click on Save")
	public void user_click_on_Save() {
		click(addEmerg.saveBtn);
}

	@Then("employee Emergency Contact Details is added")
	public void employee_Emergency_Contact_Details_is_added() {
		String expected = "Ahmad Popal";
		String actual = addEmerg.assertEntry.getText();
		Assert.assertEquals(expected, actual);
	}
}
