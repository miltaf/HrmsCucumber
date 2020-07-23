package com.hrms.API.steps.practice;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import org.junit.Test;

public class HardcodedExamples {

	/**
	 * Rest Assured methods: given - prepare your request when - you are making the
	 * call to the end point then - validating
	 * 
	 * @param args
	 */
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUzNjc4NDYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTQxMTA0NiwidXNlcklkIjoiNzYzIn0.lRFLgaR8V6D2BKs2gDBKj5dB37OsYqeyVPWsdirnM1Q";

	public void sampleTestNotes() {
		/**
		 * BaseURI for all calls
		 */
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/**
		 * JWT required for all calls - expires every 12 hours
		 */
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUzNjc4NDYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTQxMTA0NiwidXNlcklkIjoiNzYzIn0.lRFLgaR8V6D2BKs2gDBKj5dB37OsYqeyVPWsdirnM1Q";

		/**
		 * Preparing getOneEmployee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "18710A").log().all();

		/**
		 * Storing response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * Two ways to print response prettyPrint() method converts JSON object json
		 * object into string and prints; hence, no need for SOP
		 */
		getOneEmployeeResponse.prettyPrint();
		// String response = getOneEmployeeResponse.body().asString();
		// System.out.println(response);

		/**
		 * verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {

		/**
		 * Preparing request for /createEmployee.php
		 */

		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body("{\r\n" + 
				"  \"emp_firstname\": \"Ali\",\r\n" + 
				"  \"emp_lastname\": \"Afghan\",\r\n" + 
				"  \"emp_middle_name\": \"Sher\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"2000-06-12\",\r\n" + 
				"  \"emp_status\": \"Employee\",\r\n" + 
				"  \"emp_job_title\": \"QA Tester\"\r\n" + 
				"}");
		
		/**
		 * Storing response into createEmployeeResponse
		 */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
		
		/**
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.prettyPrint();
	}
}