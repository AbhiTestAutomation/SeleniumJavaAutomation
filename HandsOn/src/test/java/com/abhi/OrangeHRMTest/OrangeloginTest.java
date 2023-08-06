package com.abhi.OrangeHRMTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.regression.amazon.generics.Generics;
import com.regrssion.OrangeHRM.Pages.OrangeLoginPage;
import com.regrssion.OrangeHRM.Pages.OrangePIMPage;
import com.regrssion.OrangeHRM.Pages.OrangeUpdateDetails;

public class OrangeloginTest {
	public Generics generics;
	public OrangeLoginPage login;
	public OrangePIMPage pimpage;
	public OrangeUpdateDetails update;
	public String EnableSwitch = "No";
	public String nationlity = "Indian";
	
	
	@Test(priority=1)
	public void LaunchApp() throws IOException {
		generics = new Generics();
		generics.LaunchApplication();
	}
	
	@Test(priority=2)
	public void Login() throws IOException {
		login = new OrangeLoginPage();
		String title = login.loginAction();
		Assert.assertEquals(title, "OrangeHRM");
		
	}
	
	@Test(priority=3)
	public void PIMpage() {
		pimpage = new OrangePIMPage();
		//System.out.println("inside pimpage");
		pimpage.GotoPIMPage();
		pimpage.AddEmployee(EnableSwitch);
		//pimpage.UpdatePersonalDetails();
		
	}
	

	@AfterTest
	public void closewindow() {	
		generics.teardown();
	}
		

}
