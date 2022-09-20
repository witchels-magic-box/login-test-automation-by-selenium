package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class HomePage extends CommonMethods{
	
	public HomePage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	//@FindBy  = driver.findelement(By.)
	@FindAll({
		@FindBy(xpath = "//a[contains(text(),'Sign in')]"),
		@FindBy(xpath = "//a[@title= 'Log in to your customer account']")
	})
	WebElement signIn;
	
	@FindAll({
		@FindBy(id = "email_create"),
		@FindBy(xpath = "//input[@name='email_create']")
	})
	WebElement emailAddress;
	
	@FindAll({
		@FindBy(id = "SubmitCreate"),
		@FindBy(xpath = "//button[@id='SubmitCreate']']")
	})
	WebElement accountButton;
	
	@FindBy(xpath = "//a[@class='logout']")
	public WebElement logouting;
	
	@FindAll({
		
		@FindBy(name = "email"),
		@FindBy(xpath = "//input[@id='email']"),
	})
	public WebElement Logemail;
	
	@FindBy(id = "passwd")
	public WebElement pword;
	
	@FindBy(id= "SubmitLogin")
	public WebElement Submit;
	
	@FindBy(xpath= "//p[contains(text(),'There is 1 error')]")
	public WebElement Errormsg;
	
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public boolean Errordisplay() {
		boolean disp = Errormsg.isDisplayed();
		return disp;
	}
	
	public void sendEmail() {
		String email = emailGenerate();
		sendText(emailAddress, email);
		timeOut(2000);
		System.out.println(email);
	}
	public void sendEmailLog(String Username) {
		Logemail.clear();
		sendText(Logemail, Username);
		timeOut(2000);
	}
	
	public void clickOnAccountButton() {
		accountButton.click();
		timeOut(10000);
	}
	
	public void LogOut() {
		logouting.click();
	}
	
	public void SendPass(String Password) {
		pword.click();
		pword.sendKeys(Password);
	
	}
	public void SubmitClick() {
		Submit.click();
	
	}
	public boolean CheckLogout() {
	boolean Logoutnow = logouting.isDisplayed();
	return Logoutnow;
	}

	}
	

