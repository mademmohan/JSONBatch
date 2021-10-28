package com.automationtesting.SeleniumProgramming;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {
	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://courses.letskodeit.com/practice");
		
		  List<WebElement> tablerows=driver.findElements(By.xpath("//table[@name='courses']//tr"));
		  
		  List<WebElement> tablecolumns=driver.findElements(By.xpath("//table[@name='courses']//tr/td"));
		  
		  System.out.println("Count of table rows "+tablerows.size());
		  System.out.println("Count of table columbs "+tablecolumns.size());
	}

}
