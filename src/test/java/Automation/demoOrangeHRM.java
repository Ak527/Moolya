package Automation;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoOrangeHRM 
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
		

	}
	@Test(priority = 0)  
	public void login() throws InterruptedException 
	{
		
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
	    wd.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
	    wd.findElement(By.xpath("//*[@type='submit']")).click();
	}
	@Test(priority =1)
	public void Admin() throws InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")).click();  //admin 
		wd.findElement(By.xpath("(//*[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[3]")).click();
		List<WebElement> we = wd.findElements(By.xpath("//*[@class='oxd-table-row oxd-table-row--with-border']"));
//		 we.get
		System.out.println(we.size());
		WebElement we1=  wd.findElements(By.xpath("//*[@class='oxd-table-row oxd-table-row--with-border']")).get(3);
		System.out.println(we1.getText());
	}

}
