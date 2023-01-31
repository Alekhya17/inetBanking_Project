package com.inetBanking.testcases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rc= new ReadConfig();
	public String baseURL=rc.getURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	 public WebDriver getDriver() {
	        return driver;
	    }
	 
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		logger = LogManager.getLogger("ebanking");
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", rc.getChromepath());
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
		System.setProperty("webdriver.geckodriver", rc.getFirefoxpath());
		driver= new FirefoxDriver();
		}
		else if(br.equals("msedge")) {
			System.setProperty("webdriver.msedgedriver", rc.getMsedgepath());
			driver= new EdgeDriver();	
		}
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {		
		driver.quit();
	}
	
	
	
	public String takeScreenshot(String testName, WebDriver driver) {
		
		File sourceScreenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFile= new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
		try {
			FileUtils.copyFile(sourceScreenshotFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destinationFile.getAbsolutePath();
	}
	
	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomNum() {
		String generatedstring2= RandomStringUtils.randomAlphabetic(4);
		return (generatedstring2);
	}
}
