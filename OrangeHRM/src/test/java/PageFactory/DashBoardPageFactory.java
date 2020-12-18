package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.seleniumHelper;

public class DashBoardPageFactory {

	seleniumHelper sh = new seleniumHelper();
	public DashBoardPageFactory(WebDriver driver) {
		
		driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//h1[contains(text(), 'Dashboard')]" )
	public WebElement dashBoardTitle; 
	
	@FindBy(xpath ="//b[contains(text(),'PIM')]" )
	public WebElement PimTitle; 
	
	@FindBy(xpath ="//select[@id='empsearch_employee_status']" )
	public WebElement employmentStatusDropDown; 
	
	public String getTextDashBoard() {
		return sh.waitForElement(dashBoardTitle).getText();
		
		
	}
	public void clickPinNumber() {
		sh.waitForElement(PimTitle).click();
	}
	
	public void selectEmployeeStatus(int index) {
		sh.selectFromDropDown(employmentStatusDropDown, index);
	}
}
