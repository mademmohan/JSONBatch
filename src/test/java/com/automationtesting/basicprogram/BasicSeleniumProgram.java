package com.automationtesting.basicprogram;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumProgram {
	
	
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://www.google.com");
		WebElement searchbox=dr.findElement(By.name("q"));
		Thread.sleep(2000);
		highlight(dr, searchbox);
		Thread.sleep(2000);
		searchbox.sendKeys("Guru");
		
		TakesScreenshot shot= ((TakesScreenshot)dr);
		File src=shot.getScreenshotAs(OutputType.FILE);
		
		File Dest= new File("D://screenshot.png");
	    
		

	}

}
