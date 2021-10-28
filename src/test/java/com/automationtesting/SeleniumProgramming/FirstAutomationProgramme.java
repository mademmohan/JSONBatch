package com.automationtesting.SeleniumProgramming;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomationProgramme {

	public void browserInitialization() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");// In this browser page we need to perform search operation.
		driver.findElement(By.name("q")).sendKeys("MR Reddy Testing");
		// anther way
		WebElement ref = driver.findElement(By.name("q"));
		ref.sendKeys("");
		ref.click();
		ref.clear();
		String pagetitle = driver.getTitle();
		String pageURL = driver.getCurrentUrl();
		System.out.println("Current Page Title is: " + pagetitle);
		System.out.println("Current page URL is: " + pageURL);

		Thread.sleep(5000);// constantly wait-5 sec

		driver.close();
		

	}

	public static void main(String[] args) throws InterruptedException {
		FirstAutomationProgramme first = new FirstAutomationProgramme();
		first.browserInitialization();

	}

}
