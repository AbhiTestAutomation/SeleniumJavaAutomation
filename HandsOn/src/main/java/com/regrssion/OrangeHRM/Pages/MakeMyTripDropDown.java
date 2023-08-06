package com.regrssion.OrangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.regrssion.OrangeHRM.Generics.GenericsO;

public class MakeMyTripDropDown extends GenericsO{
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement username;

	@FindBy(xpath="//button[@class='capText font16']")
	private WebElement continueBtn;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='capText font16']")
	private WebElement loginBtn;
	
	@FindBy(id="fromCity")
	private WebElement FromCity;
	
	@FindBys(@FindBy(xpath="//ul[@class='react-autosuggest__suggestions-list']/li"))
	private List <WebElement> CityList;
	
	@FindBy(xpath="//input[@id=toCity]")
	private WebElement ToCity;
	
	@FindBy(xpath="//div[@class='imageSliderModal modal displayBlock modalLogin dynHeight personal']")
	private WebElement outside;
	
	public MakeMyTripDropDown() throws Exception {
		PageFactory.initElements(driver,this);
	}
	
	public void SelectCity() {
		/*SendKeysToWebElement(username,"lanjewar.abhilasha@gmail.com");
		ClickWebelement(continueBtn);
		SendKeysToWebElement(password,"MyTrip@2023");
		ClickWebelement(loginBtn);*/
		MouseHoverAndClick(outside);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", FromCity);
		//SendKeysToWebElement(FromCity,"Nag");
		//SendKeysToWebElement(FromCity,"Nag");
		
		System.out.println("City List:" + CityList);
		
	}
}	
