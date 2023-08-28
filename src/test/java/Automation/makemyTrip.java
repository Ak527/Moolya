package Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemyTrip
{
	WebDriver wd;
	Robot rt;
	@BeforeTest
	public void bt1() throws InterruptedException
	{
//		System.setProperty("webdriver.chrome.driver", "F:\\@@@@Moolya\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		Thread.sleep(2000);
		wd.manage().window().maximize(); 
		Thread.sleep(3000);
//		wd.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		
	}
	@Test(priority=0)
	public void FrameTest() throws AWTException, InterruptedException 
	{
		wd.get("https://www.makemytrip.com/");
		rt = new Robot();
//		rt.keyPress(MenuKeyEvent.VK_F5);
		Thread.sleep(3000);
//		WebDriverWait wait= new WebDriverWait(wd, 10);
//		 rt.keyPress(MenuKeyEvent.VK_CONTROL);
//		rt.keyPress(MenuKeyEvent.VK_R);
//		rt.keyRelease(MenuKeyEvent.VK_R);
//		rt.keyRelease(MenuKeyEvent.VK_CONTROL);
//		WebElement we1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='wrapper-outer']/div/div/a/i")));
//		we1.click();
//		wd.findElement(By.xpath("//*[@class='wewidgeticon we_close']")).click();//google ads
//		document.getElementById('webklipper-publisher-widget-container-notification-close-div')
		JavascriptExecutor js = (JavascriptExecutor)wd;
		WebElement we1=(WebElement) js.executeScript("document.getElementById('webklipper-publisher-widget-container-notification-close-div')");
		System.out.println(we1);
		we1.click();
		wd.findElement(By.xpath("//*[@class='wrapper-outer']/div/div/a/i")).click();//google ads
		
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='tabsCircle appendRight5'])[1]")).click();
		wd.findElement(By.xpath("//*[@id='fromCity']")).sendKeys("blr");
		Thread.sleep(3000);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		wd.findElement(By.xpath("//*[@id='toCity']")).sendKeys("dxb");
		Thread.sleep(3000);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='lbl_input appendBottom10'])[3]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='DayPicker-Month']/div[3])[1]/div[4]/div[6]")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();

	}
	@Test(priority=1)
	public void next() throws InterruptedException 
	{
		Thread.sleep(20000);		
//		wd.findElement(By.xpath("//*[@class='button buttonSecondry buttonBig fontSize12 relative']")).click();
//		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class='bgProperties icon20 overlayCrossIcon']")).click();
		
	}
	@Test(priority=2)
	public void  SelectFlight() throws InterruptedException
	{
		wd.findElement(By.xpath("//*[@class='listingCardWrap']/div[1]/div/div[1]")).click();
		JavascriptExecutor js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		wd.findElement(By.xpath("(//*[@class='appendBottom15 '])[6]/div[1]/div[2]/div[2]/div/button")).click(); // Hide Prices butto
		wd.findElement(By.xpath("//*[@class='viewFareRowWrap']/div/div/div[2]/button")).click();// book button // AirAsia economy 4:10 connecting flight spicejet from mumbai
//		wd.findElement(By.xpath("(//*[@id='bookbutton-RKEY:88a595fd-286a-4756-be27-ecfeeb8f8d54:26_0'])[1]")).click();
//		wd.findElement(By.xpath("(//*[@id='bookbutton-RKEY:88a595fd-286a-4756-be27-ecfeeb8f8d54:26_0'])[2]")).click();
	}
	@Test(priority=3)
	public void BookingDetails() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(5000);
//		wd.findElement(By.xpath("(//*[@class='appendRight10'])[1]")).click();// checkbox    //*[@class='makeFlex hrtlCenter pointer']
//		js.executeScript("window.scrollBy(0,100)");
//		Thread.sleep(5000);
		wd.findElement(By.xpath("(//*[@class='radioboxContainer '])[2] ")).click();// Radio button
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(5000);
		wd.findElement(By.xpath("(//*[@class='otherList'])[2]")).click();// add button //(//*[@class='otherList'])[2]/button
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(5000);
		wd.findElement(By.xpath("(//*[@class='tvlrInput '])[1]")).sendKeys("9700604527");// mobile number
		wd.findElement(By.xpath("(//*[@class='tvlrInput '])[2]")).sendKeys("ashok.katuri@moolyaed.com");//
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(5000);
		wd.findElement(By.xpath("(//*[@class='labelInputWpr__input '])[1]")).sendKeys("523155");
		wd.findElement(By.xpath("//*[@class='dropdownFieldWpr__input  ']")).click();
		Thread.sleep(5000);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_DOWN);
		rt.keyPress(MenuKeyEvent.VK_ENTER);
		wd.findElement(By.xpath("//*[@class='lato-black button buttonPrimary extraPadBtn fontSize16 ']")).click();
	}

}
