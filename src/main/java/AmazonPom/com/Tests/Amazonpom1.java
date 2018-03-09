package AmazonPom.com.Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Amazonpom1 {
	
	
WebDriver driver ;

WebDriverWait wait;
	
	@FindBy(xpath="//div[contains(@class,'search')]//input[contains(@id,'search')]")
	WebElement searchInputBox;
	
	@FindBy(xpath="//div[contains(@class,'nav-fill')]//div[contains(@class,'nav-right')]//input[contains(@class,'nav-input')]")
	WebElement searchIcon;
	
	@FindBy(xpath="//div[contains(@id,'leftNav')]//ul[contains(@class,'unordered')][9]//li[1]//a//i[contains(@class,'a-star-medium')]")
	WebElement userRating;
	
	@FindBy(xpath="//div[contains(@id,'leftNav')]//ul[contains(@class,'unordered')][12]//li[1]//a")
	WebElement sortByPrice;
	
	@FindBy(xpath="//div[@id='resultsCol']//ul[contains(@id,'results')]//li[contains(@id,'result')][1]//div[contains(@class,'col-left')]//a//img")
	WebElement selectProduct;
	
	@FindBy(xpath="//div[contains(@id,'right')]//div[@data-feature-name='buybox']//div[contains(@id,'buybox')]//form[@id='addToCart']//"
			+ "div//div[contains(@class,'a-box')]//div//div//span[contains(@id,'add-to-cart')]//input[contains(@name,'add')]")
	WebElement addToCart;
	
	@FindBy(xpath="//div[contains(@id,'row-with-divider')]//div[4]//a[contains(text(),'Proceed')]")
	WebElement proceedToCheckout;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@id,'continue')]")
	WebElement proceed;
	
	@FindBy(xpath="//input[contains(@id,'signInSubmit')]")
	WebElement login;

	
	public Amazonpom1(WebDriver driver){

		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void switchToTab(){
		
		String windowHandle = driver.getWindowHandle();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(1)); 
	}
	
	public void switchToParentTab(){
		
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
        driver.switchTo().defaultContent();
	}

	
	
	
	public void enterText(String text){
		
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(searchInputBox)).sendKeys(text);;
		
	}
	
	public void clickSearchIcon(){
		
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(searchIcon)).click();
	}
	
	public void filterByRating(){
		
		JavascriptExecutor js=  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(userRating)).click();
	
	}
	
	public void filterByPrice(){
		
		JavascriptExecutor js=  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(sortByPrice)).click();
	}
	
	public void selectProduct(){
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(selectProduct)).click();
	}
	
	public void addToCart(){
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(addToCart)).submit();
	}
		
	public void proceedToCheckout(){
		
		System.out.println("proceed to checkout");
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout)).click();
	}
	
	public void accountLogin(String usrEmail,String passwrd){
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(usrEmail);
		
		wait.until(ExpectedConditions.visibilityOf(proceed)).click();
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(passwrd);
		wait.until(ExpectedConditions.visibilityOf(login)).click();
		
	}

}
