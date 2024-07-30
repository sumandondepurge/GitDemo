package com.orange.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Pim {
	
	WebDriver driver;
	 public Pim(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//span[text()='PIM']") WebElement pimbutton;
	 @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']") WebElement addemployee;
	 @FindBy(xpath = "//input[@placeholder='First Name']") WebElement firstnametextfield;
	 @FindBy(name = "middleName") WebElement middlenametextfield;
	 @FindBy(name = "lastName") WebElement lastnametextfield;
	 @FindBy(xpath = "//button[@type='submit']") WebElement submitbutton;
	 
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
	}
	

}
