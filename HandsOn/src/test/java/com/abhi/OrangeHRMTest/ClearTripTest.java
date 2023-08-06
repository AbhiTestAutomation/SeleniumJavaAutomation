package com.abhi.OrangeHRMTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.beust.jcommander.Parameter;
import com.regrssion.OrangeHRM.ExtentReort.ExtentReportNG;
import com.regrssion.OrangeHRM.Generics.GenericsO;
import com.regrssion.OrangeHRM.Pages.ClearTripPage;
import com.regrssion.OrangeHRM.Pages.MakeMyTripDropDown;
import com.regrssion.OrangeHRM.webdriver.MyWebDriver;

public class ClearTripTest {
	
	//public GenericsO generics;
	public ClearTripPage dropdown;
	//public WebDriver driver;
	
	@Test(priority=1)
	public void initTest() throws Exception {
		this.dropdown = new ClearTripPage();
		this.dropdown.LaunchApp();
	}
	
	/*@Test(priority=1,groups = "Sanity")
	public void LaunchApp() throws IOException {
		//generics= new GenericsO();
		GenericsO.LaunchApplication();
		
	}*/
	@Test(priority=2)
	@Parameters({"FCity","TCity"})
	public void SelectCityDropDown(String Fcity, String Tcity) throws Exception {
		dropdown.SelectFromCity(Fcity);
		dropdown.SelectToCity(Tcity);
		dropdown.SearchFlight(); 
		//dropdown.bookFlight();
		//Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled=false)
	public void career() throws Exception {
		dropdown.scrollWebpage();
	}

	/*@AfterTest(alwaysRun = true)
	public void TearDown() {
		
		dropdown.TearDown();
	}
	
	/*@BeforeSuite
	public void ExtentReport() {
		//creating extent report without listeners
		ExtentReportNG.getReport();
		
	}*/
	
	

}
