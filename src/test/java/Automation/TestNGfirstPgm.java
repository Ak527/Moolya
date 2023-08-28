package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGfirstPgm {

	WebDriver wd;
	Robot rt;
	@BeforeTest
	public void bt1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wd.manage().window().maximize();
//		wd.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Thread.sleep(3000);

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
		
	}
	@Test (enabled=false)//(priority =2)
	public void UserManagement() throws InterruptedException, AWTException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@placeholder='Type for hints...']")).sendKeys("John Smith");   // employee name
		Thread.sleep(3000);
		rt= new Robot();
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		wd.findElement(By.xpath("(//*[@class='oxd-select-text-input'])[2]")).click();  //status
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		wd.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();//  search
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='oxd-icon-button oxd-table-cell-action-space'])[1]")).click();
		wd.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		wd.findElement(By.xpath("(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[8]")).click(); //dashboard
		
		
		}
	@Test(priority =2)//(enabled=false)//(priority =2)
	public void Job() throws AWTException, InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='oxd-icon bi-chevron-down'])[2]")).click();
		wd.findElement(By.xpath("(//*[@class='oxd-topbar-body-nav-tab-link'])[1]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='oxd-button oxd-button--medium oxd-button--secondary'])[1]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Tester1");
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='oxd-file-input-div']")).sendKeys("C:\\Users\\lenovo\\Downloads\\sampleFile.jpeg");
		wd.findElement(By.xpath("//*[@type='submit']")).click();
		
	}
	
	
	@Test(enabled=false)
	public void logout() throws InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='oxd-userdropdown-img']")).click();
		wd.findElement(By.xpath("(//*[@class='oxd-userdropdown-link'])[4]")).click();
	}
	@AfterTest(enabled=false)
	public void at1() 
	{
		wd.close();
	}
}
