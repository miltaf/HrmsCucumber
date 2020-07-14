package com.hrms.sqlPractice;

import java.sql.*;

import org.junit.Test;

public class Recap {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	//jdbc:driverType:hostname:port/db_name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void getConnected() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();
		String dbName = dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_skill");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		System.out.println(colCount);
		
		for (int i = 1; i<=colCount; i++) {
			String colNames = rsMetaData.getColumnName(i);
			System.out.println("Column Name: " +colNames);
		}
		
		String id;
		String name;
		
		while (rs.next()) {
			id = rs.getObject("id").toString();
			name = rs.getObject("name").toString();
			System.out.println(id + " = " + name);
		}
	
		rs.close();
		st.close();
		conn.close();
	}
}
