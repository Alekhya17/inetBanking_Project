package com.inetBanking.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobjects.AddCustomer;
import com.inetBanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, AWTException {
		LoginPage lp = new LoginPage(driver);
		logger.debug("Switched to iframe");
		WebElement iframe1 = driver.findElement(By.id("gdpr-consent-notice"));
		driver.switchTo().frame(iframe1);
		driver.findElement(By.xpath("//*[@class='action-wrapper']//*[contains(text(),'Accept All')]")).click();
		logger.debug("switched to default page");
		driver.switchTo().defaultContent();
		lp.setUserName(username);
		logger.debug("entered username");
		lp.setPassword(password);
		logger.debug("entered password");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		logger.debug("clicked submit");
		
		AddCustomer addcust = new AddCustomer(driver);
		addcust.clickAddNewCustomer();
		logger.debug("clicked new customer");
		
		Thread.sleep(5000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F12);
		robot.keyRelease(KeyEvent.VK_F12);
		
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_F12);
		robot.keyRelease(KeyEvent.VK_F12);
		logger.debug("closed add");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		addcust.custName("Alekhya");
		addcust.custGender("Female");
		addcust.custdob("04","17","1991");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custCity("Bangalore");
		addcust.custState("Karnataka");
		addcust.custPin("560066");
		addcust.custTeleph("332392213");
		String email = (randomstring()+"@gmail.com");
		addcust.custEmail(email);
		addcust.custPass("abcdef");
		addcust.custFormSubmit();
		Thread.sleep(3000);
		
	boolean res =	driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(res == true) {
		Assert.assertTrue(true);
	}
	
	else {
		takeScreenshot("addcustomer",driver);
		Assert.assertFalse(false);
	}
	
	}
	
	
	
}
