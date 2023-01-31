package com.inetBanking.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetBanking.pageobjects.LoginPage;
import com.inetBanking.utilities.XLUtils;
import junit.framework.Assert;
import java.lang.reflect.Method;



public class TC_LoginDDT_002 extends BaseClass{
		
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd,Method method) throws InterruptedException {
		 

		LoginPage lp = new LoginPage(driver);
		logger.debug("Switched to iframe");
		WebElement iframe1 = driver.findElement(By.id("gdpr-consent-notice"));
		driver.switchTo().frame(iframe1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='action-wrapper']//*[contains(text(),'Accept All')]")).click();
		logger.debug("switched to default page");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		lp.setUserName(username);
		logger.debug("entered username");
		lp.setPassword(password);
		logger.debug("entered password");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		logger.debug("clicked submit");
		
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login got failed");
		}
		
		else {
			Assert.assertTrue(true);
			logger.info("login got passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	public boolean isAlertPresent() {
	 try {
		 driver.switchTo().alert();
		 return true;
	 }catch(NoAlertPresentException e){
		 return false;
	 }
	
	}
	
	@DataProvider(name="testdata1")
	String[][] getData() throws Exception{
		
		String path = System.getProperty("user.dir")+"/test/java/com/inetBanking/utilities/XLUtils.java";
		
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colnum = XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]= new String[rownum][colnum];
		
		for(int i=1; i<=rownum; i++) {
			
			for(int j=0; j<colnum; j++ ) {
				
				logindata[i-1][j] = XLUtils.getCellData(path,"sheet1", i, j);
			}
		}
		
		return logindata;
	}
 
}
