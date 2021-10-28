package com.automationtesting.SeleniumProgramming;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OrangeHRMApplication {

	public WebDriver driver;

	public static void screenShot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot shot = ((TakesScreenshot) driver);
		File src = shot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src,
				new File("C:\\Users\\MADEM\\JSON Batch-1\\AutomationTesting\\ScreenShot\\" + fileName + ".jpg"));
	}

	@Test(priority = 1)
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		// Title validation
		String expectedtitle = "OrangeHRM123243";
		String actualtitle = driver.getTitle();
		
		SoftAssert softassert= new SoftAssert(); //non static method
		
		softassert.assertEquals(actualtitle, expectedtitle,"mismatch between title of the page");
	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		
		//url Validataion
		String expectedURLonHomepage = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualURLonHomepage = driver.getCurrentUrl();
		
		softassert.assertEquals(actualURLonHomepage, expectedURLonHomepage);
		softassert.assertAll();// By using assertAll() method it produce report.
		
	
		
		
		
		

	}

	/*
	 * @Test (priority = 2) public void orageHrmLogin() throws InterruptedException,
	 * IOException {
	 * 
	 * driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	 * Thread.sleep(1000);
	 * driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	 * Thread.sleep(1000); driver.findElement(By.name("Submit")).click();
	 * 
	 * String expectedURLonHomepage =
	 * "https://opensource-demo.orangehrmlive.com/index.php/dashboard"; String
	 * actualURLonHomepage = driver.getCurrentUrl();
	 * assertEquals(actualURLonHomepage, expectedURLonHomepage); screenShot(driver,
	 * "OrangeHRMHomePage"); }
	 */
	/*
	 * WebElement Admin=driver.findElement(By.xpath("//a[.='Admin']"));
	 * 
	 * 
	 * Actions act = new Actions(driver);
	 * act.moveToElement(driver.findElement(By.xpath("//a[.='Admin']")))
	 * .moveToElement(driver.findElement(By.xpath("//a[.='Organization']")))
	 * .moveToElement(driver.findElement(By.xpath("//a[.='Locations']"))).click().
	 * perform();
	 * 
	 * screenShot(driver, "AdminHighlight");
	 * 
	 * 
	 * Thread.sleep(2000); screenShot(driver, "LocationScreenshot"); WebElement
	 * location=driver.findElement(By.id("searchLocation_name"));
	 * location.sendKeys("Hyderabad");
	 * 
	 * act.doubleClick(location).perform(); Thread.sleep(2000);
	 */
	/*
	 * @Test(priority = 3) public void tearDown() { driver.close();
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) throws InterruptedException,
	 * IOException { OrangeHRMApplication ref = new OrangeHRMApplication();
	 * ref.setUp(); ref.orageHrmLogin(); ref.tearDown();
	 * 
	 * }
	 */

}
