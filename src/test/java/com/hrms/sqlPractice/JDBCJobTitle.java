package com.hrms.sqlPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCJobTitle {
	// retrieve all the job titles and store them in arraylist and show it in
	// console from arraylist

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";

	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void jobTitle() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");

		System.out.println("************first way******************");
		
		rs.next();
		
		String jobTitle = rs.getString("job_title");
		System.out.println(jobTitle);
		
		String allData;
		while (rs.next()) {
			allData = rs.getObject("job_title").toString();
			System.out.println(allData);
			

		System.out.println("******************second way*****************");
		
		List<String> jobTitles = new ArrayList<>();
		while (rs.next()) {
			jobTitles.add(rs.getObject("job_title").toString());
		}
		System.out.println(jobTitles); // to print them all in the same block in one line
	
		System.out.println("*******************");
		// to loop through them and print each in each line, we can also use advanced for loop
		for (String jt : jobTitles) {
			System.out.println(jt);
		}
	}

	}
}
