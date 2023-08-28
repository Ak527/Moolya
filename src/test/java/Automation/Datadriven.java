package Automation;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datadriven 
{
	WebDriver wd;
	Robot rt;
	@BeforeTest
	public void bt1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
//		Thread.sleep(3000);

	}
	
	@Test
	public void dd() throws IOException 
	{
		File excl= new File("C:\\Users\\lenovo\\Desktop\\Datadriven.xlsx");
		FileInputStream fis= new FileInputStream(excl);
		XSSFWorkbook book= new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();       //scan till last row in the sheet
		
		for(int i=0;i<=rowcount;i++) 
		{
			String username= sheet.getRow(i).getCell(0).getStringCellValue();
			String password= sheet.getRow(i).getCell(1).getStringCellValue();
		
			wd.findElement(By.xpath("//*[@name='username']")).sendKeys(username);
		    wd.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		    wd.findElement(By.xpath("//*[@type='submit']")).click();
		
		    if(wd.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"))
		    {
		    	wd.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).click();
				wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]")).click();
			}
		    
		    else if(wd.findElement(By.xpath("//*[@class='oxd-alert-content oxd-alert-content--error']")).isDisplayed())
		    {
		    	for(int j=i+1;j<=rowcount;j++) 
		    	{
		    		String username1= sheet.getRow(j).getCell(0).getStringCellValue();
					String password1= sheet.getRow(j).getCell(1).getStringCellValue();
					
					wd.findElement(By.xpath("//*[@name='username']")).sendKeys(username1);
				    wd.findElement(By.xpath("//*[@name='password']")).sendKeys(password1);
				    wd.findElement(By.xpath("//*[@type='submit']")).click();
				
				    if(wd.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"))
				    {
				    	wd.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).click();
						wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]")).click();
						
				    }
				   
		    	}
//		    	wd.close();
		    }
		    
		}
//		 wd.close();
	}
	
}
