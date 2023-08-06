package com.regrssion.OrangeHRM.ExtentReort;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReport() {
		
		//String timestamp = new java.text.SimpleDateFormat("yyyy.MM.dd.HH.mm.s").format(new Date());
		//String path = System.getProperty("user.dir") + "//Reports//report." +timestamp +".html";*/
		String path = System.getProperty("user.dir") + "//Reports//index.html";
		System.out.println(path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Result");
		reporter.config().setDocumentTitle("ClearTrip Test Result");
				
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		//extent.createTest(path); --> directly creating report in test without listeners
		return extent;
	}
}
