package com.automationtesting.basicprogram;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookAssertion {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver dr = new ChromeDriver(options);
		dr.get("https://www.facebook.com/login/");
		dr.findElement(By.name("email")).sendKeys("testing", Keys.ENTER);
		Thread.sleep(3000);
		
		SoftAssert softassert= new SoftAssert();

		// title assertion

		String actualtitle = dr.getTitle();
		String expectedtitle = "Log in to Facebook";
		softassert.assertEquals(expectedtitle, actualtitle, "mismatched in pagetilte");
		
		//Url assertion
		
		String actualURL="https://www.facebook.com/login/";
		String expectedURL=dr.getCurrentUrl();
		softassert.assertEquals(expectedURL, actualURL, "mismatched in url");
		 
		
		
		//text assertion
		
		String actualtext=dr.findElement(By.name("email")).getAttribute("value");
		String expectedtext= "";
		softassert.assertEquals(actualtext, expectedtext, "mismatched in text");
		
		Thread.sleep(2000);
		softassert.assertAll();
		
	

	}

}
