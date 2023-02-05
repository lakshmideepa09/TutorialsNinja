package com.tutorialninja.testcases;



import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base{
	LoginPage loginPage; // making login page as global variable
	
	public LoginTest() {
		
		super();             //base class constructor is super class for login
	}
	
	////making driver public to be accepted by listeners
	public WebDriver driver; //creating driver globally which can be used by all testcases
	
	//common code should be given in  before method
	
	@BeforeMethod               
	public void setup()
	{			
		
		driver = initializingTheBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();	
		//homepage.selectLoginOption();
	    //driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	 loginPage= homepage.selectLoginOption();//make loginpage global
	}
	
	@AfterMethod //executes after each test whether passed/failed
	
	public void tearDown() 
	{
		driver.quit();
	}
	
	
@Test(priority=1,dataProvider="validCredentialsSupplier")  //dataprovider name 
	public void verifyLoginWithValidCredentials(String email, String password)
{
	//LoginPage loginPage= new LoginPage(driver);// after declaring globally norequired this line
	
	//loginPage.enterEmailAdress(email);	 
	//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
	//loginPage.enterPassword(password);
	AccountPage accountPage = loginPage.login(email,password);
	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	//loginPage.clickOnLoginButton();//linked with accountpage
	//driver.findElement(By.xpath("//input[@value='Login']")).click();
	//AccountPage accountPage=loginPage.clickOnLoginButton(); //login button return type is accountpage
	
	//AccountPage accountPage=new AccountPage(driver);
	
	Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
		
	
	
}
	
@DataProvider(name="validCredentialsSupplier")
public Object[][] supplyTestData() {
	
	Object[][] data= Utilities.getTestDataFromExcel("Login");
			
	return data;
}



	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials()
	{
		
		loginPage.login(Utilities.generateEmailWithTimeStamp(),dataProp.getProperty("invalidPassword"));
		//LoginPage loginPage = new LoginPage(driver);
		//loginPage.enterEmailAdress(Utilities.generateEmailWithTimeStamp());
	
	//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//loginPage.enterPassword(dataProp.getProperty("invalidPassword"));	
	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		//loginPage.clickOnLoginButton();	
	//driver.findElement(By.xpath("//input[@value='Login']")).click();
//	String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingMessageText();
	//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	//String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
	
	//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning message is not Displayed");
	Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning message is not Displayed");
	
}
	
	@Test(priority=3)
	public void verifyLoginwithInValidEmailandValidPasswordCredentials()
	{
		loginPage.login(Utilities.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));
	
     //	LoginPage loginPage = new LoginPage(driver);
	//loginPage.enterEmailAdress(Utilities.generateEmailWithTimeStamp());
	//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
	
	//loginPage.enterPassword(prop.getProperty("validPassword"));
	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validPassword"));
	
	//loginPage.clickOnLoginButton();
	//driver.findElement(By.xpath("//input[@value='Login']")).click();
	String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingMessageText();
	//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
	
	Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning message is not Displayed");
	
	
	
}
	
	@Test(priority=4)
	public void verifyLoginwithValidEmailandInvalidPasswordCredentials()
	{
		
		loginPage.login(prop.getProperty("validEmail"),dataProp.getProperty("invalidPassword"));
		//LoginPage loginPage = new LoginPage(driver);
		//loginPage.enterEmailAdress(prop.getProperty("validEmail"));
	
	//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("validEmail"));
		//loginPage.enterPassword(dataProp.getProperty("invalidPassword"));		
	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		
		//loginPage.clickOnLoginButton();	
	//driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingMessageText();
	//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	String expectedWarningMessage="Warning: No match for E-Mail Address and/or Password.";
	
	Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning message is not Displayed");
	
	
}
	
	@Test(priority=5)
	public void verifyLoginwithoutProvidingCredentials()
	{

		//LoginPage loginPage = new LoginPage(driver);
		//loginPage.enterEmailAdress(prop.getProperty(""));
	
	//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("");
	
	//loginPage.enterPassword(dataProp.getProperty(""));	
	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
	
	loginPage.clickOnLoginButton();	
	//driver.findElement(By.xpath("//input[@value='Login']")).click();
	String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingMessageText();
	//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
	
	Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning message is not Displayed");
	
	
}
	
	//if continuosly giving valid email and password for 6 or more  times it shows error messages .so to generate invalid email we have to use this syntax

}
