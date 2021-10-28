package com.automationtesting.SeleniumProgramming;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://seleniumpractise.blogspot.com/2021/08/");

		List<WebElement> ref = driver.findElements(By.xpath("//table[@id='customers']//tr[1]/following::tr"));
		System.out.println("Total number of rows " + ref.size());

		for (WebElement alltablerowsdata : ref) {
			  String data=alltablerowsdata.getText();
			  
			  System.out.print("  ||  " +data);
			  System.out.println();
		}
		

	}

}
