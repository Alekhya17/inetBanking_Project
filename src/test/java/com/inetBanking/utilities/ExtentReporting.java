package com.inetBanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

public class ExtentReporting {

	public static  ExtentReports getExtentReport() {
		ExtentReports extent;
		ExtentSparkReporter spark;
		extent = new ExtentReports();
		//extent.createTest("logindata");
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\report.html");
		spark = new ExtentSparkReporter(extentReportFile);
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		
		return extent;
	}
}
