package com.inetBanking.listeners; //aqfox

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inetBanking.testcases.BaseClass;
import com.inetBanking.utilities.ExtentReporting;

public class MyListerners extends BaseClass implements ITestListener{
	
	ExtentReports report = ExtentReporting.getExtentReport();
	public static ExtentTest etest;
	
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
	    etest = report.createTest(testName);
	    etest.log(Status.INFO, testName+ " execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		etest.log(Status.PASS, testName+ " execution is successful");
	}

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		etest.log(Status.FAIL, testName+ " execution failed");
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		etest.addScreenCaptureFromPath(takeScreenshot(testName,driver), testName);
		
		etest.log(Status.INFO,result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getName();
		etest.log(Status.SKIP, testName+" got skipped");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	File eReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\report.html");
	
	try {
		Desktop.getDesktop().browse(eReportFile.toURI());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
