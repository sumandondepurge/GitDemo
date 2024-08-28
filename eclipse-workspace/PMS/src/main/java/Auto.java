

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Auto {
	static WebDriver driver;
	static WebDriverWait wait;


	public static void main(String[] args) throws Exception
	{

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();	
		wait = new WebDriverWait(driver, 20);

		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);  
		wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Job ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Job Titles")).click();
		Thread.sleep(3000);
		List<WebElement> jobTitleRows = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
		for (WebElement row : jobTitleRows) {
			String jobTitle = row.getText();
			System.out.println(jobTitle);
		}
		driver.findElement(By.id("applyleave_txtFromDate")).clear();
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-07-10");
		driver.findElement(By.id("applyleave_txtToDate")).clear();
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-07-15");

		driver.findElement(By.id("applyleave_txtComment")).sendKeys("Bereavement leave application.");

		// Submit the leave application
		driver.findElement(By.id("applyBtn")).click();



		//Logout 
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		Thread.sleep(1000); // Wait for the dropdown to appear
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(3000); // Wait for the logout process


		//MyInfo
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contact Details")).click();
		Thread.sleep(2000);
		WebElement countryDropdown = driver.findElement(By.xpath("//label[text()='Country']/parent::div/following-sibling::div"));

		List<WebElement> options = driver.findElements(By.xpath("//label[text()='Country']/parent::div/following-sibling::div"));
		for (WebElement option : options) {
			if (option.getText().equals("Chad")) { // Replace with the text of the option you want to select
				option.click();
				break;
			}
			System.out.println(option);
		}






		//My Info
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contact Details")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Mobile']/parent::div/following-sibling::div/input")).sendKeys("99838383838");
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		//HomePage
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("suman");
		driver.findElement(By.name("middleName")).sendKeys("automation");
		driver.findElement(By.name("lastName")).sendKeys("walkingtree");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.linkText("Employee List")).click();
		System.out.println("Employe Added");
		Thread.sleep(1000);	
		//Admin Page	
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Nationalities")).click();
		Thread.sleep(2000);
		List<WebElement> nationalityElements = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
		String[] nationalities = new String[nationalityElements.size()];
		for (int i = 0; i < nationalityElements.size(); i++) {
			nationalities[i] = nationalityElements.get(i).getText();
			System.out.println(nationalities[i]);

		}



	}
}









