import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Notes {

	public static void main(String[] args) throws Exception {

		// Initialization of chromedriver
		// First Method
		System.getProperty("webdriver.chrome.driver", "Path of the chromedriver");
		//Second Method - User need to add library of web driver manager and for new version no need to add included in the selenium
		WebDriverManager.chromedriver().setup();

		//Maximized the window
		// First Method
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);

		//Second Method 
		driver.manage().window().maximize();

		//Screenshot
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File("D:\\");
		FileUtils.copyFile(SrcFile, DestFile);

		//Javascript Executor 
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", driver.findElement(By.name("btnLogin")));

		//getcurrentURl

		String currentURL = driver.getCurrentUrl();

		//Title 
		String tittle = driver.getTitle();

		//To get Attribute value which user provided
		WebElement username = driver.findElement(By.id("sadfa"));
		username.sendKeys("testing1234@gmail.com");
		String user = username.getAttribute("Value");

		//Mouse hover	
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("String"))).build().perform();

		//Select
		Select dropdown = new Select(driver.findElement(By.id("username")));	
		dropdown.selectByIndex(0);
		dropdown.selectByValue("onemore");
		dropdown.selectByVisibleText("sdfds");


		// XPath

		//ID
		driver.findElement(By.id("Username"));
		driver.findElement(By.name("username"));

		//Name
		driver.findElement(By.name("Password"));

		//Class
		driver.findElement(By.className("LoginButton"));

		//Tagname
		driver.findElement(By.tagName("h1"));

		//Linked Text
		driver.findElement(By.linkText("Forgot-Password"));

		//Partial Text - Create an Account
		driver.findElement(By.partialLinkText("Create an"));
		//CSS Selector
		//XPath - What is Xpath - XML Path Lang
		//Dynamic Locator
		//Absolute XPath : Starts from the root element and single slash EX: /html/body/div[2]/form/div[2]
		//If any extra component is added in the middle then it will effect the xpath.

		driver.findElement(By.xpath("/html/body/div[2]/form/div[2]"));


		//Relative XPath : Starts from any point in the document based on the search criteria EX: //input[@id='abcd']

		//	XPath Conditions
		//	And Or Not
		//	driver.findElement(By.xpath("//tagname[@attribute='value' and @attribute = "value']")):
		//	tagname[@attribute='value' or @attribute = "value']
		//	tagname[not@attribute='value']

		// XPath with Index
		driver.findElement(By.xpath("//table[@attribute='value']/body/tr[2]"));
		driver.findElement(By.xpath("(//table[@attribute='value']/body/tr)[2]"));

		//XPath with Text --> Shortcut . dot symbol        	
		driver.findElement(By.xpath("//a[text()='Sign-In']"));

		//XPath with Contains
		driver.findElement(By.xpath("//a[contains(text(), 'Sign-In')]"));
		driver.findElement(By.xpath("//a[contains(@class, 'Sign-In')]"));

		//XPath with Normalize Space - it will identify the web element when there is space after or before the text 
		driver.findElement(By.xpath("//a[normalize-space(text(), 'Sign-In')]"));
		driver.findElement(By.xpath("//a[normalize-space(@class, 'Sign-In')]"));

		//XPath with last - it will identify the last row in the table
		driver.findElement(By.xpath("(//table[@id='contact-list']/tbody/tr)[last()]"));

		//XPath with position - it will identify the row wise position
		driver.findElement(By.xpath("(//table[@id='contact-list']/tbody/tr)[position(3)]"));
		driver.findElement(By.xpath("(//table[@id='contact-list']/tbody/tr)[position>3]"));

		//XPath with Axes
		//Following
		driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[@attribute='value']"));

		//Preceding or Child --> Shortcut /
		driver.findElement(By.xpath("//td[text()='Email']/preceding-sibling::td/child::input"));

		//Parent
		driver.findElement(By.xpath("//td[text()='Helen Bennett']/parent::tr"));

		//Ancestor
		driver.findElement(By.xpath("//td[text()='Helen Bennett']/ancestor::*"));

		//Ancestor or Self
		driver.findElement(By.xpath("//td[text()='Helen Bennett']/ancestor-or-self::*"));

		//Descendant
		driver.findElement(By.xpath("//table[@id=contactlist']/descendant::*"));

		//Descendant or Self
		driver.findElement(By.xpath("//table[@id=contactlist']/descendant-or-selt::*"));

		//Is Selected - we can verify the checkbox is selected or not.
		driver.findElement(By.id("test")).isSelected();

		//Excel Read 
		File file = new File("Path of the excel");
		FileInputStream fis = new FileInputStream(file);
		///New Version XSSF - Old version HSSF	 
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		String rowone = sheet.getRow(0).getCell(0).getStringCellValue();
		// To get count of row
		int rowcount = sheet.getPhysicalNumberOfRows();      
		book.close();

		//String - case sensitive

		String s1 = "Hello";  // create memory in string pool, if value is same then it will not create new memory
		String s2 = new String("Hello");   // create memory in heap memory  for each string
		String s3 = new String("Hello");
		String s4 = "Hello";
		System.out.println(s1==s2); // False
		System.out.println(s2==s3); // True, == operator will verify the adddress
		System.out.println(s1.equals(s2)); //False, it will compare the value or data.
		String s5 = "  ";
		System.out.println(s5.isEmpty()); // 


		//Static & Constructor  -   Constructor always non static -- First static block will execute then main method without create object -- 
		// Static method , main method, non static and constructor
		//	   System.out.println(Notes.io);

		driver.findElement(By.id("weblelement"));

		//Stringbuffer[Mutlithreading] and StringBuilder[Single Threading] - (mutable[String Buffer & String Builder - Only value will be reflected] and 
		//	       immutable[String - when value is updating internally addresses are reflecting not the value ]) 	       

		StringBuffer sb = new StringBuffer("Welcome");
		StringBuilder sb2 = new StringBuilder("Hello");


		switch("browser")
		{
		case "chrome":
			System.out.println("chrome");
			break;

		case "firefox":
			System.out.println("firefox");
			break;

		default:
			System.out.println("default");
			
//Explicit Wait

			WebDriverWait wait=new WebDriverWait(driver, 0);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));

			// Wrapper Class
			//    		   WrapperClasses wc = new WrapperClasses();


		}
	}
}


