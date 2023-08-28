package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagLabs 
{
	WebDriver wd;
	Robot rt;
//	@DataProvider
//	public Object[][] dp()
//			{
//				return new  Object[][] 
//						{
//							new Object[] {"standard_user","secret_sauce"}
//						};
//		
//			}
	@BeforeTest
	public void openSite() 
	{
		WebDriverManager.chromedriver().setup();
		wd= new ChromeDriver();
		wd.get("https://www.saucedemo.com/");
		wd.manage().window().maximize();
		
	}
	@Test(priority = 0) //(dataProvider= "dp")
	public void Login()  //(String n, String s) 
	{
		wd.findElement(By.xpath("(//*[@class='input_error form_input'])[1]")).sendKeys("standard_user");  // username
		wd.findElement(By.xpath("(//*[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");  //Password
		wd.findElement(By.xpath("//*[@id='login-button']")).click();  // login button
	} 
	@Test(priority = 1)
	public void Homepage() throws InterruptedException, AWTException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='product_sort_container']")).click();
		rt= new Robot();
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,250)");
		wd.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
		wd.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
	}
	@Test(priority = 2)
	public void AddToCart() throws InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='shopping_cart_link']")).click(); //cart
		wd.findElement(By.xpath("//*[@id='remove-sauce-labs-fleece-jacket']")).click();  ///removed from Cart
		wd.findElement(By.xpath("//*[@id='checkout']")).click();   //checkout
		
	}
	@Test(priority = 3)
	public void CheckOutInfo() throws InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='first-name']")).sendKeys("asd"); //first-name
		wd.findElement(By.xpath("//*[@id='last-name']")).sendKeys("fgh");  ///Last name
		wd.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("123456");   //postal code
		wd.findElement(By.xpath("//*[@id='continue']")).click();   //Continue
		
	}
	@Test(priority = 4)
	public void CheckOutOverView() throws InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='finish']")).click();   //finish
		
	}
	@Test(priority = 5)
	public void CheckOutComplete() throws InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@id='back-to-products']")).click();   //Back to Home
		
	}
	@Test(priority = 6)
	public void BacktoHome() throws AWTException, InterruptedException 
	{
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='bm-burger-button']")).click();   //homepage: Menu
		wd.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();   //homepage: Menu
		
	}

}
