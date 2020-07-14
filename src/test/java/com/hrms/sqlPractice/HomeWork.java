package com.hrms.sqlPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HomeWork {

	// hw get the resultset metadata store it in the arraylist and retrieve it from arraylist
	// also get column type name get the table names
	
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void rsMetaData() throws SQLException {
		Connection cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_nationality where name like 'B%'");
		ResultSetMetaData rsMetadata = rs.getMetaData();
		
		String tname = rsMetadata.getTableName(1);
		System.out.println("Table name is "+tname);
		
		int columnType = rsMetadata.getColumnType(1);
		System.out.println("column type "+ columnType);
		
		int columnNum = rsMetadata.getColumnCount();
		System.out.println("column number is "+columnNum);
		
		for (int i = 1; i<=columnNum; i++) {
			String columnNames = rsMetadata.getColumnName(i);
			System.out.println("column name is "+columnNames);
		}
		
		List<String>languages = new ArrayList<>();
		while (rs.next()) {
			languages.add(rs.getObject("name").toString());
		}

		System.out.println(languages);
		
		for (String langNames: languages) {
			System.out.println(langNames);
		}
		rs.close();
		st.close();
		cn.close();
}
}
