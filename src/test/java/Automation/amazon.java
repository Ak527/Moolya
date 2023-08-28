package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon 
{
	WebDriver wd;
	@BeforeTest
	public void amazon() 
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("www.amazon.in");
	}
	@Test
	public void Accounts() 
	{
		Actions act= new Actions(wd);
		WebElement we= wd.findElement(By.xpath("//*[@id='nav-link-accountList']"));
		act.moveToElement(we).build().perform();
	}

}
