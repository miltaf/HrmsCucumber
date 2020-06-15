package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class AddEmergencyContact extends CommonMethods{

	@FindBy (xpath="//*[@id=\"resultTable\"]/tbody/tr[14]/td[3]/a")
	public WebElement EmployeeInfo;
	
	@FindBy (xpath = "//ul[@id=\"sidenav\"]/li[3]/a")
	public WebElement emergContact;
	
	@FindBy (id="btnAddContact")
	public WebElement addContact;
	
	@FindBy(id="emgcontacts_name")
	public WebElement contactName;
	
	@FindBy(id="emgcontacts_relationship")
	public WebElement contactRelationship;
	
	@FindBy (id="emgcontacts_homePhone")
	public WebElement contactHomePhone;
	
	@FindBy(id="emgcontacts_mobilePhone")
	public WebElement contactMobilePhone;
	
	@FindBy(id="emgcontacts_workPhone")
	public WebElement contactWorkPhone;
	
	@FindBy(id="btnSaveEContact")
	public WebElement saveBtn;
	
	@FindBy (id="btnAddAttachment")
	public WebElement addFile;
	
	@FindBy(xpath="//*[@id=\"emgcontact_list\"]/tbody/tr/td[2]/a")
	public WebElement assertEntry;
	
	public AddEmergencyContact() {
		PageFactory.initElements(driver, this);
	}
	
	public void empEmergCD(String name, String relationship, String homeNo, String mobileNo, String workNo) {
		sendText(contactName, name);
		sendText(contactRelationship, relationship);
		sendText(contactHomePhone, homeNo);
		sendText(contactMobilePhone, mobileNo);
		click(saveBtn);
	}
	
}