package com.regrssion.OrangeHRM.Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.regression.amazon.generics.Generics;

public class OrangeLoginPage extends Generics{
	
	@FindBy(xpath="(//input[@name='username'])")
	private WebElement Username;
	
	@FindBy(xpath=("//input[@name='password']"))
	private WebElement Password;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	private WebElement LoginBtn;
	
	public OrangeLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String loginAction() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/configuration/configuration.properties");
		Properties prop = new Properties();
		prop.load(fis);
		SendKeysWebElement(Username,prop.getProperty("username")); //driver.Username.sendkeys("Admin");
		SendKeysWebElement(Password,prop.getProperty("password"));
		ClickOnWebElement(LoginBtn,10);
		String title = driver.getTitle();
		return title;
	}
	
		

}
