package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extent_report {
	
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest logger;
	
	 public static  void extentReportInitialization() {
		 
		 extentSparkReporter = new ExtentSparkReporter("D:\\OLD LAPTOP DATA\\DESK DATA\\eclipse-workspace\\Orange_HRM_project\\extentReport\\testreport.html");
		 //location of extent report folder
		 extentReports = new ExtentReports();
		 //config and create the report
		 extentReports.attachReporter(extentSparkReporter);
		 // User to manage the reporting
		 
	 }
	 
	 public static void extentReportGenerate() {
		 extentReports.flush();
		 //It is respon sible for finlizing and saving the report
	 }
	 
	 public static void extentReportCreateTest(String testName) {
		logger =  extentReports.createTest(testName);
		//This method create new testname in report 
	 }

}
	

