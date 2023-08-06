package com.abhi.OrangeHRMTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.regrssion.OrangeHRM.Pages.staleEleNscriptTimeout;

public class StaleTest {

	
	@Test
	public void runtest() throws IOException, InterruptedException {
		System.out.println("i am in runtest");
		staleEleNscriptTimeout.LaunchSite();
	}
	
}
