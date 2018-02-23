package GoogleTests.com.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='gs_lc0']//input[contains(@aria-label,'Search')]")
	WebElement searchText;
	
	@FindBy(xpath="//div[@class='jsb']//input[contains(@value,'Search')]")
	WebElement searchButton;
	
	public GoogleSearch(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterText(String text){
		
		searchText.sendKeys(text);
		
	}
	
	public void clickSearchButton(){
		
		searchButton.click();
	}
		
}
