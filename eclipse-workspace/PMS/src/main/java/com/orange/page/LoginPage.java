package com.orange.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	 {
        this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	
	@FindBy(name="username") WebElement orange_username;	
	 @FindBy(name="password") WebElement orange_password;	
    @FindBy(xpath="//button[@type='submit']") WebElement orange_signin;
	
	public void homepage(String uname, String password) throws Exception {
		Thread.sleep(2000);
		orange_username.sendKeys(uname);
		orange_password.sendKeys(password);
		orange_signin.click();
//Assertions
		String actualTitle = driver.getTitle();
		String exceptedTitle = "OrangeHRM";
		Assert.assertEquals(actualTitle, exceptedTitle, "Title is not matching");

	}
}
