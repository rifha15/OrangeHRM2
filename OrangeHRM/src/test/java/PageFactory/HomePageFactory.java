package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.seleniumHelper;

public class HomePageFactory {

	//page object model: to organize everything based on pages
	
	seleniumHelper sh = new seleniumHelper();
	
	public HomePageFactory(WebDriver driver) {
		
		driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='logInPanelHeading']")
	public WebElement logInPanelTitle;

	@FindBy(xpath="//input[@id='txtUsername']")
	public WebElement userNametextBox;

	@FindBy(xpath="//input[@id='txtPassword']")
	public WebElement passWordTextBox;

	@FindBy(xpath="//input[@id='btnLogin']")
	public WebElement logInButton;

	public void enterUserName(String userName) {
		sh.waitForElement(userNametextBox).sendKeys(userName);
	}

	public void enterPassWord(String password) {
		sh.waitForElement(passWordTextBox).sendKeys(password);	}

	public void clickLogInButton() {
		sh.waitForElement(logInButton).click();
		//logInButton.click();
	}
}// Assert:
	
	