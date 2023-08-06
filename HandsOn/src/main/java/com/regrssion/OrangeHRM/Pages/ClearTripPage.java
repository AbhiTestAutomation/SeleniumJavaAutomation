package com.regrssion.OrangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.beust.jcommander.Parameter;
import com.regrssion.OrangeHRM.Generics.GenericsO;
import com.regrssion.OrangeHRM.webdriver.MyWebDriver;

public class ClearTripPage extends GenericsO {
	
	@FindBy(xpath="//div[@class='field-1 flex flex-middle p-relative pr-4 w-100p ']/input")
	private WebElement fromCity;
	
	@FindBys(@FindBy(xpath="//div[@class='dropdown p-absolute t-13 ln-1 w-100p']/ul/li/div/div[2]/p"))
	private List <WebElement> fromCityList;
	
	@FindBy(xpath="//div[@class='field-2 flex  flex-middle p-relative pr-4 w-100p ']/input")
	private WebElement toCity;
	
	@FindBys(@FindBy(xpath="//div[@class='dropdown p-absolute t-13 ln-1 w-100p']/ul/li/div/div[2]/p"))
	private List <WebElement> toCityList;
	
	@FindBy(xpath="//span[@class='fw-600 fs-4 lh-2 flex flex-middle']")
	private WebElement searchFlight;
	
	@FindBy(xpath="//div[@class='fs-4 fw-500 c-inherit flex flex-nowrap ml-4']")
	private WebElement toDate;
	
	@FindBy(xpath="//div[@class='DayPicker-Month'][1]/div[3]/div[4]/div[4]")
	private WebElement selectDate;
	
	@FindBy(xpath="//footer[@class='footer']/div[3]/div/div/div/div[2]/div/ul/li[2]/a")
	private WebElement career;
	
	String SelectFromCity = "Naur";
	String SelectToCity = "Pune";
	
	public ClearTripPage() throws Exception {
		
		PageFactory.initElements(driver,this);
	}
	
	public String SelectFromCity(String Fcity) throws InterruptedException {
		SendKeysToWebElement(fromCity,Fcity);
		Thread.sleep(500);
		
		ClickWebelement(fromCity);
		
		String currentOption = null;
		//System.out.println("fromCityList");
		for(WebElement city:fromCityList) {
			currentOption = city.getText();
			//System.out.println("CurrentOption"  + currentOption);
			if(currentOption.contains(SelectFromCity)) {
				//System.out.println("Mycity" + city);
				ClickWebelement(city);
				break;
			}
		}
		Assert.assertEquals(SelectFromCity, currentOption);
		return Fcity;
		
	}
	
	public String SelectToCity(String Tcity) throws InterruptedException {
		SendKeysToWebElement(toCity,Tcity);
		Thread.sleep(500);
		ClickWebelement(toCity);
		//System.out.println("toCityList");
		for(WebElement city:toCityList) {
			String currentOption = city.getText();
			////System.out.println("CurrentOption"  + currentOption);
			if(currentOption.contains(SelectToCity)) {
				//System.out.println("Mycity" + city);
				ClickWebelement(city);
				break;
			}
		}
		
		return Tcity;
	}
	
	public void SearchFlight() throws InterruptedException {
		ClickWebelement(toDate);
		MouseHoverAndClick(selectDate);
		//ClickWebelement(selectDate);
		//Thread.sleep(10);
		ClickWebelement(searchFlight);
		
	}
	
	public void bookFlight() throws InterruptedException {
		System.out.println("i ama here scrolling");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(10);
	}
	
	public void scrollWebpage() throws InterruptedException {
		//Thread.sleep(500);
		waitImplicitly(50);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//This will scroll the page till the element is found	
		js.executeScript("arguments[0].scrollIntoView(true);",career);
		ClickWebelement(career);
		
		/*This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        * // This  will scroll down the page by  1000 pixel vertical.	
        	js.executeScript("window.scrollBy(0,1000)");
        *
        */
		
	}
	

}
