package com.abhi.OrangeHRMTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.regrssion.OrangeHRM.ExtentReort.ExtentReportNG;
import com.regrssion.OrangeHRM.Generics.GenericsO;
import com.regrssion.OrangeHRM.Pages.ClearTripPage;


public class Listeners implements ITestListener{
	
	ClearTripPage dropdown;
	ExtentTest test;
	WebDriver driver;
	ExtentReports extent = ExtentReportNG.getReport();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test =  extent.createTest(result.getMethod().getMethodName());
	  }
	
	@Override
	public void onTestSuccess(ITestResult result) {
	    test.log(Status.PASS,"Test passed");
	  }

	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			dropdown = new ClearTripPage();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filepath =null;
		test.fail(result.getThrowable());
		
	
		/*try {
			//driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} */
		
		
		try {
			 filepath = dropdown.GetScreenShot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
		//result.getEndMillis();
	  }

	 
	@Override
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	
	@Override
	public void onStart(ITestContext context) {
	    // not implemented
	  }

	
	@Override
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }	
}
