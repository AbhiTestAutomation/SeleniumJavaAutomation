package com.regrssion.OrangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.regrssion.OrangeHRM.Generics.GenericsO;

public class OrangeUpdateDetails extends GenericsO {

	@FindBy(xpath="//div[@id='app']/div/div[2]//div[@class='oxd-form-row'][3]/div[1]/div[1]/div/div[2]/div/div/div[1]")
	private WebElement Nationalities;
	
	@FindBy(xpath="//*[@id='app']/div/div[2]//div[@class='oxd-form-row'][3]/div/div[2]/div/div[2]/div[1]/div[1]/div[1]")
	private WebElement MaritalStatus;
	
	public OrangeUpdateDetails() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public void UpdateDetails() {
		
		System.out.println("hi i am here");
		ClickWebelement(MaritalStatus);
		//System.out.println("nat:"+Nationalities);
		//ystem.out.println("testdata:" + nationlity);
		/*for(WebElement Nationality:Nationalities) {
			
			System.out.println("nat inside :"+Nationality);
			if(Nationality.equals(nationlity)) {
				ClickWebelement(Nationality);
			}*/
		
	}

	
}
