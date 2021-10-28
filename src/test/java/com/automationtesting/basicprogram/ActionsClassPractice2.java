package com.automationtesting.basicprogram;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassPractice2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions action= new Actions(dr);
		WebElement rightclickoption=dr.findElement(By.xpath("//span[.='right click me']"));
	   action.contextClick(rightclickoption).perform();
	   Thread.sleep(2000);
	   WebElement option=dr.findElement(By.xpath("//span[.='Delete']"));
	   
	   option.click();
	   
	   Alert alert=dr.switchTo().alert();
	   System.out.println(alert.getText());
	   alert.accept();
	   
	}

}
