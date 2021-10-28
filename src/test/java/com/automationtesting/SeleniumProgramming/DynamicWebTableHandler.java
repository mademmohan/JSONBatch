package com.automationtesting.SeleniumProgramming;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableHandler {

	static String checkbox = "//td[text()='%s']//preceding-sibling::td/input";

	static String link = "//td[text()='%s']//following-sibling::td[last()]";

	static String country_text = "//td[text()='%s']//following-sibling::td[2]";

	public static void webTableHandler(String checkbox_data, String linktext_data, String countrytext_key)
			throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://seleniumpractise.blogspot.com/2021/08/");

		driver.findElement(By.xpath(String.format(checkbox, checkbox_data))).click();

		// Selection of Links

		Thread.sleep(5000);
		
		String countrydata = driver.findElement(By.xpath(String.format(country_text, countrytext_key))).getText();
		
		Thread.sleep(2000);

		System.out.println("Required text of country : " + countrydata);

		driver.findElement(By.xpath(String.format(link, linktext_data))).click();

		Thread.sleep(2000);
		
		driver.close();
		

	}

	public static void main(String[] args) throws InterruptedException {
		webTableHandler("Java", "Selenium", "FlipKart");

	}
}
