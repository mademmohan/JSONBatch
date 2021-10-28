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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioandCheckBoxHandling {
	WebDriver driver;

	public static void screenShot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot shot = ((TakesScreenshot) driver);
		File src = shot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src,
				new File("C:\\Users\\MADEM\\JSON Batch-1\\AutomationTesting\\ScreenShot\\" + fileName + ".jpg"));
	}

	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://courses.letskodeit.com/practice");
		screenShot(driver, "CodeitHomePage");
	}

	@Test
	public void radioButtonsHandle() throws InterruptedException, IOException {
		WebElement bmw_radioButton = driver.findElement(By.xpath("//input[@value='bmw' and @type= 'radio']"));

		bmw_radioButton.click();

		Thread.sleep(2000);

		WebElement benz_radioButton = driver.findElement(By.xpath("//input[@value='benz' and @type= 'radio']"));

		benz_radioButton.click();
		
		Thread.sleep(2000);

		WebElement bmw_checkboxButton = driver.findElement(By.xpath("//input[@value='bmw' and @type= 'checkbox']"));

		bmw_checkboxButton.click();

		Thread.sleep(2000);

		WebElement honda_checkboxButton = driver.findElement(By.xpath("//input[@value='honda' and @type= 'checkbox']"));

		honda_checkboxButton.click();
		
		screenShot(driver, "Radio&checkboxselection");

		Thread.sleep(5000);
		
		
		System.out.println("BMW isselected? "+bmw_radioButton.isSelected());
		
		System.out.println("benz isselected? "+benz_radioButton.isSelected());
		
		System.out.println("bmw checkbox isselected? "+bmw_checkboxButton.isSelected());
		
		System.out.println("honda checkbox isselencted? "+honda_checkboxButton.isSelected());
		
		

		driver.close();
	}

}
