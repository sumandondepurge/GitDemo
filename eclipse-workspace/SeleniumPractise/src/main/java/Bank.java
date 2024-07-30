import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Bank {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				
		driver.get("https://dev-diwas.walkingtree.tech/");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id(":r0:"))); // Use the correct locator
        dropdown.click();
        WebElement savingsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Open Savings Account')]")));
        savingsOption.click();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		WebElement chooseTypeofServiceDropdown = driver.findElement(By.xpath("//ul[@id=':r1:']"));		
//		Select select = new Select(chooseTypeofServiceDropdown);
//		Thread.sleep(2000);
//		select.selectByIndex(1);

	
//		chooseTypeofServiceDropdown.click();
//		
//		WebElement openSavingAccount = driver.findElement(By.xpath("text()='Open Savings Account'"));
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(openSavingAccount));
//        openSavingAccount.click();
		
	}

}
