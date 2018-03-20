
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;
import utilities.Utilities;


public class SnapTrude {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//h2/strong[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@id='login_username']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='login_password']")
	WebElement password;

	@FindBy(xpath="//button[@id='loginForm']")
	WebElement signIn;
	
	@FindBy(xpath="//div[3]/nav/a[contains(@href,'logout')]")
	WebElement logout;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailSubscribe;
	
	@FindBy(xpath="//b[contains(text(),'Thank you very much for Subscribing')]")
	WebElement subscribeText;
	
	//get An invite
	@FindBy(xpath="//button[@id='login']")
	WebElement subscribe;
	
	
	
	public SnapTrude(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickOnLogin(){
		
		wait= new WebDriverWait(this.driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
		
		System.out.println("logged In");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	//Data Providers
	
	
	
	public void handleLogin(String usrname, String pass){
		
		
		email.sendKeys(usrname);
		password.sendKeys(pass);
		
		signIn.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logout.click();
	}
	
	public void performEmailSubscription(){
		
		emailSubscribe.sendKeys("tktanyakukreti@gmail.com");
		
		subscribe.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println(subscribeText.getText());
		
		
	}
	
	}

