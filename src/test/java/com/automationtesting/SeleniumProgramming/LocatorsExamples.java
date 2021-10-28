package com.automationtesting.SeleniumProgramming;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsExamples {

	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
	}
	
	public static void takeScreeenShot(WebDriver driver, String TypeofScreenshot) throws IOException
	{
		TakesScreenshot shot=((TakesScreenshot)driver);
		File scr=shot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("C:\\Users\\MADEM\\Desktop\\Fist Automation Batch\\"+TypeofScreenshot+".jpg"));
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		takeScreeenShot(driver, "Homepage");
		
		//Class Name
		WebElement logo=driver.findElement(By.className("header-logo"));
		highlight(driver, logo);
		Thread.sleep(2000);
		
		
		
		//Id
		
		highlight(driver, driver.findElement(By.id("login_field")));
		Thread.sleep(2000);
		takeScreeenShot(driver, "Login highligheted");
		
		//name
		highlight(driver, driver.findElement(By.name("password")));	
		Thread.sleep(2000);
		
		//tag Name
		highlight(driver, driver.findElement(By.tagName("h1")));
		Thread.sleep(2000);
		
		//linkText
		highlight(driver, driver.findElement(By.linkText("Forgot password?")));
		Thread.sleep(2000);
		
		//partial linktext
		highlight(driver, driver.findElement(By.partialLinkText("Forgot")));
		Thread.sleep(2000);
		
		//Xpath
		highlight(driver, driver.findElement(By.xpath("//label[contains(text(),'Username')]")));
		Thread.sleep(2000);
		
		//Css
		highlight(driver, driver.findElement(By.cssSelector("input[name='commit']")));
		
		TakesScreenshot shot=((TakesScreenshot)driver);
		File src=shot.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\MADEM\\Desktop\\Fist Automation Batch\\firstscreenshot1.jpg");
		
		FileUtils.copyFile(src, dest);
		
		
		
	}

}
