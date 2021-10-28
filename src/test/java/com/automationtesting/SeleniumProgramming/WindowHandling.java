package com.automationtesting.SeleniumProgramming;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	WebDriver driver;

	public static void screenShot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot shot = ((TakesScreenshot) driver);
		File src = shot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src,
				new File("C:\\Users\\MADEM\\JSON Batch-1\\AutomationTesting\\ScreenShot\\" + fileName + ".jpg"));
	}

	public void setUp() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		screenShot(driver, "WindowHandlingHomePage");
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//div/button)[1]")).click();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!childwindow.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("JSN Testing");
				screenShot(driver, "childwindow");
				Thread.sleep(2000);
			}

		}

	}
	
	public void teardown()
	{
		driver.quit();;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		WindowHandling ref = new WindowHandling();
		ref.setUp();
		ref.teardown();
	}

}
