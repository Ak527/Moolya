package Automation;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoqa 
{
//	private static final boolean False = false;
	WebDriver wd;
	@BeforeTest
	public void bt1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
//		wd.get("https://demoqa.com/text-box");
		Thread.sleep(2000);
//		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		wd.manage().window().maximize();
		
	}
	
	@Test 
	public void Textbox()
	{
		wd.get("https://demoqa.com/text-box");
		wd.findElement(By.xpath("//*[@id='userName']")).sendKeys("Ashok Katuri");
		wd.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("Ashok.Katuri@moolyaed.com");
		wd.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys("Hno:22-18-2/1, chirala-523155");
		wd.findElement(By.xpath("//*[@id='permanentAddress']")).sendKeys("Hno:22-18-2/1, chirala-523155");
		wd.manage().window().maximize();
//		wd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		wd.findElement(By.xpath("//*[@id='submit']")).click();		
	}
	@Test
	public void Checkbox()
	{
		wd.get("https://demoqa.com/checkbox");
		wd.findElement(By.xpath("//*[@class='rct-icon rct-icon-expand-close']")).click();
		wd.findElement(By.xpath("(//*[@class='rct-icon rct-icon-expand-close'])[1]")).click();
		wd.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])[3]")).click();
				
	}
	@Test
	public void RadioButton() throws InterruptedException
	{
		wd.get("https://demoqa.com/radio-button");
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='custom-control-label'])[2]")).click();
		
	}
	@Test
	public void WebTables() throws InterruptedException
	{
		wd.get("https://demoqa.com/webtables");
		wd.findElement(By.xpath("//*[@id='addNewRecordButton']")).click();   // Add Button
		wd.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Suhan");  // First name
		wd.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Katuri");  // Last name
		wd.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("Suhankaturi@gmail.com");  // Email name
		wd.findElement(By.xpath("//*[@id='age']")).sendKeys("3");  // Age 
		wd.findElement(By.xpath("//*[@id='salary']")).sendKeys("100000");  // Salary 
		wd.findElement(By.xpath("//*[@id='department']")).sendKeys("Manager");  // Department name
		Thread.sleep(1000);
		wd.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();  // Subit 
		wd.findElement(By.xpath("//*[@title='Delete']")).click();
		
	}
	@Test
	public void Buttos() throws InterruptedException
	{
		wd.get("https://demoqa.com/buttons");
		Actions act= new Actions(wd);
		WebElement we1 =wd.findElement(By.xpath("//*[@id='doubleClickBtn']"));
	    act.doubleClick(we1).build().perform();
		WebElement we=wd.findElement(By.xpath("//*[@id='rightClickBtn']"));
	    act.contextClick(we).build().perform();
	    wd.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
//	    act.
	    	    
	}
	@Test
	public void link() 
	{
		wd.get("https://demoqa.com/links");
		wd.findElement(By.xpath("//*[@id='simpleLink']")).click();
		String str= wd.getTitle();
		System.out.println(str);
		Assert.assertEquals(str, "DEMOQA");
	}
	@Test
	public void alert() throws InterruptedException
	{
		wd.get("https://demoqa.com/alerts");
		wd.findElement(By.xpath("//*[@id='alertButton']")).click();
		Thread.sleep(5000);
		Alert alt = wd.switchTo().alert();
		alt.accept();
		
	}
	@Test
	public void alert1() throws InterruptedException
	{
		wd.get("https://demoqa.com/alerts");
		wd.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
		Thread.sleep(5000);
		Alert alt = wd.switchTo().alert();
		
		String s=alt.getText();
		System.out.println(s);
		alt.accept();
		
	}
	@Test
	public void alert2() throws InterruptedException
	{
		wd.get("https://demoqa.com/alerts");
		wd.findElement(By.xpath("//*[@id='confirmButton']")).click();
		Thread.sleep(5000);
		Alert alt = wd.switchTo().alert();
		alt.accept();
		alt.dismiss();
		
	}
	@Test
	public void alert3() throws InterruptedException
	{
		wd.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor)wd;
//		js.executeScript("document.get");
		wd.findElement(By.xpath("//*[@id='promtButton']")).click();
		Thread.sleep(5000);
		Alert alt = wd.switchTo().alert();
		alt.sendKeys("Ashok");
		alt.accept();
		alt.dismiss();
		
	}
	@Test
	public void switchwindows() throws InterruptedException
	{
		wd.get("https://demoqa.com/browser-windows");
		
		String pw= wd.getWindowHandle();
		System.out.println(pw);
//		Thread.sleep(2000);
		WebElement  we = wd.findElement(By.xpath("//*[@id='windowButton']"));
		for(int i=0; i<3;i++)
		{
			we.click();
		}
		Set<String>Allwindows= wd.getWindowHandles();
		System.out.println(Allwindows.size());
		String lastwindow ="";
		for(String handle:Allwindows) 
		{
			wd.switchTo().window(handle);
			wd.get("https://www.google.com/"); // open multiple windows
			
		}
		wd.switchTo().window(pw);
		wd.get("https://demoqa.com/browser-windows");
		wd.close();
		wd.switchTo().window(lastwindow);
		wd.get("https://www.amazon.com/");
	}
	@Test
	public void uploadDownload() 
	{
		wd.get("https://demoqa.com/upload-download");
//		wd.findElement(By.xpath("//*[@id='downloadButton']")).click();
		wd.findElement(By.xpath("//*[@id='uploadFile']")).sendKeys("C:\\Users\\lenovo\\Downloads\\sampleFile.jpeg");
	}
	@Test
	public void DradandDrop() 
	{
		wd.get("https://demoqa.com/droppable");
		Actions act = new Actions(wd);
		WebElement we= wd.findElement(By.xpath("//*[@id='draggable']"));
		WebElement we1= wd.findElement(By.xpath("//*[@id='droppable']"));
		act.dragAndDrop(we, we1).build().perform();
}
	
}
