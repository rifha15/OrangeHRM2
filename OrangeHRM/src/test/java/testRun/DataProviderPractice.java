package testRun;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.DataProviders;
import utils.seleniumHelper;

public class DataProviderPractice {

	//@Test(dataProvider = "ages", dataProviderClass = DataProviders.class) 
	@Test 
	public void completeSentence() {
		
		seleniumHelper sh = new seleniumHelper(); 
		
		System.out.println("My name is " + sh.readPropFile("name"));
		System.out.println("I am " + sh.readPropFile("age") +  " yrs old");
	}
	
	
}
