package com.orangehrm.test;

import org.junit.After;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orange.baselibrary.BaseLibrary;
import com.orange.page.Admin;
import com.orange.page.MyInfo;
import com.orange.page.Pim;


public class PimAddEmp  {

	public PimAddEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	Admin ad;
	MyInfo mi;
	Pim pi;
	
	@Test(priority=2)
	public void nationalitydisplay() throws Exception
	{
//		ad = new Admin();
		ad.nationality();
	}
	@Test(priority=3)
	public void updateRecordMyInfo() throws Exception
	{
//		mi = new MyInfo();
		mi.contactNumUpdate();
		
	}
	@Test(priority=1)
	public void addingemp() throws Exception
	{
//		pi = new Pim();
		pi.pimclick();
	}
	
	@BeforeTest
	public void driver() throws Exception
	{
		
//		launchDriver();
//		launchURL();
	}
	

}
