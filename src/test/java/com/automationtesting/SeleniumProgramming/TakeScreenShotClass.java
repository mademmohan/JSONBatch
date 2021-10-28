package com.automationtesting.SeleniumProgramming;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShotClass {
	
	public static void screenShot(WebDriver driver, String fileName) throws IOException
	{
		TakesScreenshot shot= ((TakesScreenshot)driver);
		File src= shot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C:\\Users\\MADEM\\JSON Batch-1\\AutomationTesting\\ScreenShot\\"+fileName+".jpg"));
	}
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//For finding of objects in UI page
		driver.get("https://github.com/login");
		screenShot(driver, "homepage");
		
		
		
	}

}
