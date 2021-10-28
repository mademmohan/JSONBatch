package com.automationtesting.basicprogram;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestdataReader {

	static public FileInputStream file;
	static public Workbook wb;
	static public Sheet sh;

	public Object[][] testDataReading(String sheetName) {
		File F = new File("C:\\Users\\MADEM\\Desktop\\JSN.xlsx");

		try {
			file = new FileInputStream(F);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			wb = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sh = wb.getSheet(sheetName);

		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

		for (int i = 0; i < sh.getLastRowNum(); i++) {
			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return (Object[][]) data;
	}

	@DataProvider(name = "TestingData")
	public Object[][] readTestdata() {
		return testDataReading("Test");
	}
	
	

	@Test(dataProvider = "TestingData")
	public void login(String userName, String Password) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		WebElement UserName_Element = driver.findElement(By.id("txtUsername"));
		UserName_Element.clear();
		UserName_Element.sendKeys(userName);
		WebElement password_Element = driver.findElement(By.id("txtPassword"));
		password_Element.clear();
		password_Element.sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();

		String expected = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actual = driver.getCurrentUrl();
		assertEquals(actual, expected, "Expected title is not displayed");
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='welcome']"))).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		
		Thread.sleep(2000);
		driver.close();
		

	}

}
