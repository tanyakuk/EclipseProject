

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelUtils;
import utilities.Utilities;


public class LoginTests {
	
	
	WebDriver driver;
	
	SnapTrude snaptrude;
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver","/Users/tanya_kukreti/Downloads/chromedriver");
		driver=new ChromeDriver();
		driver.get(Utilities.baseURL);	
		driver.manage().window().maximize();
		
	}
	

	
	@Test(dataProvider="getData",description="Verify user is able to login into Snaptrude",priority=0)
	public void loginToTheApplication(String userName,String password){
		
		snaptrude=new SnapTrude(driver);
		
		System.out.println("inside test 1");
		
		snaptrude.clickOnLogin();
		
		snaptrude.handleLogin(userName, password);
		
	}
	
	@Test(description="Verify user is able to perform Email subscription",priority=1)
	public void emailSubscription(){
		
		snaptrude=new SnapTrude(driver);
		snaptrude.performEmailSubscription();
		
		}
	

	@DataProvider(name="getData")
	public Object[][] getTestData() throws IOException{
		
			Object[][] testObjArray = ExcelUtils.getExcelData("resources/TestLoginData.xls","Data");
			return testObjArray;
	}
		
	@AfterTest
	public void tearDown(){
		driver.close();
	}

}
