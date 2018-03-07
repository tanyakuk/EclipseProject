package AmazonTests.com.Tests;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import AmazonPom.com.Tests.Amazonpom1;

public class AmazonTests1 {
	
	WebDriver driver;
	Amazonpom1 amazonpom1;
	
	
	
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver","/Users/tanya_kukreti/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");	
		driver.manage().window().maximize();
		
	}
	
	@Test (description="Verify search functionality",priority=0)
	public void verifySearchForPendrive(){
		
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.enterText("Sandisk");
		amazonpom1.clickSearchIcon();
		
	}
	
	@Test (description="Verify filter By user Rating on product Searched",priority=1)
	public void verifyFilterByRatingandPrice(){
		
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.filterByRating();
		
	}
	
	
	@Test (description="Verify filter By Price on product Searched",priority=2)
	public void verifyFilterByPrice(){
		
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.filterByRating();
		
	}

	@Test (priority=3)
	public void verifySelectProductSandisk(){
		
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.selectProduct();
		amazonpom1.switchToLoginTab();
		
	}
	
	@Test (priority=4)
	public void verifyAddToCart(){
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.addToCart();
		
	}
	
	@Test (priority=5)
	public void verifyProceedToCheckout(){
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.proceedToCheckout();
		
	}
	
	@Test (dataProvider="loginData",priority=6)
	public void verifyProceedToLogin(String userEmailorPhone,String userPassword){
		
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.switchToLoginTab();
		amazonpom1.accountLogin(userEmailorPhone, userPassword);
		
	}
	
	@DataProvider(name="loginData")
	public Object[][] setDataInLogin(){
		
		Object[][] data=amazonpom1.getExcelData("TestLoginData.xls","Data");
		return data;
		
	}

	
	@AfterTest
	public void tearDownTest(){
		
		driver.close();
		
	}
}
