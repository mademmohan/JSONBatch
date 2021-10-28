package com.automationtesting.basicprogram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {
	static WebDriver driver;

	static String CompanyName_checkbox = "//td[text()='%s']//preceding-sibling::td/input";
	
	static String CompanyName_link= "//td[text()='%s']//following-sibling::td//a";

	public static void setup(String companyType, String contact) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2021/08/");
		WebElement companytype = driver.findElement(By.xpath(String.format(CompanyName_checkbox, companyType)));
		companytype.click();
		
		Thread.sleep(3000);
		WebElement linkclick=driver.findElement(By.xpath(String.format(CompanyName_link, contact )));
		linkclick.click();
		

	}

	public static void main(String[] args) throws InterruptedException {

		setup("Amazon", "Sachin Bansal");

	}

}
