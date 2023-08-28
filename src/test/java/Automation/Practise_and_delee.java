package Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practise_and_delee 
{
	WebDriver wd;
	@BeforeTest
	public void BT() 
	{
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void frames() throws InterruptedException 
	{
		wd. get("https://demoqa.com/frames");
		JavascriptExecutor js= (JavascriptExecutor)wd;
		Thread.sleep(2000);
		js.executeScript("document.getElementById('frame2').scrollIntoView()");
//		List<WebElement> frames= wd.findElements(By.tagName("iframe"));
//		System.out.println(frames.size());
//		for(int i=0; i<= frames.size(); i++) 
//		{
//			String str= frames.get(i).getAttribute("Id");
//			System.out.println(str);
//		}
//		wd.switchTo().frame("frame1");
		String st= wd.switchTo().frame("frame1").getTitle();
		System.out.println(st);
		js.executeScript("Window.scrollBy(0,-200)");
		
	}

}
