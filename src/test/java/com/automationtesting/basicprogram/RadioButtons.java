package com.automationtesting.basicprogram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		List<WebElement> radiobuttons=driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		
		for(WebElement button:radiobuttons)
		{
		       String values=button.getAttribute("value");
		       System.out.println("Values in a radio page "+values);
		       
		       if(values.equals("RUBY"))
		       {
		    	   button.click();
		       }
		}
	}

}
