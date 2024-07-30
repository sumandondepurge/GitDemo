package com.orange.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobTitle  {

	WebDriver driver;
	 public JobTitle(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }

	 @FindBy(xpath = "//span[text()='Admin']") WebElement adminbutton;
	 @FindBy(xpath = "//span[text()='Job ']") WebElement admin_job;
	 @FindBy(linkText = "Job Titles") WebElement admin_job_jobtitle;
	 @FindBy(xpath = "//div[@class='oxd-table-body']/div") List<WebElement> jobtitle_list;
	 
	public void getJobTitles() throws Exception
	{
		
		adminbutton.click();
        Thread.sleep(3000);
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
}
