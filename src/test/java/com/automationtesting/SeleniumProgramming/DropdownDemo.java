package com.automationtesting.SeleniumProgramming;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo {

	public static void dropDownPractice() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		WebElement idelist = driver.findElement(By.id("ide"));

		Select selectide = new Select(idelist);
		
		    List<WebElement> idetypes=selectide.getOptions();
		    
		    for(WebElement ides:idetypes)
		    {
		    	String list=ides.getText();
		    	System.out.println(list);
		    }

		selectide.selectByIndex(1);// IntelliJ IDEA
		Thread.sleep(2000);
		selectide.selectByValue("nb");// NetBeams
		Thread.sleep(2000);
		selectide.selectByVisibleText("Visual Studio"); //Visual Studio
		Thread.sleep(2000);//";" Line of statement is completed
		
		selectide.deselectByIndex(1);
		
		  List<WebElement> allselectedoptions=selectide.getAllSelectedOptions();
		  
		    Iterator itr=allselectedoptions.iterator();
		    
		    while(itr.hasNext())
		    {
		    	System.out.println(itr.next());
		    }
		    
		    for(WebElement options: allselectedoptions)
		    {
		    	System.out.println(options.getText());
		    }
		
		/*
		 * String finallyselectedOption=select.getFirstSelectedOption().getText();
		 * System.out.println("Finally selected option in dropdown "
		 * +finallyselectedOption);
		 */

		Thread.sleep(3000);
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		dropDownPractice();
	}

}
