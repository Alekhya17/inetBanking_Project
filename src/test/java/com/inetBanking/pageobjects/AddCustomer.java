package com.inetBanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	public static WebDriver ldriver;
	
	public AddCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how = How.XPATH, using="//*[@class='orange']/following-sibling::li[1]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddr;
	
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtTelephoneno;

	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement txtPswd;
	
	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
		System.out.println("clicked new customer");
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String gender) {
		rdGender.click();
	}
	
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String caddress) {
		txtaddr.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void custPin(String cpin) {
		txtPin.sendKeys(String.valueOf(cpin));
	}
	
	public void custTeleph(String ctell) {
		txtTelephoneno.sendKeys(ctell);
	}
	
	public void custEmail(String cemail) {
		txtEmail.sendKeys(cemail);
	}
	
	public void custPass(String cpass) {
		txtPswd.sendKeys(cpass);
	}
	
	public void custFormSubmit() {
		btnSubmit.click();;
	}
	
}
