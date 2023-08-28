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

public class Datadriven_Practise 
{
	WebDriver wd;
	Robot rt;
	@BeforeTest
	public void bt1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://the-internet.herokuapp.com/login");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
//		Thread.sleep(3000);

	}
	
	@Test
	public void dd() throws IOException, InterruptedException 
	{
		File excel= new File("C:\\Users\\lenovo\\Desktop\\Datadriven.xlsx");
		FileInputStream fis= new FileInputStream(excel);
		XSSFWorkbook book= new XSSFWorkbook(fis);
		XSSFSheet sheet= book.getSheet("Sheet1");
		
		int rowcount= sheet.getLastRowNum();
		for(int i=0; i<=rowcount; i++) 
		{
			String username= sheet.getRow(i).getCell(0).getStringCellValue();
			String password= sheet.getRow(i).getCell(1).getStringCellValue();
			wd.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
			wd.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
			wd.findElement(By.xpath("//*[@class='radius']")).click();
			if(wd.getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/secure"))
			{
				Thread.sleep(3000);
				wd.findElement(By.linkText("Logout")).click();
//				wd.findElement(By.xpath("//*[@class='icon-2x icon-signout']")).click();
			}
			else if(wd.findElement(By.xpath("//*[@class='flash error']")).isDisplayed())
			{
				for(int j=i+1; j<=rowcount; j++) 
				{
					String username1= sheet.getRow(i).getCell(0).getStringCellValue();
					String password1= sheet.getRow(i).getCell(1).getStringCellValue();
					wd.findElement(By.xpath("//*[@id='username']")).sendKeys(username1);
					wd.findElement(By.xpath("//*[@id='password']")).sendKeys(password1);
					wd.findElement(By.xpath("//*[@class='radius']")).click();
					if(wd.getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/secure"))
					{
						Thread.sleep(3000);
						wd.findElement(By.linkText("Logout")).click();
					}
				
				}
				wd.close();
			}
//			wd.close();
			
		}
		
		
		wd.close();
	
	}
}
