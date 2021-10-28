package com.automationtesting.SeleniumProgramming;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickOperations {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightclick = driver.findElement(By.xpath("//span[.='right click me']"));

		Actions actions = new Actions(driver);
		actions.contextClick(rightclick).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Copy']")).click();
		Alert alert = driver.switchTo().alert();

		String alerttext = alert.getText();
		System.out.println(alerttext);

		alert.accept();
		Thread.sleep(2000);
		driver.close();
	}

}
