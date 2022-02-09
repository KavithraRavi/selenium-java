package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	
	WebDriver ldriver;
	
	public AddCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@CacheLookup
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddCustomer;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="name")
	WebElement txtCustomerName;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="rad1")
	WebElement rbtnGender;
	
	@CacheLookup
	@FindBy(how=How.ID_OR_NAME,using="dob")
	WebElement dateofbirth;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="addr")
	WebElement address;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="city")
	WebElement city;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="state")
	WebElement State;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="pinno")
	WebElement pincode;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement telphoneno;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="emailid")
	WebElement mailid;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="sub")
	WebElement btnSubmit;
	
	public void clickAddCustomer()
	{
		lnkAddCustomer.click();
	}
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	public void custGender(String cGender1)
	{
		rbtnGender.click();
	}
	public void dateOfBirth(String mm,String dd,String yy)
	{
		dateofbirth.sendKeys(mm);
		dateofbirth.sendKeys(dd);
		dateofbirth.sendKeys(yy);
	}
	public void custAddress(String addr)
	{
		address.sendKeys(addr);
	}
	public void custcity(String ccity)
	{
		city.sendKeys(ccity);
	}
	public void custstate(String cstate)
	{
		State.sendKeys(cstate);
	}
	public void custPincode(String pinno)
	{
		pincode.sendKeys(pinno);
	}
	public void custtelephone(String telph)
	{
		telphoneno.sendKeys(telph);
	}
	public void custmailid(String mail)
	{
		mailid.sendKeys(mail);
	}
	public void custpasswd(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void submit()
	{
		btnSubmit.click();
	}
	
	
	
	
	
	
}
