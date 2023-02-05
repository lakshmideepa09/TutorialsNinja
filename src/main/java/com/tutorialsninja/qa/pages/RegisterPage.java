package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
WebDriver driver;	
	
@FindBy(xpath="//input[@name='firstname']")
	WebElement firstNameField;
	
@FindBy(xpath="//input[@name='lastname']")
 private WebElement lastNameField;

@FindBy(xpath="//input[@name='email']")
 private WebElement emailAdressField;

@FindBy(xpath="//input[@name='telephone']")
private WebElement TelephoneField;

@FindBy(xpath="//input[@name='password']")
private WebElement passwordField;

@FindBy(xpath="//input[@name='confirm']")
private WebElement passwordConfirmField;

@FindBy(xpath="//input[@name='agree']")
private WebElement privacyPolicyField;

@FindBy(xpath="//input[@value='Continue']")
private WebElement continueButton;

@FindBy(xpath=("//label[normalize-space()='Yes']//input[@name='newsletter']"))
private WebElement yesNewsLetterOption;

@FindBy(xpath=("//div[@class='alert alert-danger alert-dismissible']"))
private WebElement duplicateEmailAddressWarning;

@FindBy(xpath=("//div[@class='alert alert-danger alert-dismissible']"))
private WebElement privacyPolicyWarning;



@FindBy(xpath=("//input[@id='input-firstname']/following-sibling::div"))
private WebElement firstNameWarning;


@FindBy(xpath=("//input[@id='input-lastname']/following-sibling::div"))
private WebElement lastNameWarning;


@FindBy(xpath=("//input[@id='input-email']/following-sibling::div"))
private WebElement emailWarning;


@FindBy(xpath=("//input[@id='input-telephone']/following-sibling::div"))
private WebElement telephoneWarning;


@FindBy(xpath=("//input[@id='input-password']/following-sibling::div"))
private WebElement passwordWarning;


public RegisterPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
 	}

//Action
public void enterFirstName(String firstNameText) {
	firstNameField.sendKeys( firstNameText);
}
public void enterLastName(String lastNameText) {
	lastNameField.sendKeys(lastNameText);
}

public void enterEmailAdress(String emailText) {
	emailAdressField.sendKeys(emailText);
}
public void enterTelephoneNumber(String telephoneText) {
	TelephoneField.sendKeys(telephoneText);
}
public void enterPassword(String passwordText) {
passwordField.sendKeys(passwordText);
}
public void enterConfirmPassword(String passwordText) {
passwordConfirmField.sendKeys(passwordText);
}
public void selectPrivacyPolicy() {
  privacyPolicyField.click();
}
//public void clickOnContinueButton()
public AccountSuccessPage clickOnContinueButton()       {
continueButton.click();
return new AccountSuccessPage(driver); //return type is accountSuccessPage
}
public void selectYesNewsLetterOption() {
yesNewsLetterOption.click();
}
public String retrieveDuplicateEmailAddressWarning() {
String duplicateEmailAddressWarningText=duplicateEmailAddressWarning.getText();
return duplicateEmailAddressWarningText;
}

public String retrievePrivacyPolicyWarning() {
String privacyPolicyWarningText=privacyPolicyWarning.getText();
return privacyPolicyWarningText;

}
public String retrieveFirstNameWarning() {
String firstNameWarningText=firstNameWarning.getText();
return firstNameWarningText;

}
public String retrieveLastNameWarning() {
String lastNameWarningText=lastNameWarning.getText();
return lastNameWarningText;

}

public String retrieveEmailWarning() {
String emailWarningText=emailWarning.getText();
return emailWarningText;

}
public String retrieveTelephoneWarning() {
String telephoneWarningText=telephoneWarning.getText();
return telephoneWarningText;

}

public String retrievePasswordWarning() {
String passwordWarningText=passwordWarning.getText();
return passwordWarningText;
}

public AccountSuccessPage registerWithMandatoryFields(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText)
{
	firstNameField.sendKeys( firstNameText);
	lastNameField.sendKeys(lastNameText);
	emailAdressField.sendKeys(emailText);
	TelephoneField.sendKeys(telephoneText);
	passwordField.sendKeys(passwordText);
	passwordConfirmField.sendKeys(passwordText);
	 privacyPolicyField.click();
	 continueButton.click();
	 return new AccountSuccessPage(driver);
}
public AccountSuccessPage registerWithAllFields(String firstNameText,String lastNameText,String emailText,String telephoneText,String passwordText)
{
	firstNameField.sendKeys( firstNameText);
	lastNameField.sendKeys(lastNameText);
	emailAdressField.sendKeys(emailText);
	TelephoneField.sendKeys(telephoneText);
	passwordField.sendKeys(passwordText);
	passwordConfirmField.sendKeys(passwordText);
	yesNewsLetterOption.click();
	 privacyPolicyField.click();
	 continueButton.click();
	 return new AccountSuccessPage(driver);
}
public boolean displayStatusOffWarningMesssages(String expectedPrivacyPolicyWarning,String expectedFirstNameWarning,String expectedLastNameWarning,String expectedEmailWarning,String expectedTelephoneWarning,String expectedPasswordWarning)
{
//String actualPrivacyPolicyWarningText=privacyPolicyWarning.getText();

//boolean privacyPolicyWarningStatus=actualPrivacyPolicyWarningText.contains(expectedPrivacyPolicyWarning);
boolean privacyPolicyWarningStatus=privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarning);

//String actualFirstNameWarningText=firstNameWarning.getText();
//boolean firstNameWarningStatus=actualFirstNameWarningText.contains(expectedFirstNameWarning);
boolean firstNameWarningStatus=firstNameWarning.getText().equals(expectedFirstNameWarning);

//String actualLastNameWarningText=lastNameWarning.getText();
//boolean lastNameWarningStatus=actualLastNameWarningText.contains(expectedLastNameWarning);
boolean lastNameWarningStatus=lastNameWarning.getText().equals(expectedLastNameWarning);
//String actualEmailWarningText=emailWarning.getText();
//boolean emailWarningStatus=actualEmailWarningText.contains(expectedEmailWarning);
boolean emailWarningStatus=emailWarning.getText().equals(expectedEmailWarning);
//String actualTelephoneWarningText=telephoneWarning.getText();
//boolean telephoneWarningStatus=actualTelephoneWarningText.contains(expectedTelephoneWarning);
boolean telephoneWarningStatus=telephoneWarning.getText().equals(expectedTelephoneWarning);

//String actualPasswordWarningText=passwordWarning.getText();
//boolean passwordWarningStatus=actualPasswordWarningText.contains(expectedPasswordWarning);
boolean passwordWarningStatus=passwordWarning.getText().equals(expectedPasswordWarning);
return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;






}
}












