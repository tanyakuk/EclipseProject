package utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("I m before test");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("I m after test");
	}
	
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("I m before suite");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("I m after suite");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("I m before method");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("I m after method");
	}
	
	@BeforeClass
	public void beforeclass(){
		System.out.println("I m before class");
	}
	
	@AfterClass
	public void afterclass(){
		System.out.println("I m after class");
	}

	@Test
	public void Test1(){
		System.out.println("I m test 1");
	}
	
	@Test
	public void Test2(){
		System.out.println("I m test 2");
	}
	
	@Test
	public void Test3(){
		System.out.println("I m test 3");
	}
	
	
	
}
