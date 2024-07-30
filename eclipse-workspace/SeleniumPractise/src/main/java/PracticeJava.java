import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.j2objc.annotations.AutoreleasePool;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeJava {

	public static void main(String[] args) throws Exception
	{
			reverseOfString();
			fibonacciSeries();
			wrapperClasses();
	}
	
	
	
	public static void reverseOfString()
	{
	String str = "suman";
	str.toLowerCase();
	
	char ch[] = str.toCharArray();
	
	for(int i=ch.length-1; i>=0;i--)
	{
		System.out.print(ch[i]);
	}
	}
	
	public static void fibonacciSeries()
	{
		int x = 0, b = 1, c, i, count = 10;
		// To print 0 and 1
		System.out.print(x + " " + b);
		// loop starts from 2. We have already printed 0 and 1 in the previous step
		for (i = 2; i < count; i++) {
			c = x + b;
			System.out.print(" " + c);
			x = b;
			b = c;
		}

	}

	public static void wrapperClasses()
	{
		char ch = 'a';
		// Autoboxing- primitive to Character object
        
        Character a = ch;
        
        Character chh = 'a';
        
        // unboxing - Character object to primitive
        // conversion
        char b = chh;
	}
	
	
	
	
}
