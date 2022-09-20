package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.HomePage;

public class Loginmult extends BaseDriver {

	@Test
	public void Login() throws IOException, InterruptedException

	{
		File file = new File(System.getProperty("user.dir") + "\\TestData\\" + "bks" + ".xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
//			XSSFRow row = sheet.getRow(0);
		XSSFRow row = null;
		XSSFCell cell = null;
		String Username = null;
		String Password = null;
		boolean CheckTrue = true;

		HomePage homePage = new HomePage();

//			int Cellno = row.getLastCellNum();
//			System.out.println("The Total column no's are : " + Cellno);

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			String Result = null;
			for (int j = 0; j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (j == 0) {

					Username = cell.getStringCellValue();
				} else if (j == 1) {
					Password = cell.getStringCellValue();
				}

			}

			homePage.clickOnSignIn();
			homePage.sendEmailLog(Username);
			homePage.SendPass(Password);
			homePage.SubmitClick();
			Thread.sleep(5000);

			try {
				boolean Signout = homePage.CheckLogout();
				Assert.assertEquals(Signout, CheckTrue);
				System.out.println(Username + " and Password: " + Password + " is Passed");
				Result = "PASS";
				homePage.LogOut();
				cell = row.createCell(2);
				cell.setCellValue(Result);

			} catch (Exception e) {
//					boolean Msg = homePage.Errordisplay();
//					boolean CheckFalse = true;
//					Assert.assertEquals(Msg, CheckFalse);
				System.out.println(Username + " and Password: " + Password + " is Failed");
				Result = "FAIL";
				cell = row.createCell(2);
				cell.setCellValue(Result);
				homePage.clickOnSignIn();
			}

		}
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		fos.close();

	}

	@BeforeClass
	public void startUrl() {
		PageDriver.getCurrentDriver().get(baseURL);
		PageDriver.getCurrentDriver().manage().window().maximize();
	}

	//
//			String username = cell.getStringCellValue();
//			System.out.println("UserName is " + username);

}
