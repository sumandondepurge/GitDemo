package com.orangehrm.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orange.baselibrary.BaseLibrary;
import com.orange.page.Admin;
import com.orange.page.JobTitle;
import com.orange.page.LoginPage;
import com.orange.page.MyInfo;
import com.orange.page.Pim;

public class TestCase02 extends BaseLibrary{

	LoginPage loginPage;
	Pim pi;
	MyInfo mi;
	JobTitle jt;
	Admin ad;
	
	@BeforeClass
    public void setUp() throws Exception {
		launchDriver();
		url();
		loginPage = new LoginPage(driver);
    }
	
	@Test(priority=1)
	public void testLogin() throws Exception
	{
		loginPage.homepage("Admin", "admin123");
	}
	
	@Test(priority=2)
	public void updatecontactone() throws Exception
	{
		mi = new MyInfo(driver);
		mi.contactNumUpdate();
	}
	
	@Test(priority=3)
	public void addemp() throws Exception
	{
		pi = new Pim(driver);
		pi.pimclick();
		captureScreenshot("addemp");
	}
	
	@Test(priority=4)
	public void jobTitleList() throws Exception
	{
		jt = new JobTitle(driver);
		jt.getJobTitles();
		captureScreenshot("jobtitlelist");
	}
	
	@Test(priority=5)
	public void nationalityList() throws Exception
	{
		ad = new Admin(driver);
		ad.nationality();
		captureScreenshot("nationalityList");
	}
	
	@AfterClass
	public void logout() throws Exception
	{
		mi.logout();
	}
	
	@AfterTest
	public void driverclose()
	{
		close();
	}
}
