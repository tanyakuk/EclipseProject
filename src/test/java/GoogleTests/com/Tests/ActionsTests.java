package GoogleTests.com.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsTests {
	
	WebDriver driver;
	GoogleSearch src;
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver","/Users/tanya_kukreti/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com");	
	}
	
	@Test (priority=1)
	public void firstTest(){
		
		src=new GoogleSearch(driver);
		
		src.enterText("Times");
		
		src.clickSearchButton();
		
	}
	
	@Test (priority=0)
	public void secondTest(){
		
		String actualTitle=driver.getTitle();
		
		String expectedTitle="Google";
		
		Assert.assertTrue(actualTitle.contains(expectedTitle),"Strings are not equal");
		
	}
	
	@AfterTest
	public void tearDownTest(){
		
		driver.close();
		
	}

}
