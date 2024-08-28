package com.orangehrm.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.orange.baselibrary.BaseLibrary;
import com.orange.page.Admin;
import com.orange.page.JobTitle;
import com.orange.page.LoginPage;
import com.orange.page.MyInfo;
import com.orange.page.Pim;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase01 {
	
	public WebDriver driver;
    BaseLibrary bl;
    MyInfo mi;
    Pim pi;
    Admin ad;
    JobTitle jt;
    LoginPage lp;
	@Test
	public void updateContactInfo() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		mi = new MyInfo(driver);
		lp.homepage("Admin", "admin123");
		pi = new Pim(driver);
		pi.pimclick();
		ad = new Admin(driver);
		ad.nationality();
		jt = new JobTitle(driver);
		jt.getJobTitles();
		
	}
	
	

}
