package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	//PageObjectClass for Login Page
	WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver)
	{
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Finding the element
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	//Action Methods
	public void setUserName(String uName)
	{
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void login()
	{
		btnlogin.click();
	}
	public void logout()
	{
		lnkLogout.click();
	}
}
