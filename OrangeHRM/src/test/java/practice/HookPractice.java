package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Hooks/Annotations- are used to run a piece of code over and over again without having to write it.
//There are few different Hooks, and each have their own functionality.
//1->  @Before method - it will run before each test method.
//2->  @Before class - it will run before that class.
//3->  @Before group - it will run before each test group.
//4->  @Before test - it will run before entire test run.
//5->  @Before suite - it will run before each test suite.
//All of them has after annotation also.


public class HookPractice {

	@BeforeGroups
	public void beforeSuit() {
		System.out.println("This is before Group");
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("This is after Group");

	}
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("This is before Group");
	}
	@AfterGroups
	public void afterGroup() {
		System.out.println("This is after Group");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before all test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This is after all test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before class");
	}
		
	@AfterClass 
	public void afterClass() {
		System.out.println("This is After class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method");
	}
	@AfterMethod 
	public void afterMethod() {
		System.out.println("This is after method");
	}
	@Test
	public void test1() {
		System.out.println("This is test 1");
	}
	@Test
	public void tes2t() {
		System.out.println("This is test 2");
	}
	@Test
	public void test3() {
		System.out.println("This is test 3");
	}
}
