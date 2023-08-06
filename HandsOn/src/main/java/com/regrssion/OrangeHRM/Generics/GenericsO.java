package com.regrssion.OrangeHRM.Generics;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regrssion.OrangeHRM.webdriver.MyWebDriver;

import freemarker.template.SimpleDate;

public class GenericsO {
	
	public WebDriver driver;
	
	public GenericsO() throws Exception {
		this.driver = MyWebDriver.getWebDriver();
	}
	
	/*public static void LaunchApplication() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/configuration/configuration.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String Browsername = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		
		if(Browsername.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "\\Users\\gudmh\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "\\Users\\gudmh\\Downloads\\chromedriver_win32\\gekodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(Url);
		driver.manage().window().maximize();
	}*/
	
	public void LaunchApp() throws FileNotFoundException, IOException, Exception {
		MyWebDriver.launchURL();
		
	}
	//Sendkeys
	public void SendKeysToWebElement(WebElement element,String text) {
		WebElementWait(element,10);
		element.click();
		element.clear();
		element.sendKeys(text);
		
	}
	
	
	//ExplicitWaits
	public WebElement WebElementWait(WebElement element,int waitTimeSeconds) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(waitTimeSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
		
	}
	
	//ImplicitWaits
	public void waitImplicitly(int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
		
	}
	//Click
	public void ClickWebelement(WebElement element) {
		WebElementWait(element,50);
		element.click();
		
	}
	
	//MouseHover
	public void MouseHoverAndClick(WebElement element) {
		Actions action = new Actions(driver);	
		action.moveToElement(element).click().build().perform();
	}
	
	//TakeScreenShot
	
	public String GetScreenShot(String testname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs((OutputType.FILE));
		File file = new File(System.getProperty("user.dir") + "//Reports//" +testname+".png");
		FileHandler.copy(source, file);
		return System.getProperty("user.dir") + "//Reports//" +testname+".png";
	}
	//TearDown
	public void TearDown() {
		driver.close();
	}
}
