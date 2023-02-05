package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="//input[@name='email']")
	 private WebElement emailAdressField ;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement  emailPasswordNoMatchingWarning;
	
	
	
	
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	//Actions
	public void enterEmailAdress(String emailText) {
				emailAdressField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
		//public void clickOnLoginButton() 
	public AccountPage clickOnLoginButton()
	
	{
			LoginButton.click();
			return new AccountPage(driver); //return type to accountpage
		}
	
	public AccountPage login(String emailText,String passwordText) {
		emailAdressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		
		LoginButton.click();
		return new AccountPage(driver); //return object of accountpage
		
		
	}
	public String retrieveEmailPasswordNotMatchingMessageText() {
		String warningText=emailPasswordNoMatchingWarning.getText();
		return warningText;
	}
		
	}
	
	
	

