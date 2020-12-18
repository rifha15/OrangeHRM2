package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HookPractice2 extends HookPractice{

	@Test (groups = "Even")
	public void test4() {
		System.out.println("This is test 4");
	}

	@Test (groups = "Odd")
	public void test5() {
		System.out.println("This is test 5");
	}

	@Test (groups = "Even")
	public void test6() {
		System.out.println("This is test 6");
	}
	@Test (groups = "Odd")
	public void test7() {
		System.out.println("This is test 7");
	}
	@Test (groups = "Even")
	public void test8() {
		System.out.println("This is test 8");
	}
	@Test (groups = "Odd")
	public void test9() {
		System.out.println("This is test 9");
	}
	@Test (groups = "Even")
	public void test10() {
		System.out.println("This is test 10");
	}
	@Test (groups = "Odd")
	public void test11() {
		System.out.println("This is test 11");
	}
	@Test (groups = "Even")
	public void test12() {
		System.out.println("This is test 12");
	}
}
