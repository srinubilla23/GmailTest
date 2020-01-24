package fileTransfer;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Message  
{
	public WebDriver driver;

	@Parameters("Browser")
	@Test(priority = 1)
	public void Browser(String Browser) {
		System.out.println("Enter Browser Name:" + Browser);
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();

		if (x.equalsIgnoreCase("c")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Jar Files\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (x.equalsIgnoreCase("f")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Jar Files\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (x.equalsIgnoreCase("f")) {
			System.setProperty("webdriver.ie.driver", "E:\\Jar Files\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@Parameters("url")
	@Test(priority = 2)
	public void link(String url) {
		driver.get(url);
	}

	@Parameters({ "username", "password" })
	@Test(priority = 3)
	public void credentials(String username, String password) throws Exception {
		WebElement user1 = driver.findElement(By.id("identifierId"));
		user1.sendKeys(username);

		if (username.equals("srinuk247hh@gmail.com")) {
			System.out.println("Username Test Pass");
		}

		else {
			System.out.println("Username Test Fail");
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File scr = new File("F:\\Download\\Images\\Bug Screenshot\\Bug.jpg");
			FileUtils.copyFile(f, scr);
			Thread.sleep(5000);
			driver.close();
		}

		driver.findElement(By.xpath("(//*[contains(text(), 'Next')])[2]")).click();

		WebElement pass1 = driver.findElement(By.name("password"));
		pass1.sendKeys(password);

		if (password.equals("8019986966")) {
			System.out.println("Password Test Pass");
		}

		else {
			System.out.println("Password Test Fail");
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File scr = new File("F:\\Download\\Images\\Bug Screenshot\\Bug.jpg");
			FileUtils.copyFile(f, scr);
			Thread.sleep(5000);
			driver.close();
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[contains(text(), 'Next')])[2]")).click();
	}

	@Test(priority = 4)
	public void send() throws Exception 
	{
		driver.findElement(By.xpath("(//*[@aria-label=\"Google apps\"][1])")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"gb23\"]/span[1]")).click();	
		Thread.sleep(3000); 
		Screen s=new Screen();
		s.click("F:\\Download\\Images\\Bug Screenshot\\GmailCompose.JPG");
	}

	 @Parameters({"subject", "message" })  
	 @Test(priority=5) 
	 public void compose(String mailid, String subject, String message) throws Exception 
	 { 
		 Thread.sleep(5000);
		 Screen to=new Screen();
		 to.type("F:\\Download\\Images\\Bug Screenshot\\to.JPG");
		 //driver.findElement(By.xpath("//*[contains(@name, 'to')]")).sendKeys(mailid);
		 driver.findElement(By.name("subjectbox")).sendKeys(subject);
		 driver.findElement(By.xpath("//*[@id=\":7o\"][@hidefocus=\"true\"]")).sendKeys(message); 
	 }
	 

}
