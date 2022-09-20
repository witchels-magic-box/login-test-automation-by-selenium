package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.HomePage;

public class AccountCreate extends BaseDriver{
	boolean CheckTrue = true;
	
	@Test
	public void createAnAccount() throws InterruptedException  {
		HomePage homePage = new HomePage();
		SoftAssert soft = new SoftAssert();
		homePage.clickOnSignIn();
		homePage.sendEmailLog("heteyrr@gmsil.vom");
		homePage.SendPass("sdssd");
		homePage.SubmitClick();
		Thread.sleep(5000);
		try {
		
			boolean Signout = homePage.CheckLogout();
			Assert.assertEquals(Signout,CheckTrue);
			System.out.println("Passed");

		}
		catch(Exception e) {
//			boolean Msg = homePage.Errordisplay();
//			boolean CheckFalse = true;
//			Assert.assertEquals(Msg, CheckFalse);
			System.out.println("Error");
		}
		
	}
	
	@BeforeClass
	public void startUrl() {
		PageDriver.getCurrentDriver().get(baseURL);
		PageDriver.getCurrentDriver().manage().window().maximize();
	}
	
}
