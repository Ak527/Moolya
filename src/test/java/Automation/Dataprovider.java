package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider 
{
	WebDriver wd;
	Robot rt;
	@DataProvider
	public Object[][] dp()
	{
		return new Object[][] 
				{
			new Object[] {"Ashok", "admin123"},
			new Object[] {"Admin", "admin123"},
				}; 
	}
	 
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
	@Test(dataProvider = "dp")  
	public void login( String n, String s)
	{
		
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys(n);
	    wd.findElement(By.xpath("//*[@name='password']")).sendKeys(s);
	    wd.findElement(By.xpath("//*[@type='submit']")).click();
	}
	
	@Test
	public void logout() throws InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).click();
		wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]")).click();
	}
}
