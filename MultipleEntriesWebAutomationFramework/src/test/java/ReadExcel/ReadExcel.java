package ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException 
	{
		File file = new File(System.getProperty("user.dir") + "\\TestData\\" + "tasneem" + ".xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
//		XSSFRow row = sheet.getRow(0);
		XSSFRow row = null;
		XSSFCell cell = null;
		String Username = null;
		String Password = null;
		
//		int Cellno = row.getLastCellNum();
//		System.out.println("The Total column no's are : " + Cellno);
		
		for(int i=0; i<sheet.getLastRowNum()+1; i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum(); j++) {
				cell = row.getCell(j);	
				
			if(j==0) {
			
			Username = cell.getStringCellValue();
			}
			else if (j==1)
			{Password = cell.getStringCellValue();}
			
			}
			
			System.out.println("The Username is: " + Username + "  And The password is: " + Password);
			
		}
		
		
		
		
//
//		String username = cell.getStringCellValue();
//		System.out.println("UserName is " + username);

	}
}
