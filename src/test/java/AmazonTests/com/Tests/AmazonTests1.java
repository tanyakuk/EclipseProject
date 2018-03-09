package AmazonTests.com.Tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import AmazonPom.com.Tests.Amazonpom1;
import AmazonPom.com.Tests.TestData;
import utilities.Utilities;

public class AmazonTests1 {
	
	WebDriver driver;
	Amazonpom1 amazonpom1;
	TestData testdata;
	
	WebDriverWait wait;
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver","/Users/tanya_kukreti/chromedriver");
		driver=new ChromeDriver();
		driver.get(Utilities.baseURL);	
		driver.manage().window().maximize();
		
	}
	
	
	@Test (description="Verify the user can search for “pen drive”, apply filters:Brand: Sandisk,Price Range: Rs. 300 – Rs. 1000 ",priority=0)
	public void verifySearchPendriveandFilterBYRatingandPrice(){
		
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.enterText(Utilities.PENDRIVE);
		amazonpom1.clickSearchIcon();
		amazonpom1.filterByRating();
		// amazonpom1.filterByPrice(); // 
	}
	
	
	
	
	@Test (description="Verify the user can add pen drive with the lowest price from the first page of search results of above test case",priority=1)
	public void verifySelectProductSandisk(){
		
		amazonpom1=new Amazonpom1(driver);
		
		amazonpom1.selectProduct();
		
		amazonpom1.switchToTab();
		
	}
	
	@Test (description="Verify the user is prompted to Login when the user tries to check out the product added in above test case.",priority=2,dataProvider="loginData")
	public void verifyloginPrompt(String userEmailorPhone,String userPassword){
		
		
		amazonpom1=new Amazonpom1(driver);
		//amazonpom1.switchToTab();
		System.out.println("switching to new tab");
		amazonpom1.addToCart();
		amazonpom1.proceedToCheckout();
		amazonpom1.accountLogin(userEmailorPhone, userPassword);
	}

	//data Provider takes data from Excel file
	@DataProvider(name="loginData")
	public Object[][] setDataInLogin(){
		
		testdata= new TestData();
		Object[][] data=testdata.getExcelData("resources/TestLoginData.xls","Data");
		return data;
		
	}
	
	@AfterTest
	public void tearDownTest(){
		amazonpom1=new Amazonpom1(driver);
		amazonpom1.switchToParentTab();
		driver.close();
		driver.quit();
		
	}
}
