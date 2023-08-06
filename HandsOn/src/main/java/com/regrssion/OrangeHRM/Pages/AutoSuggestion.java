package com.regrssion.OrangeHRM.Pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoSuggestion {

	public static WebDriver driver;
	
	public static void autosuggest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "\\Users\\gudmh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Selenium");
	
		Thread.sleep(500);
		List<WebElement> searchlist =  driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
		
		for(WebElement mysearch : searchlist) {
			
			if (mysearch.getText().equalsIgnoreCase("selenium webdriver")) mysearch.click();
		}
		
	}
	
	@Test
	public void RunTest() throws InterruptedException {
		AutoSuggestion.autosuggest();
		
	}
	
}
