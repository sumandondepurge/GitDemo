package com.orange.baselibrary;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary{
	
	protected WebDriver driver;
	
	@BeforeTest
	public void launchDriver() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@BeforeClass
	public void url()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	public void captureScreenshot(String screenshotName) throws Exception
	{
		Thread.sleep(3000);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
       
        
		try {
		 File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File DestFile=new File(".\\Screenshots\\"+fileName);
				FileUtils.copyFile(SrcFile, DestFile); 
				}
			 catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void implicitwait(int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	
}
