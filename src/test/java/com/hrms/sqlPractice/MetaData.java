package com.hrms.sqlPractice;

import static java.sql.DriverManager.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

public class MetaData {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";

	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void dbMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();
		String driverName = dbMetaData.getDriverName();
		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(driverName);
		System.out.println(dbVersion);
	}

	// query - display all the info about employee whose emp_number is 14688
	@Test
	public void rsMetadata() throws SQLException {
		Connection conn = getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees where emp_number = 14688");
		ResultSetMetaData rsMetadata = rs.getMetaData();
		int colNumbers = rsMetadata.getColumnCount();
		System.out.println(colNumbers);
		String colName1 = rsMetadata.getColumnName(1);
		System.out.println(colName1);
		
		System.out.println("******* to get all title headers of the columns********");
		
		for (int i = 1; i<=colNumbers; i++) {
			String colNames = rsMetadata.getColumnName(i);
			System.out.println(colNames);
		}
	}

}
