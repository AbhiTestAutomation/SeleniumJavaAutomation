package com.regrssion.OrangeHRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.regression.amazon.generics.Generics;

public class OrangePIMPage extends Generics {

		@FindBy(xpath="//div[@id='app']//div[1]/div[1]/aside/nav/div[2]/ul/li[2]")
		private WebElement PIMClick;
	
		@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
		private WebElement AddEmp;
		
		@FindBy(xpath="//input[@name='firstName']")
		private WebElement Firstname;
		
		@FindBy(xpath="//input[@name='middleName']")
		private WebElement Middlename;
		
		@FindBy(xpath="//input[@name='lastName']")
		private WebElement Lastname;
		
		@FindBy(xpath="//div[@class='orangehrm-employee-form']/div/div[2]/div/div/div[2]/input")
		private WebElement EmployeeID;
		
		@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
		private WebElement Btn_Save;
		
		@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
		private WebElement Btn_Cancle;
		
		@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
		private WebElement Switch_Input;
		
		@FindBy(xpath="//div[@class='orangehrm-employee-form']/div[3]/div/div/div/div[2]/input")
		private WebElement Username;
		
		@FindBy(xpath="//div[@class='oxd-form-row user-password-row']/div/div[1]/div[1]/div[2]/input")
		private WebElement PassWord;
		
		@FindBy(xpath="//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div[2]/input")
		private WebElement ConfirmPassword;
		
		public OrangePIMPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void GotoPIMPage() {
			System.out.println("clicking on pimpage");
			WaitForWebElement(PIMClick, 20);
			MouseHoverAndClick(PIMClick);
		}
			
		
		public void AddEmployee(String SwithEnable) {
			
			WaitForWebElement(AddEmp,20);
			MouseHoverAndClick(AddEmp);
			SendKeysWebElement(Firstname,"Avni");
			SendKeysWebElement(Middlename,"Manoj");
			SendKeysWebElement(Lastname,"Bagde");
			SendKeysWebElement(EmployeeID,"6589");
			
			if(SwithEnable.equals("Yes")) {
				ClickOnWebElement(Switch_Input,10);
				SendKeysWebElement(Username,"AvaniMB");
				SendKeysWebElement(PassWord,"Avanimb123");
				SendKeysWebElement(ConfirmPassword,"Avanimb123");
				
			}
			
			ClickOnWebElement(Btn_Save,10);
			
		}

}

