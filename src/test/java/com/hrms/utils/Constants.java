package com.hrms.utils;

import java.io.File;

public class Constants {
	
	public static final String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/configs/configuration.properties";
	
	public static final int IMPLICIT_WAIT_TIME=15;
	
	public static final int EXPLICIT_WAIT_TIME=30;
	
	public static final String TESTDATA_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/testdata/HrmsTestData.xlsx";

	public static final String REPORT_FILEPATH=System.getProperty("user.dir")+"/target/html-report/HRMS.html";

	public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"/screenshot/";
}