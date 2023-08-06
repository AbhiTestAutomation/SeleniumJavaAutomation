package com.regrssion.OrangeHRM.Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class staleEleNscriptTimeout {
	
	@FindBy(xpath="//div[@class='field-1 flex flex-middle p-relative pr-4 w-100p ']/input")
	private static WebElement fromCity;
	
	public static WebDriver driver;
	static String Url = "https://www.cleartrip.com/flights?utm_source=google&utm_medium=cpc&utm_campaign=BR_Cleartrip-Desktab&dxid=Cj0KCQjwzdOlBhCNARIsAPMwjbykBvXdhuX6mcgB5SEQ2zRtB2N84OMkzRAeCpyKSt--o4D62gZ4nK8aAlbOEALw_wcB&gclid=Cj0KCQjwzdOlBhCNARIsAPMwjbykBvXdhuX6mcgB5SEQ2zRtB2N84OMkzRAeCpyKSt--o4D62gZ4nK8aAlbOEALw_wcB";
	
	
	public staleEleNscriptTimeout() {
		PageFactory.initElements(driver,this);
	}
	
	
	public static void LaunchSite() throws IOException, InterruptedException {
		
		System.out.println("inside chrome");
		System.setProperty("webdriver.chrome.driver", "\\Users\\gudmh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("trying to open url");
		driver.get(Url);
		driver.manage().window().maximize();
	//	driver.get(Url);
		fromCity.click();
		//Thread.sleep(300);
		//WebElement tocity = driver.findElement(By.xpath("//div[@class='field-1 flex flex-middle p-relative pr-4 w-100p ']/input"));
		driver.navigate().refresh();
		Thread.sleep(300);
		fromCity.click();
	}
		
		
		//Approach 1:
		/*try {
			tocity.click();
		}
		catch(StaleElementReferenceException e) {
			 tocity = driver.findElement(By.xpath("//div[@class='field-1 flex flex-middle p-relative pr-4 w-100p ']/input"));
			 tocity.click();
		}
		*/
		
		//Approach 2:
	/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if(wait.until(ExpectedConditions.stalenessOf(tocity))==false) {
			System.out.println("staleelement fasle");
			tocity.click();
		}
		else {
			System.out.println("staleelement refreshed");
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(tocity)));
			tocity.click();
		}
	}*/
		
	
}
