package whatfixScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.Utilities;
import whatfix.WhatFixPom;

public class WhatfixTest {
	
	
	WebDriver driver;
	
	WhatFixPom pom;
	
	
	
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver","/Users/tanya_kukreti/chromedriver");
		driver=new ChromeDriver();
		driver.get(Utilities.baseURL+"#!flows/how-to-import-google-analytics-solution-of-whatfix/8174f470-9df9-11e3-8178-386077c653fe/");	
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void verifyFlowOnSelfHelp(){
		
		pom=new WhatFixPom(driver);
		
		pom.clickOnSelfHelp();
		
		pom.clickOnEmbedAndSlideshowOnMainFrame();
		
		pom.clickOnClose();
		
		pom.clickOnNext();
		
		pom.clickOnPopup();
	
	}
	
	@AfterTest
	public void tearDown(){
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.quit();
	}

}
