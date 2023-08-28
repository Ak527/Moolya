package Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class moneycontrol_JS {
	WebDriver wd;
	@BeforeTest
	public void moneyControl()
	{
		WebDriverManager.chromedriver().setup();
		wd= new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	@Test
	public void MChome() {
		wd.get("https://www.moneycontrol.com/");
		WebElement we=wd.findElement(By.xpath("(//*[@title='Personal Finance'])[2]"));
//		WebElement we= wd.findElement(By.linkText("Personal Finance"));
		Actions act= new Actions(wd);
		act.moveToElement(we).build().perform();
		wd.findElement(By.xpath("//*[@title='Home Loan Calculator']")).click();
//		wd.findElement(By.linkText("Home Loan Calculator")).click();
		JavascriptExecutor js= (JavascriptExecutor)wd;
//		js.executeScript("window.scrollBy(0,800)");
		js.executeScript("document.getElementById('emi_table').scrollIntoView()");
		String str= wd.findElement(By.xpath("//table[@id='emi_table']/tbody/tr[11]/td[4]")).getText();// find web table element
		System.out.println(str);
		
		
	}

}
