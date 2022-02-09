package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.xlUtils;

public class TC_LoginDDT_002 extends baseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.login();
		
		Thread.sleep(3000);
		
		if(isAlertpresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			Thread.sleep(3000);
			lp.logout();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertpresent()//user defined method to check if alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	//take data from xls and store it in a 2d array logindata[r][c]
	{
		String path="C:/eclipse workspace/InetBank/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rownum=xlUtils.getRowCount(path, "sheet1");
		System.out.println(rownum);
		int colcount=xlUtils.getCellCount(path, "sheet1", 1);
		System.out.println(colcount);
		
		String loginData[][]=new String[rownum][colcount];
		//System.out.println(loginData);
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j]=xlUtils.getCellData(path, "sheet1", i, j);
			}
		}
		
		return loginData;
		
	}
	

}
