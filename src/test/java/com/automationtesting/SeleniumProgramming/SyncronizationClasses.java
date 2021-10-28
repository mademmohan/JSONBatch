package com.automationtesting.SeleniumProgramming;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncronizationClasses {
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Implicity wait- It is global wait
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");

		driver.findElement(By.xpath("//button[.='Add Textbox1']")).click();
		
		//WebElement textbox=driver.findElement(By.id("txt1"));
		
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt1")));
		
		driver.findElement(By.id("txt1")).sendKeys("shiva");

		driver.findElement(By.xpath("//button[.='Add Textbox2']")).click();
		driver.findElement(By.id("txt2")).sendKeys("Ram");

	}

}
