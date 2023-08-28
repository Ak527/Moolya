package Automation;

import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio
{
	WebDriver wd;
	Robot rt;
	Actions act;
	@BeforeTest
	public void bt1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
//		ChromeOptions opt= new ChromeOptions();
//		opt.addArguments("--diasble-notifications");
		wd = new ChromeDriver();
		wd.get("https://www.ajio.com/");
		wd.manage().window().maximize();
//		wd.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Thread.sleep(3000);

	}
	@Test(priority = 0)  
	public void Homepage() throws InterruptedException 
	{

		act= new Actions(wd);
		WebElement we= wd.findElement(By.xpath("(//*[@class=' alignTag'])[1]"));//mouse hover on Men
		act.moveToElement(we).build().perform();
		
		WebElement we1= wd.findElement(By.xpath("(//*[@class='catg inactive-text'])[1]"));//mouse hover on CATEGORIES
		act.moveToElement(we1).build().perform();
		
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='third-level'])[3]/div/a")).click();//mouse hover on Accessories

	
	    
	}
	@Test(priority = 1)
	public void Accessories() throws InterruptedException 
	{
		
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='rilrtl-list '])[2]/li[2]/div/div")).click(); // Gender filter men checkbox
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='rilrtl-list '])[3]/li/div/div")).click();// men  watches checkbox
	    wd.findElement(By.xpath("(//*[@class='imgHolder'])[2]")).click();  // select any item
	}
	@Test(priority = 2)
	public void SelectedItem() throws InterruptedException 
	{
		
//		WebDriverWait wait= new WebDriverWait(wd, 10);
//		WebElement we= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='col-4']/div/div[8]/div[1]/div[1]")));
//		we.click();
//		threwd.findElement(By.xpath("//*[@class='col-4']/div/div[8]/div[1]/div[1]")).click(); // Add to Bag
		Thread.sleep(3000);
		JavascriptExecutor js=  (JavascriptExecutor)wd;
		WebElement we2= (WebElement) js.executeScript("document.getElementsByClassName('btn-gold')[0]");
		we2.click();
	}

}
//Thread.sleep(10000);
////Alert alt = wd.switchTo().alert();
//////alt.accept();
////System.out.println(alt.getText());
//wd.findElement(By.xpath(null))