package com.orange.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Admin  {
	
	
	
	WebDriver driver;
	 public Admin(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="//span[text()='Admin']") WebElement adminbutton;
	@FindBy(linkText = "Nationalities") WebElement admin_nationalities;
	
	public void nationality() throws Exception
	{
		Thread.sleep(5000);
		adminbutton.click();
		admin_nationalities.click();
		List<WebElement> nationalityElements = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
	    String[] nationalities = new String[nationalityElements.size()];
	    for (int i = 0; i < nationalityElements.size(); i++) {
	    nationalities[i] = nationalityElements.get(i).getText();
	    System.out.println(nationalities[i]);
	}
	}
}
