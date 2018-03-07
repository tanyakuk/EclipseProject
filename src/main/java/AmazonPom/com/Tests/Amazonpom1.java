package AmazonPom.com.Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Amazonpom1 {
	
	
WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'search')]//input[contains(@id,'search')]")
	WebElement searchInputBox;
	
	@FindBy(xpath="//div[contains(@class,'nav-fill')]//div[contains(@class,'nav-right')]//input[contains(@class,'nav-input')]")
	WebElement searchIcon;
	
	@FindBy(xpath="//div[contains(@id,'leftNav')]//ul[contains(@class,'unordered')][9]//li[1]//a//i[contains(@class,'a-star-medium')]")
	WebElement userRating;
	
	@FindBy(xpath="//div[contains(@id,'leftNav')]//ul[contains(@class,'unordered')][12]//li[1]//a")
	WebElement sortByPrice;
	
	@FindBy(xpath="//div[@id='resultsCol']//ul[contains(@id,'results')]//li[contains(@id,'result')][1]//a[contains(@title,'SanDisk Cruzer')]")
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
	
	@FindBy(xpath="//input[contains(@id,'signInSubmit')]")
	WebElement login;

	
	public Amazonpom1(WebDriver driver){

		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	//Reading data from excel file using jExcel
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream("TestLoginData.xls");
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Data");

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	public void switchToLoginTab(){
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		
	}
	
	public void enterText(String text){
		
		searchInputBox.sendKeys(text);
		
	}
	
	public void clickSearchIcon(){
		
		searchIcon.click();
	}
	
	public void filterByRating(){
		
		JavascriptExecutor js=  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		userRating.click();
	
	}
	
	public void filterByPrice(){
		
		JavascriptExecutor js=  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		sortByPrice.click();
	}
	
	public void selectProduct(){
		selectProduct.click();
	}
	
	public void addToCart(){
		
		addToCart.submit();
	}
		
	public void proceedToCheckout(){
		
		proceedToCheckout.submit();
	}
	
	public void accountLogin(String usrEmail,String passwrd){
		email.sendKeys(usrEmail);
		password.sendKeys(passwrd);
		login.submit();
	}

}
