package com.automationtesting.basicprogram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		dr.findElement(By.id("txtUsername")).sendKeys("Admin");
		dr.findElement(By.id("txtPassword")).sendKeys("admin123");
		dr.findElement(By.id("btnLogin")).click();
		WebElement adminmenu = dr.findElement(By.xpath("//a[.='Admin']"));
		Thread.sleep(2000);

		WebElement Organizationmenu = dr.findElement(By.xpath("//a[.='Organization']"));
		Thread.sleep(2000);

		WebElement locations = dr.findElement(By.xpath("//a[.='Locations']"));
		Thread.sleep(2000);

		Actions action = new Actions(dr);
		action.moveToElement(adminmenu).moveToElement(Organizationmenu).moveToElement(locations).click().perform();
		
		//Double click operations
		
	WebElement textbox=	dr.findElement(By.id("searchLocation_name"));
	textbox.sendKeys("areyoyee");
	action.moveToElement(textbox).doubleClick(textbox).perform();
	}

}
