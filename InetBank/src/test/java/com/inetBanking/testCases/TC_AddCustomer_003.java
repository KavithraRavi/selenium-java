package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends baseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
	
	LoginPage lp=new LoginPage(driver);
	
	lp.setUserName(username);
	logger.info("username is provided");
	
	lp.setPassword(password);
	logger.info("password is provided");
	
	lp.login();
	
	Thread.sleep(3000);
	
	AddCustomer addcust = new AddCustomer(driver);
	
	//driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	
	addcust.clickAddCustomer();
	
	logger.info("providing customer details........");
	
	addcust.custName("kavithra");
	addcust.custGender("f");
	
	WebElement radio = driver.findElement(By.xpath("//input[@value='f']"));
	radio.click();

	
	addcust.dateOfBirth("12","22" ,"1987");
	addcust.custAddress("Lynarstrasse 1");
	addcust.custcity("Berlin");
	addcust.custstate("berlin");
	addcust.custPincode("135815");
	addcust.custtelephone("1234567890");
	
	String email=randomString()+"@gmail.com";
	addcust.custmailid(email);
	addcust.custpasswd("adbcded");
	addcust.submit();
	
	Thread.sleep(3000);
	
	logger.info("validation started....");
	
	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(res==true) 
	{
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
	}
		
	}
	
	
}
