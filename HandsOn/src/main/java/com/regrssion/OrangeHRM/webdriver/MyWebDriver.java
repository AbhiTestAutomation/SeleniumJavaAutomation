package com.regrssion.OrangeHRM.webdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyWebDriver {
	
	private static final WebDriver driver = initDriver();
	
	public static WebDriver getWebDriver() throws Exception {
		System.out.println("In getWebDriver method...");
		if (null != driver) {
			return driver;
		} else {
			throw new Exception("driver is not initialized");
		}
	}
	
	public static void launchURL() throws FileNotFoundException, IOException, Exception {
		Properties prop = getPropertyFile();
		String url = prop.getProperty("url");
		System.out.println("inside launch url");
		if (null != driver) {
			driver.get(url);
			driver.manage().window().maximize();
		}
		else
			throw new Exception("driver is not initialized");
	}
	
	private static WebDriver initDriver() {
		System.out.println("In initDriver method..");
		Properties prop = null;
		WebDriver driver = null;
		try {
			prop = getPropertyFile();
			String Browsername = prop.getProperty("browser");
			
			if(Browsername.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", "\\Users\\gudmh\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("chrome is set");
			}
			else if(Browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.chrome.driver", "\\Users\\gudmh\\Downloads\\chromedriver_win32\\gekodriver.exe");
				driver = new FirefoxDriver();
			}
		} catch (IOException e) {
			System.out.println("Failed to load properties file...");
			e.printStackTrace();
		}
		
		return driver;

	}

	private static Properties getPropertyFile() throws FileNotFoundException, IOException {
		System.out.println("Reading Properties File...");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/configuration/configuration.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}

}
