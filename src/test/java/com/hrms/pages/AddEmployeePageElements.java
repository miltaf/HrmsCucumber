package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeePageElements extends CommonMethods {

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;
	
	@FindBy (xpath="//input[@id='middleName']")
	public WebElement middleName;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id = "chkLogin")
	public WebElement checkboxLoginDetails;

	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}

	public void createEmpLoginCR(String uid, String pwd) {
		sendText(username, uid);
		sendText(password, pwd);
		sendText(confirmPassword, ConfigsReader.getProperty("empPassword"));
		click(saveBtn);
	}
}
