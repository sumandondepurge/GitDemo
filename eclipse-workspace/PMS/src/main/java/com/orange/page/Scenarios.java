package com.orange.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Scenarios {

	WebDriver driver;

	public Scenarios(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Nationalities") WebElement admin_nationalities;
	@FindBy(xpath = "//span[text()='PIM']") WebElement pimbutton;
	@FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']") WebElement addemployee;
	@FindBy(xpath = "//input[@placeholder='First Name']") WebElement firstnametextfield;
	@FindBy(name = "middleName") WebElement middlenametextfield;
	@FindBy(name = "lastName") WebElement lastnametextfield;
	@FindBy(xpath = "//button[@type='submit']") WebElement submitbutton;
	@FindBy(xpath = "//span[text()='My Info']") WebElement myinfobutton;
	@FindBy(linkText = "Contact Details") WebElement myinfo_contactdetails;
	@FindBy(xpath = "//label[text()='Mobile']/parent::div/following-sibling::div/input") WebElement contacttextfeild;
	@FindBy(xpath = "//button[text()=' Save ']") WebElement contactsave;
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']") WebElement logoutdropdown;
	@FindBy(xpath = "//a[text()='Logout']") WebElement logoutbutton;
	@FindBy(xpath = "//span[text()='Admin']") WebElement adminbutton;
	@FindBy(xpath = "//span[text()='Job ']") WebElement admin_job;
	@FindBy(linkText = "Job Titles") WebElement admin_job_jobtitle;
	@FindBy(xpath = "//div[@class='oxd-table-body']/div") List<WebElement> jobtitle_list;
	@FindBy(name="username") WebElement orange_username;	
	@FindBy(name="password") WebElement orange_password;	
	@FindBy(xpath="//button[@type='submit']") WebElement orange_signin;

	public void homepage(String uname, String password) throws Exception 
	{
		try {
			Thread.sleep(2000);
			orange_username.sendKeys(uname);
			orange_password.sendKeys(password);
			orange_signin.click();
			//Assertions
			String actualTitle = driver.getTitle();
			String exceptedTitle = "OrangeHRM";
			Assert.assertEquals(actualTitle, exceptedTitle, "Title is not matching");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void contactNumUpdate() throws Exception
	{
		Thread.sleep(3000);
		myinfobutton.click();
		Thread.sleep(2000); // Wait for My Info tab to open
		myinfo_contactdetails.click();
		Thread.sleep(3000);
		contacttextfeild.clear();
		contacttextfeild.sendKeys("12");
		contactsave.click();
	}

	public void getJobTitles() throws Exception
	{
		
		adminbutton.click();
		Thread.sleep(5000);
		admin_job.click();
		Thread.sleep(2000);
		admin_job_jobtitle.click();
		Thread.sleep(3000);
		List<WebElement> jobTitleRows = jobtitle_list;
		for (WebElement row : jobTitleRows) {
			String jobTitle = row.getText();
			System.out.println(jobTitle);
		}
	}

	public void nationality() throws Exception
	{
		try {
			Thread.sleep(5000);
			adminbutton.click();
			admin_nationalities.click();
			List<WebElement> nationalityElements = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
			String[] nationalities = new String[nationalityElements.size()];
			for (int i = 0; i < nationalityElements.size(); i++) {
				nationalities[i] = nationalityElements.get(i).getText();
				System.out.println(nationalities[i]);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void pimclick() throws Exception
	{
		Thread.sleep(5000);
		pimbutton.click();
		Thread.sleep(5000);
		addemployee.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		firstnametextfield.sendKeys("suman");
		middlenametextfield.sendKeys("automation");
		lastnametextfield.sendKeys("walkingtree");
		Thread.sleep(3000);
		submitbutton.click();
		Thread.sleep(3000);
	}

	public void logout() throws Exception
	{
		try {
			Thread.sleep(1000);
			logoutdropdown.click();
			Thread.sleep(1000);
			logoutbutton.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
