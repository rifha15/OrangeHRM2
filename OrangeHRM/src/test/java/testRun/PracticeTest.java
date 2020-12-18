package testRun;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageFactory.DashBoardPageFactory;
import PageFactory.HomePageFactory;
import utils.DriverManager;
import utils.seleniumHelper;

public class PracticeTest {

	// when a class object gets created, all the variables get initialized 

	@Test 
	public void ourFirstTest() {

		DriverManager dm = new DriverManager();
		dm.openBrowser("Chrome");
		seleniumHelper sh = new seleniumHelper();
		HomePageFactory HomePage = new HomePageFactory(DriverManager.getDriver()); 
		DashBoardPageFactory dashBoard= new DashBoardPageFactory(DriverManager.getDriver());


		sh.goToURL("https://opensource-demo.orangehrmlive.com/");
		
		//sh.highlightElement(HomePage.userNametextBox);
		//sh.unhighlightElement(HomePage.userNametextBox);
		
		String window1 = sh.getCurrentWindowHandle();
		System.out.println(window1);
		HomePage.enterUserName("Admin");
		
		//	sh.highlightElement(HomePage.passWordTextBox);
		
		HomePage.enterPassWord("admin123");
		
		//	sh.highlightElement(HomePage.logInButton);
		
		HomePage.clickLogInButton();
		sh.takeScreenShot();
		

		
//		sh.openUrlNewWindow("https://opensource-demo.orangehrmlive.com/");
//		sh.sleep(1);
//		sh.goToURL("https://www.google.com/");
//	//	sh.switchWindow();
//		sh.switchToNextWindow();
//		sh.goToURL("https://www.google.com/");
//		String window2 = sh.getCurrentWindowHandle();
//		System.out.println(window2);
		
		//		WebElement header = sh.getElement("//div[@id = 'logInPanelHeading']");
		//		String title = header.getText();
		//		System.out.println(title);
		//		String title2 = sh.waitForElement(header).getText();
		//		String title3 = sh.waitForElementFluent(header).getText();
		//		System.out.println(header);
		//		System.out.println(title2);
		//		System.out.println(title3);
		//		System.out.println(sh.ifWebElementExists(header));
		//		
		//		sh.navigateToURl("https://www.google.com/");
		//		sh.navigateBack();
		//		sh.naviagteForward();
		//		sh.refreshPage();
		//		System.out.println(sh.getTitle());

		//		SoftAssert sa = new SoftAssert();

		//		dashBoard.clickPin();
		//		dashBoard.selectEmployeeStatus(3);
		//		sh.sleep(4);

		sh.sleep(4);
		dm.quitBrowser();
	}
	
	@Test
	public void test2() {
		
		seleniumHelper sh = new seleniumHelper();
		
		String cell1 = sh.getDataFromExcelSheet("documents/employees.xlsx","Sheet1", 1,0);
		System.out.println(cell1);
	}

}
