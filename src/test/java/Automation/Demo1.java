package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WdmAgent;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		wd.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		wd.findElement(By.xpath("//*[@type='submit']")).click();
//		wd.close();
		wd.quit();
		
	}
		
}
