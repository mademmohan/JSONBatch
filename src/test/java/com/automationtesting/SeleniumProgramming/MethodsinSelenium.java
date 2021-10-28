package com.automationtesting.SeleniumProgramming;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodsinSelenium {
	
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
	}
	
	public void gitHubLogin() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//For finding of objects in UI page
		driver.get("https://github.com/login");
		
		Thread.sleep(3000);
		
		WebElement logintextbox=driver.findElement(By.id("login_field"));
		Thread.sleep(1000);
		highlight(driver, logintextbox);
		Thread.sleep(3000);
		logintextbox.sendKeys("admin");
		Thread.sleep(1000);
		logintextbox.clear();
		highlight(driver, logintextbox);
	WebElement passwordtextbox=	driver.findElement(By.name("password"));
	
		highlight(driver, passwordtextbox);
		passwordtextbox.sendKeys("admin");
		Thread.sleep(1000);
		highlight(driver, passwordtextbox);
		
		WebElement loginbutton=driver.findElement(By.name("commit"));
		highlight(driver, loginbutton);
		Thread.sleep(3000);
		loginbutton.click();
		
		
		//Link Text
		WebElement forgotpasswordlink=driver.findElement(By.linkText("Forgot password?"));
		highlight(driver, forgotpasswordlink);
		Thread.sleep(3000);
		forgotpasswordlink.click();
		
		//Partial Link Text
		driver.findElement(By.partialLinkText("Forgot")).click();
		
		
	}

	public static void main(String[] args) throws InterruptedException {
				MethodsinSelenium ref= new MethodsinSelenium();
				ref.gitHubLogin();
		
		
		
		//TagName
		//String textonpage = driver.findElement(By.tagName("h1")).getText();
		//System.out.println("Print text on page : "+textonpage);
		
		Thread.sleep(3000);
		//LinkText operation:
		//driver.findElement(By.linkText("Forgot password?")).click();
		
		/*
		 * Thread.sleep(3000);// It will completely stops execution of code
		 * driver.findElement(By.id("login_field")).sendKeys("admin");
		 * Thread.sleep(3000); driver.findElement(By.id("login_field")).clear();
		 * Thread.sleep(3000);
		 * driver.findElement(By.name("password")).sendKeys("admin");
		 * Thread.sleep(2000); driver.findElement(By.name("commit")).click();
		 * 
		 * Thread.sleep(4000);
		 */
		
		//driver.close();

	}

}
