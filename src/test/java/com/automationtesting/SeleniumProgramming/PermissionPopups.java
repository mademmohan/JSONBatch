package com.automationtesting.SeleniumProgramming;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PermissionPopups {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		DesiredCapabilities capabilites= new DesiredCapabilities();
		capabilites.setAcceptInsecureCerts(true);
		ChromeOptions options= new ChromeOptions();
		options.merge(capabilites);
		
		options.addArguments("--incognito");
		
		HashMap<String, Integer> contentsettings= new HashMap<>();
		HashMap<String, Object> profile= new HashMap<>();
		HashMap<String, Object> prefs= new HashMap<>();
		contentsettings.put("media_stream", 1);
		profile.put("managed_default_content_settings", contentsettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://webcamtests.com/");
		driver.findElement(By.id("webcam-selecter")).click();
	}

}
