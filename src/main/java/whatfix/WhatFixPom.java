package whatfix;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatFixPom {
	
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	
	@FindBy(xpath="//div[contains(@id,'widget')]//a[contains(@class,'WFEMAX')]")
	WebElement selfHelp;
	
	@FindBy(xpath="//table[@class='WFWID-']//tbody//tr[1]//td[2]//a")
	WebElement embedflows;
	
	@FindBy(xpath="//div[contains(@id,'widget_launcher')]//iframe[contains(@src,'how-to-import')]")
	WebElement my_frame;
	
	@FindBy(xpath="//table//tbody//tr[2]//td[3]//td[3]//td[1]")
	WebElement embed;
	
	@FindBy(xpath="//a[contains(text(),'slideshow')]")
	WebElement slideshow;
	
	@FindBy(xpath="//div[@class='WFEMBV']//tbody//tr[2]//td//table//tbody//tr[1]//td[1]//div[contains(@id,'tooltip-title')]")
	WebElement embedToolTip;
	
	@FindBy(xpath="//div[@class='WFEMBV']//a[@title='close']")
	WebElement closeToolTip;
	
	@FindBy(xpath="//a[text()='close']")
	WebElement close;
	
	@FindBy(xpath="//div[@class='WFEMBV']//a[@title='next']")
	WebElement next;
	
	public WhatFixPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	public void switchToIFrame() throws InterruptedException{
		
		Thread.sleep(5000);
		driver.switchTo().frame(my_frame);
		
		System.out.println("-------------switched to child frame-----------");
	
		
		clickOnEmbedFlows();
		
		System.out.println("-======clicking on embed flows==========");
		
		switchToMainFrame();
		
	}
	
	public void clickOnToolTip(){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions builder=new Actions(this.driver);
		
		builder.moveToElement(embedToolTip).build().perform();
		
		closeToolTip.click();
	}
	
	
	public void clickOnClose(){
		
		
		wait=new WebDriverWait(this.driver, 10);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",close);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(close)).click();
	}
	
	public void clickOnNext(){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions builder=new Actions(this.driver);
		
		builder.moveToElement(next).build().perform();
		
		closeToolTip.click();
	}
	
	//popup
	
	public void clickOnPopup(){
		
		Alert alert= driver.switchTo().alert();
		
		alert.accept();
		
	}
	
	
	public void clickOnEmbedAndSlideshowOnMainFrame(){
		
		wait=new WebDriverWait(this.driver, 20);
		
		//tooltip
		
		
	clickOnToolTip();
		
		
		wait.until(ExpectedConditions.visibilityOf(embed)).click();
		
		wait.until(ExpectedConditions.visibilityOf(slideshow)).click();
		
	}
	
	
	
	public void switchToMainFrame(){
		
		driver.switchTo().defaultContent();
	}

	public void clickOnEmbedFlows(){
		
		wait=new WebDriverWait(this.driver, 20);
	
		wait.until(ExpectedConditions.visibilityOf(embedflows)).click();
		
	}

	public void clickOnSelfHelp(){
		
		wait=new WebDriverWait(this.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(selfHelp)).click();
		try {
			switchToIFrame();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
