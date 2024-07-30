package com.orange.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyInfo
{
	
	WebDriver driver;
	
	public MyInfo(WebDriver driver)
	 {
        this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//span[text()='My Info']") WebElement myinfobutton;
	 @FindBy(linkText = "Contact Details") WebElement myinfo_contactdetails;
	 @FindBy(xpath = "//label[text()='Mobile']/parent::div/following-sibling::div/input") WebElement contacttextfeild;
	 @FindBy(xpath = "//button[text()=' Save ']") WebElement contactsave;
	 @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']") WebElement logoutdropdown;
	 @FindBy(xpath = "//a[text()='Logout']") WebElement logoutbutton;
	 
	 
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
	
	public void logout() throws Exception
	{
		Thread.sleep(1000);
		logoutdropdown.click();
        Thread.sleep(1000);
        logoutbutton.click();
        Thread.sleep(2000);
	}
}
