package experiment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.MyListener;

public class Facebook {
	public WebDriver wdriver;
	//create a variable for EventFiringWebDriver
	public EventFiringWebDriver driver;
	//boolean value for screenshot --if you set false it will highlight element
	public static boolean screenshot=true;
	//boolean value for highlight --if you set false it will not capture screenshot
	public static boolean highlight=true;
	//date --simple date format for screenshot folder name
	public static Date dNow = new Date( );
	public static SimpleDateFormat ft = new SimpleDateFormat("ddMMyy_HHmmss");
	public static String screenshotFolder=ft.format(dNow);

	@Test
	public void testFacebook() throws Exception {
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("WebDriverEventListener");
		driver.findElement(By.id("pass")).sendKeys("Password");
		driver.findElement(By.id("u_0_1")).sendKeys("FirstName");
		driver.findElement(By.id("u_0_3")).sendKeys("LastName");
		driver.findElement(By.id("u_0_5")).sendKeys("1234567890");
		driver.findElement(By.id("u_0_8")).sendKeys("1234567890");
		driver.findElement(By.id("u_0_a")).sendKeys("password");
		
	}

	@BeforeClass
	public void beforeClass() {
		//create an object for webdriver
		wdriver = new FirefoxDriver();
		//create an object for EventFiringWebDriver
		driver = new EventFiringWebDriver(wdriver);
		//this is class which implements WebDriverEventListener
		MyListener myListener = new MyListener();
		//registering EventFiringWebDriver to normal webdriver
		driver.register(myListener);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*System.setProperty("webdriver.chrome.driver", "D:\\Jar\\chromedriver.exe");
		driver = new ChromeDriver();*/
	}

	@AfterClass
	public void afterClass() throws Exception {
		driver.quit();
	}

}
