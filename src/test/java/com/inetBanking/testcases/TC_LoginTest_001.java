package com.inetBanking.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.inetBanking.pageobjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass { 

	@Test
	public void loginTest() {
		
		logger.debug("URL opened");
		driver.manage().window().maximize();
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
		
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.debug("loginTest passed");
		}
		else {
			takeScreenshot("loginTest",driver);
			Assert.fail("failed");
			logger.debug("loginTest failed");
			System.out.println("Screenshot taken");
		}
	}
}
