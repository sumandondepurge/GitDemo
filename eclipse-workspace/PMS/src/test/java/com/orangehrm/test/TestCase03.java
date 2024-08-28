package com.orangehrm.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orange.baselibrary.BaseLibrary;
import com.orange.page.Scenarios;

public class TestCase03 extends BaseLibrary{

	Scenarios sc;
	
//	@BeforeTest
//    public void setUp() throws Exception {
//		launchDriver();
//		url();
//		 }
	
	@Test(priority=1)
	public void updatecontactone() throws Exception
	{
		sc = new Scenarios(driver);
		sc.homepage("Admin", "admin123");
		sc.contactNumUpdate();
		sc.pimclick();
		captureScreenshot("addemp");
		sc.getJobTitles();
		captureScreenshot("jobtitlelist");
		sc.nationality();
		captureScreenshot("nationalityList");
	}
	
	
	@AfterClass
	public void logout() throws Exception
	{
		sc.logout();
	}
	
//	@AfterTest
//	public void driverclose()
//	{
//		close();
//	}
}
