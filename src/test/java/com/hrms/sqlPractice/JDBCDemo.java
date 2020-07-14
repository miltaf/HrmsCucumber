package com.hrms.sqlPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo {
	

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	
	// jdbc - is Java DataBase Connectivity - it is just a bridge between our databse and Java
	// jdbc:driverType://hostname:port/dbName
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void abc() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees");
		rs.next();
		String firstname = rs.getString("emp_firstname");
		System.out.println(firstname);
		rs.next();
		String firstname2 = rs.getString("emp_firstname");
		System.out.println(firstname2);
		String allData;
		while(rs.next()) {
			//allData = rs.getString("emp_firstname"); - also possible when we know that all are String
			allData = rs.getObject("emp_firstname").toString(); // to get objects and turn them into String
			System.out.println(allData);
		}
		
		rs.close();
		st.close();
		conn.close();
	}
}
