package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paralleltesting 
{
	WebDriver wd;
	@Parameters("mybrowser")
	@BeforeTest()
	public void PTest(String mybrowser) 
	{
		
		if(mybrowser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			wd= new ChromeDriver();
//			wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//			
		}
		else if(mybrowser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			wd= new FirefoxDriver();
//			 d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
		}
		
		
	}
	@Test()
	public void test1()
	{
//		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
	    wd.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
	    wd.findElement(By.xpath("//*[@type='submit']")).click();
	
	}
	

}
