package Automation;

import java.awt.AWTException;
import java.awt.Menu;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RahulShetty 
{
	WebDriver wd;
	Robot rt;
	String url ="https://rahulshettyacademy.com/AutomationPractice/";
	
			
	@BeforeTest
	public void rsp() 
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
	}
	@Test
	public void Radio() 
	{
		wd.get("https://rahulshettyacademy.com/AutomationPractice/");
		wd.findElement(By.xpath("(//input[@class='radioButton'])[1]")).click();
	}
	@Test
	public void country() throws AWTException
	{
		wd.get("https://rahulshettyacademy.com/AutomationPractice/");
		wd.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys("ind");////*[@class='inputs ui-autocomplete-input']
		rt= new Robot();
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		rt.keyPress(MenuKeyEvent.VK_ENTER);

		
	}
	
	@Test
	public void DropDown() throws AWTException 
	{
		wd.get("https://rahulshettyacademy.com/AutomationPractice/");
		wd.findElement(By.xpath("//*[@id='dropdown-class-example']")).click();
		rt= new Robot();
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
	}
	@Test
	public void DropDown1() throws AWTException 
	{
		wd.get("https://rahulshettyacademy.com/AutomationPractice/");
		wd.findElement(By.xpath("//*[@id='dropdown-class-example']")).click();
		wd.findElement(By.xpath("//option[@value='option1']")).click();
		
//		rt= new Robot();
//		rt.keyPress(MenuKeyEvent.VK_DOWN);
//		rt.keyPress(MenuKeyEvent.VK_DOWN);
//		rt.keyPress(MenuKeyEvent.VK_DOWN);
//		rt.keyPress(MenuKeyEvent.VK_ENTER);
	}
	
	@Test
	public void Tab() throws AWTException, InterruptedException
	{
		wd.get("https://rahulshettyacademy.com/AutomationPractice/");
		wd.manage().window().maximize();
		wd.findElement(By.xpath("//*[@id='opentab']")).click();
		 rt = new Robot();
		 rt.keyPress(MenuKeyEvent.VK_CONTROL);
		 rt.keyPress(MenuKeyEvent.VK_TAB);
		 
		 Thread.sleep(1000);
		 rt.keyRelease(MenuKeyEvent.VK_TAB);
		 rt.keyPress(MenuKeyEvent.VK_TAB);
		 rt.keyRelease(MenuKeyEvent.VK_CONTROL);

	}
	
	@Test
	public void gmail() throws AWTException, InterruptedException
	{
	
		wd.get("https://www.google.co.in/");
//		WebElement we= wd.findElement(By.linkText("Gmail"));
//		WebElement we= wd.findElement(By.partialLinkText("G"));//*[@class='gb_y']
		WebElement we= wd.findElement(By.xpath("//*[@class='gb_y']"));
		Actions act= new Actions(wd);
		act.contextClick(we).build().perform();
		rt= new Robot();
		rt.keyPress(MenuKeyEvent.VK_DOWN);// New Tab
		rt.keyPress(MenuKeyEvent.VK_DOWN); // New Window
//		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
	} 
	
}


