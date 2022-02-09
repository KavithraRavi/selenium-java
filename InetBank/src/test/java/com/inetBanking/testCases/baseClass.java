package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class baseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseUrl=readConfig.getApplicationUrl();
	public String username = readConfig.getApplicationUsername();
	public String password = readConfig.getApplicationPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		
		logger = Logger.getLogger("Inet Banking");
		PropertyConfigurator.configure("log4j.properties");
		

		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
		driver = new ChromeDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readConfig.getEdgePath());
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
	
	public String randomString()
	{
		String mailrandom = RandomStringUtils.randomAlphabetic(8);
		return mailrandom;
	}
	public static String randomeNum()
	{
		String generateString2 = RandomStringUtils.randomNumeric(4);
		return (generateString2);
	}

}
