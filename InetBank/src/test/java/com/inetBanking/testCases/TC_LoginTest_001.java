package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends baseClass 
{
	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseUrl);
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.login();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
				{
					Assert.assertTrue(true);
					logger.info("Test Case Passed");
				}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}
	}
}
