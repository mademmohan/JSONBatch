package com.automationtesting.SeleniumProgramming;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicRadioandCheckBoxHandling {
	static WebDriver driver;
	
	public static void test(String selectcar)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://courses.letskodeit.com/practice");
		
		List<WebElement> allradiobuttons=driver.findElements(By.xpath("//input[@type='radio']"));
		
		for( WebElement elements:allradiobuttons)
		{
			String carnames=elements.getAttribute("value");
			
			System.out.println("List of Car Names "+carnames);
			
			if(carnames.equalsIgnoreCase(selectcar))
			{
				elements.click();
				break;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		test("benz");
	}

}
