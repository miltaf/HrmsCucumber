package com.hrms.sqlPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringData {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	//jdbc:driverType:hostname:port/db_name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";


	@Test
	public void getAndSotreData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location");

		List<Map<String, String>>listOfData = new ArrayList<>();
		Map<String, String>mapData;
		
		while(rs.next()) {
			mapData = new LinkedHashMap<>();
			mapData.put("Location id", rs.getObject("id").toString());
			mapData.put("Office name", rs.getObject("name").toString());
			mapData.put("country code", rs.getObject("country_code").toString());
			System.out.println(mapData);
			listOfData.add(mapData);
		}
			System.out.println(listOfData);
	
		}
}
