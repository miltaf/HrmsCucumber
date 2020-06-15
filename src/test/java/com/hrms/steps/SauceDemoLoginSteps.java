package com.hrms.steps;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLoginSteps extends CommonMethods {

	@Given("user is on login page")
	public void user_is_on_login_page() {
		//BaseClass.driver.get(ConfigsReader.getProperty("url"));
	}

	@When("user enter invalid username")
	public void user_enter_invalid_username() {
		sendText(sauceLogin.userName, "Admin");

	}

	@When("user enter invalid password")
	public void user_enter_invalid_password() {
		sendText(sauceLogin.password, "Admin@123");
	}

	@When("click on login button")
	public void click_on_login_button() {
		click(sauceLogin.LoginBTN);
	}

	@Then("user should see the error message")
	public void user_should_see_the_error_message() {
		System.err.println("error message diplayed");
	}

	@When("user enter invalid username as {string}")
	public void user_enter_invalid_username_as(String userName) {
		System.out.println(userName);

	}

	@Given("i open database connection")
	public void i_open_database_connection() {
		System.err.println("*****************************");
	}

	@When("user enter invalid password as {string}")
	public void user_enter_invalid_password_as(String pass) {
		System.out.println(pass);

	}
	
	@When("user validates below paragraph")
	public void user_enter_invalid_usernam(String docString) {
	   System.out.println(docString);
	}
	
	@When("user enter invalid username as below")
	public void user_enter_invalid_username_as_below(DataTable dataT) {
	  for(Map<String, String> data :dataT.asMaps()) {
		  System.err.println(data.get("username"));
		  dataT.asList().get(0);
	  }
	    
	   
	}

}
