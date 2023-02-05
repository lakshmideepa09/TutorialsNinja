package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {  
	
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	
	
    @FindBy(xpath=("//a[normalize-space()='Login']"))
	private WebElement loginOption;

    @FindBy(xpath= "//a[normalize-space()='Register']")
    private WebElement registerOption;
    
    
    @FindBy(name="search")
    private WebElement searchBoxField;
    
    
    
    @FindBy(xpath=("//button[@class='btn btn-default btn-lg']"))
    private WebElement searchButton;
    
   
    public HomePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
     	
    }
    
    //Actions
    public void clickOnMyAccount() {
    	
    	myAccountDropMenu.click();
    }
    //	public void	 selectLoginOption()
    public LoginPage selectLoginOption()
    	{
    		loginOption.click();	
    	return new 	LoginPage(driver);
    			
    }
    
    
    //	public void	 selectRegisterOption( ) 
    public RegisterPage selectRegisterOption( ) 
    {
    	
    		registerOption.click();	
    	return new RegisterPage(driver);
    }
    
    //combining myaccountdropmenu and selectregisteroption 
  public RegisterPage navigateToRegisterPage() {  	
	  myAccountDropMenu.click();
	  registerOption.click();	
  	return new RegisterPage(driver);
  }
    
    public void enterProductNameIntoSearchBoxField(String productText) {
    	searchBoxField.sendKeys(productText);
    }
   //  public void clickOnSearchButton() 
    public SearchPage clickOnSearchButton() {
    	
    	searchButton.click();
    	return new SearchPage(driver);
    }
 public SearchPage searchForAProduct(String productText ) {
 searchBoxField.sendKeys(productText);
 searchButton.click();
	return new SearchPage(driver);
}
}
