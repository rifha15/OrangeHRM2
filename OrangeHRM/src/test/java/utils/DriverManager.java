package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	/* Unconditional- Thread.sleep()
	 * Conditional - implicit weight, explicit wait and fluent wait for synchronization 
	 * 1. implicit weight- only used once throughout the entire run. it is the wait for the DOM. Some amount of time will be assinged
	 * it is only used for find elements and find element. 
	 * 2. explicit wait- it has more condition, not just time. It will only wait for that specific element, used for element by element cases.
	 * 	ex. it will check every second.  
	 * 3. fluent wait- it is similar to explicit wait. But it has polling time(intervals). 
	 * 	For example: checking every 5 sec in the duration of the entire wait time. 
	 * Q: if the code has implicit and explicit wait, what will be total wait time? 
	 * ans: don't add the times, its the highest amount given. 
	 */
	
	private static WebDriver driver = null; 

	
	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver openBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/Rifha/Documents/drivers/chromedriver");
			driver= new ChromeDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("FireFox")) {
			//driver = new FirefoxDriver(); 
		}
		
		else {
			System.out.println("Incorrect Driver input");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		return driver;
		
	}
	
	public void quitBrowser() {
		
		driver.quit();
		
	}
	
	public void closeBrowser() {
		
		driver.close();
	}
	
}
