package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class seleniumHelper {
	
	WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait; 
	
	//Will return the title of the page
	public String getTitle() {
		return driver.getTitle(); 
	
	}
	
	//Will go to the given web site. 
	public void goToURL(String url) {
		driver.get(url);
	}
	
	//Navigate to the given web site 
	public void navigateToURl(String url) {
		driver.navigate().to(url);
	}
	
	//go to previous page 
	public void navigateBack() {
		driver.navigate().back();
	}
	
	//navigate forward 
	public void naviagteForward() {
		driver.navigate().forward();
	}
	
	//refresh page
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	//hard sleep with given amount in second.  
	public void sleep(int sec) {
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			System.out.println("System broke while sleeping");
			e.printStackTrace();
		}
	}
		
		//will find and return the element 
		public WebElement getElement(String locator) {
			 
		return driver.findElement(By.xpath(locator));
		
			
		}
	
		//explicit wait- will search for element until given condition is set
		public WebElement waitForElement(WebElement element) {
			wait = new WebDriverWait(driver, 20); 
			WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
			highlightElement(element); 
			unhighlightElement(element);
			return webElement;  
	
		}
		
		//Fluent wait- will search for an element for every interval of time until the condition is met
		public WebElement waitForElementFluent(WebElement element) {
			
			 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class); 
			 return wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		//will check if web element exists and return true or false. 
		public boolean ifWebElementExists(WebElement element) {
			boolean isPresent; 
			try {
				wait = new WebDriverWait(driver, 20); 
				isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
				return isPresent; 	
				
			} catch(Exception e) {
				return false; 
			}
		}
		
		//highlight element 
		public void highlightElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].style.border = '3px solid red'", element); 
			sleep(1);
		}
		
		//will un-highlight element 
		public void unhighlightElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].style.border = '0px solid red'", element); 
			sleep(1);
		}
		
		//select from the drop down by index 
		public void selectFromDropDown(WebElement element, int index) {
			Select s = new Select(element);
			s.selectByIndex(index);
			
		}
		
		//select from the drop down by value 
		public void selectFromDropDown(WebElement element, String value) {
			Select s = new Select(element);
			s.selectByValue(value);
			
		}
		
		//to accept alert 
		public void acceptAlert() {
			Alert a = driver.switchTo().alert();
			a.accept();
		}
		
		//to dismiss alert 
		public void dismissAlert() {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		}
		
		//switch to iframe using index 
		public void switchToIFrame(int index) {
			driver.switchTo().frame(index);
		}
		
		//switch to iframe using value
		public void switchToIFrame(String value) {
			driver.switchTo().frame(value);
		}
		
		//switch to parent frame
		public void switchToParentFrame() {
			driver.switchTo().parentFrame();
		}
		
		//get window handle 
		public String getCurrentWindowHandle() {
			return driver.getWindowHandle();
		 
		}
		
		//switch to new window 
		public String switchWindow() {
			String parentWindow = getCurrentWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String windows: allWindows) {
			driver.switchTo().window(windows);
			}
			
			String childWindow = getCurrentWindowHandle();
			return childWindow;  
		}
		
		//Switch to new window 
		public void switchToNextWindow() {
			String parent = getCurrentWindowHandle();
			Set<String> allWindow = driver.getWindowHandles();
			for(String window: allWindow) {
				
				if(!window.equals(parent)) {
				
					driver.switchTo().window(window);
				}
			}
			
		}
		
		//open new tab/window
		public void openNewWindow(WebElement element) {
			element.sendKeys(Keys.chord(Keys.CONTROL, Keys.COMMAND));
		}
		
		//open url in a new window/tab
		public void openUrlNewWindow(String url) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("window.open('" + url + "')");
			//"window.open('www.google.com')"
		}
		
		//data function 
		public String date() {
			
			DateFormat df = new SimpleDateFormat();
			Date date = new Date();
			String finaldate = df.format(date);
			return finaldate;
			
		}
		
		//Take screenshot-
		public void takeScreenShot() {

			String name = "Screen Shot " + date() + ".png" ;
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			try {

				File localScreenshot = new File(new File("Build"), "Screenshots");

				if(!localScreenshot.exists() || !localScreenshot.isDirectory()) {

					localScreenshot.mkdirs();

				}
				File Screenshot = new File(localScreenshot,name);
				Files.copy(sourceFile,Screenshot);
			}
			catch(IOException e) {

				System.out.println("Screenshot capture failed");

			}
		}

		//To raed Excel sheet
		public String getDataFromExcelSheet(String path, String sheetName,int rownum,int cellnum ) {

			String data = null;
			try {

				File file = new File(path);
				FileInputStream fs = new FileInputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook(fs);
				XSSFSheet sheet = wb.getSheet(sheetName);
				data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();



			}
			catch(IOException e) {
				System.out.println("Unable to raed file");
			}

			return data;
		}

		//Action- to handle keyboard and mouse action-
		public Actions action() {

			Actions actions = new Actions(driver);
			return actions;
		}
		
		//read properties/ config problem 
		public String readPropFile(String key) {
			
			Properties prop = new Properties(); 
			InputStream is = null; 
			
			try {
				is = new FileInputStream("src/test/resources/config.properties");
				prop.load(is);
			}
			
			catch(Exception e) {
				System.out.println("Unable to read file");
		
			}
			return prop.getProperty(key); 
		}
	}





