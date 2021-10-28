package com.automationtesting.basicprogram;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String child = itr.next();

			if (!child.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(child);
				driver.findElement(By.id("alertBox")).click();
				
				Alert alt= driver.switchTo().alert();
				System.out.println(alt.getText());
				alt.accept();
				break;
			}
		}
		driver.close();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.className("whTextBox")).sendKeys("Windowhandle completed");
		
		
	}

}
