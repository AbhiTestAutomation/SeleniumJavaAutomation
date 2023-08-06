package com.regression.amazon.generics;

import static org.testng.Assert.expectThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Generics {
	
	public static WebDriver driver;
	
	public void LaunchApplication() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/configuration/configuration.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		System.out.println("browsername:" + browsername);
		String Url = prop.getProperty("url");
		System.out.println("url is:" + Url);
		
		if(browsername.contains("chrome")){
			System.out.println("browsername:" + browsername);
			System.out.println("i am inside chrome");
			System.setProperty("webdriver.chrome.driver","\\Users\\gudmh\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver","\\Users\\gudmh\\Downloads\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			// Firefox
		} else if (browsername.equalsIgnoreCase("edge")) {
			// Edge
			System.setProperty("webdriver.chrome.driver","\\Users\\gudmh\\Downloads\\chromedriver_win32\\edge.exe");
			driver = new EdgeDriver();
		}
		driver.get(Url);
		driver.manage().window().maximize();
	   // return driver;
	}

	//properties red
		
	//SendKeys
	public void SendKeysWebElement(WebElement element,String text) {
		WaitForWebElement(element,10);
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	//Click
	public void ClickOnWebElement(WebElement element,long waitTimeSeconds ) {
		WaitForWebElement(element,10);
		element.click();
		
	}
	
	public WebElement WaitForWebElement(WebElement element, long waitTimeSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTimeSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
		
	}
	
	public void MouseHoverAndClick(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
		
	}
	
	//@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.close();
	}
		//keyboard and mouse
		//dropdown
		//handling alerts
		//window handling
		//capturing screenshots
		//double click
		
}
