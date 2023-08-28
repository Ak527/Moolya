package Automation;

import java.awt.Window;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames 
{
	WebDriver wd;
	@BeforeTest
	public void bt1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		Thread.sleep(2000);
		wd.manage().window().maximize();
		
	}
	@Test
	public void FrameTest() 
	{
		wd. get("https://demoqa.com/frames");
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("document.getElementById('frame2').scrollIntoView()");
		List<WebElement> frames = wd.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for(int i=0;i<frames.size(); i++) 
		{
			String names= frames.get(i).getAttribute("id");
			System.out.println(names);
			
			
		}
		wd.switchTo().frame("frame2");
		js.executeScript("Window.scrollBy(0,100)");
		wd.switchTo().frame("frame1");
		js.executeScript("Window.scrollBy(0,20)");
		wd.findElement(By.xpath("//iframe[@id='frame1']")).getText();
	}

}
