package com.automationtesting.SeleniumProgramming;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FramesHandling {

	static WebDriver driver;

	public static void screenShot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot shot = ((TakesScreenshot) driver);
		File src = shot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src,
				new File("C:\\Users\\MADEM\\JSON Batch-1\\AutomationTesting\\ScreenShot\\" + fileName + ".jpg"));
	}

	public static void setUp() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		WebElement entrytextbox = driver.findElement(By.id("name"));
		entrytextbox.sendKeys("Before Entring into frame");

		// Entering into first frame
		WebElement frame1 = driver.findElement(By.id("frm1"));
		driver.switchTo().frame(frame1);

		Select select = new Select(driver.findElement(By.id("selectnav1")));
		select.selectByVisibleText("Tutorials");
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);

		entrytextbox.clear();
		Thread.sleep(2000);

	}

	public void tearDown() {

		driver.close();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		setUp();
		FramesHandling ref = new FramesHandling();
		ref.tearDown();
	}

}
