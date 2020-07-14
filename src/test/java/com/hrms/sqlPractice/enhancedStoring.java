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

public class enhancedStoring {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	public void getAndStoreData1() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_nationality");
		
		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<Map<String, String>> dataList = new ArrayList<>();
		Map<String, String>dataMap;
		
		while(rs.next()) {
			dataMap = new LinkedHashMap<>();
			for (int i=1; i<=rsMetaData.getColumnCount(); i++) {
				dataMap.put(rsMetaData.getCatalogName(i), rs.getObject(i).toString());
			}
			dataList.add(dataMap);
		}
		System.out.println(dataList);
	}
	
	public void getAndStoreData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_language");

		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<Map<String, String>> listData = new ArrayList<>();

		Map<String, String> mapData;

		while (rs.next()) {
			mapData = new LinkedHashMap<>();
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
				mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			}
			listData.add(mapData);
		}
		System.out.println(listData);
		
		rs.close();
		st.close();
		conn.close();
	}
	

}
