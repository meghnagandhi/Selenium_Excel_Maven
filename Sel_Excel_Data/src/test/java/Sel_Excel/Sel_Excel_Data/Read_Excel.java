package Sel_Excel.Sel_Excel_Data;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Read_Excel {
	public static void main(String[] args) throws Exception {
		File src= new File("/Users/Meghana/Downloads/Data1.xlsx");
		//using Java API specify workbook path
				FileInputStream fis = new FileInputStream(src);
		//to load entire workbook use XSSFWorkbook class
				XSSFWorkbook wb1 = new XSSFWorkbook(fis);  //XSS used for .xlsx file
			//	HSSFWorkbook wb1 = new HSSFWorkbook(fis); //HSS used for .xls file
				
		//to get the access of sheet 1 use XSSFSheet class
				XSSFSheet sheet1 = wb1.getSheetAt(0);
				
		/*//to read 1st row and col from sheet 1
				String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
				
				System.out.println("Data from Excel is " +data0);  */
		
			  
				// to get the count of no. of rows present in sheet
			//	int rowcount = sheet1.getLastRowNum();
			//	System.out.println("Total no. of Rows" +rowcount);
						
				String FirstName=sheet1.getRow(1).getCell(0).getStringCellValue();
				String LastName=sheet1.getRow(1).getCell(1).getStringCellValue();
				
				System.out.println(FirstName);
				System.out.println(LastName);
				
				System.setProperty("webdriver.chrome.driver","/Users/Meghana/Downloads/chromedriver");
				WebDriver driver=new ChromeDriver();
				driver.get("http://demo.opencart.com/index.php?route=account/register");
				
				Thread.sleep(3000);

				driver.findElement(By.id("input-firstname")).sendKeys(FirstName);
				
				Thread.sleep(5000);
				
				driver.findElement(By.id("input-lastname")).sendKeys(LastName);
				
				Thread.sleep(5000);
				driver.close();
				
				
		/*		//to read all rows from a col from sheet1
				for(int i=0;i<rowcount;i++)
				{
					String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
					System.out.println("Data from Excel is " +data0);
				}  */ 
						
				//wb1.close();  
				

	}


}
