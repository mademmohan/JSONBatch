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

public class MultipleWindowHandling {
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
		driver.findElement(By.id("newWindowsBtn")).click();
		Set<String> allwindows = driver.getWindowHandles();//8 windows in set allows duplicate
		for (String window : allwindows) {// one after one it will iterate
			driver.switchTo().window(window);// child1,child2, child3, child4
			// false, false , false, true
			if (driver.getCurrentUrl().equalsIgnoreCase("https://www.hyrtutorials.com/p/basic-controls.html")) {
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("JSN Testing");
			}
		}

	}

	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		MultipleWindowHandling ref = new MultipleWindowHandling();
		ref.setUp();
		ref.teardown();
	}

}
