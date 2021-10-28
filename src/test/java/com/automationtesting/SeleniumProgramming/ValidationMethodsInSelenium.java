package com.automationtesting.SeleniumProgramming;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidationMethodsInSelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Forgot password?")).click();
		Thread.sleep(3000);
		
		WebElement button=driver.findElement(By.name("commit"));
		
		System.out.println("isSelected that button "+button.isSelected());
		System.out.println("isdisplayed that button "+button.isDisplayed());
		System.out.println("isEnabled that button "+button.isEnabled());
	}

}
