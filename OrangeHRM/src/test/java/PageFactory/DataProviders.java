package PageFactory;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "ages")
	public Object[][] data() {
		
		Object[][] num = new Object[][]{
			{22, "Rifha"}, 
			{31, "Arif"}, 
			{50, "MD"}
		}; 
		return num; 
	}
}
