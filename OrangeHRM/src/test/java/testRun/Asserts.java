package testRun;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Asserts {

	/* There are 2 types of Asserts. Asserts helps us to determine the result of the test
	 * 1. Hard Assert: if we have multiple asserts, if the first failed, it fails the entire test 
	 * 2.Soft Assert: continues throughout the test run, before failing the test 
	 * 
	 */
	
	@Test 
	public void hardAssert() {
		Assert.assertEquals(1, 2);		//bc the first assert failed the whole test fails. this is called hard assert   
		
		Assert.assertEquals("Rifha", "Rifha");
	}
	
	@Test
	public void hardAssert2() {
		Assert.assertEquals(2, 2);
		
		Assert.assertEquals("Rifha", "Rifha");
		
		Assert.assertEquals(12, 12);

	}
	
	@Test 
	public void softAssert() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(2, 1);
		
		sa.assertEquals("Rifha", "Rifha");
		
		sa.assertEquals(12, "Rif");
		
		//anytime we are using soft assert we have to end it with assert all.
		
		sa.assertAll();
		
	}
}
