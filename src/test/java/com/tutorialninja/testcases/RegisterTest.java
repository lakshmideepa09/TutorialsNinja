package com.tutorialninja.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	public RegisterTest() {
		super();
	}
	
	 public WebDriver driver;
	@BeforeMethod()
	public void setup() {
		
			
		    driver = initializingTheBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		    HomePage homepage= new HomePage(driver);
		    
		//	homepage.clickOnMyAccount();
		   // driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			//homepage.selectRegisterOption();//return type registerPage
			//driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			//registerPage=homepage.selectRegisterOption();
			registerPage=homepage.navigateToRegisterPage(); //combining click on my account and select register option
		}
	
	
	
	@AfterMethod()
	
	public void tearDown() {
		driver.quit();
	     }
	
	
	@Test(priority=1)
	
	public void verifyRegisterAnAccountWithMandatoryFields() {
		accountSuccessPage=registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilities.generateEmailWithTimeStamp(),dataProp.getProperty("telephoneNumber"),prop.getProperty("validPassword"));
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),dataProp.getProperty("accountSuccessfullyCreatedHeading")	,"Account Success Page Is Not Displayed");
		
	//RegisterPage registerPage=new RegisterPage(driver);//made globally
	///registerPage.enterFirstName(dataProp.getProperty("firstName"));
	//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(dataProp.getProperty("firstName"));	
	///registerPage.enterLastName(dataProp.getProperty("lastName"));
	//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(dataProp.getProperty("lastName"));	
	///registerPage.enterEmailAdress(Utilities.generateEmailWithTimeStamp());
	//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
	///registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
	//driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(dataProp.getProperty("telephoneNumber"));	
	///registerPage.enterPassword(prop.getProperty("validPassword"));	
	//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validPassword"));	
	///registerPage.enterConfirmPassword(prop.getProperty("validPassword"));	
	//driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(prop.getProperty("validPassword"));
	///registerPage.selectPrivacyPolicy();
//	driver.findElement(By.xpath("//input[@name='agree']")).click();
	//registerPage.clickOnContinueButton() ;
	//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	// accountSuccessPage= registerPage. clickOnContinueButton() ;
	//AccountSuccessPage accountSuccessPage=new AccountSuccessPage(driver);
		//String	actualSuccessHeading= accountSuccessPage.retrieveAccountSuccessPageHeading();
	//String actualSuccessHeading=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
//	Assert.assertEquals(actualSuccessHeading,dataProp.getProperty("accountSuccessfullyCreatedHeading")	,"Account Success Page Is Not Displayed");
	
}

@Test(priority=2)

public void verifyRegisterAnAccountWithAllFields() {
	
	accountSuccessPage=registerPage.registerWithAllFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilities.generateEmailWithTimeStamp(),dataProp.getProperty("telephoneNumber"),prop.getProperty("validPassword"));
	Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),dataProp.getProperty("accountSuccessfullyCreatedHeading")	,"Account Success Page Is Not Displayed");
	
	//RegisterPage registerPage=new RegisterPage(driver);
	///registerPage.enterFirstName(dataProp.getProperty("firstName"));
	//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(dataProp.getProperty("firstName"));	
	///registerPage.enterLastName(dataProp.getProperty("lastName"));
	//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(dataProp.getProperty("lastName"));	
	///registerPage.enterEmailAdress(Utilities.generateEmailWithTimeStamp());
//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
	///registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
//driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(dataProp.getProperty("telephoneNumber"));	
	///registerPage.enterPassword(prop.getProperty("validPassword"));	
//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validPassword"));
	///registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(prop.getProperty("validPassword"));
	///registerPage.selectYesNewsLetterOption();
   // driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();

   /// registerPage. selectPrivacyPolicy();
    //driver.findElement(By.xpath("//input[@name='agree']")).click();
   // registerPage. clickOnContinueButton() ;
  /// accountSuccessPage= registerPage. clickOnContinueButton() ;
    //driver.findElement(By.xpath("//input[@value='Continue']")).click();
    // AccountSuccessPage accountSuccessPage=new AccountSuccessPage(driver);//bkz return type is accountsuccesspage
   /// String	actualSuccessHeading= accountSuccessPage.retrieveAccountSuccessPageHeading();
   //String actualSuccessHeading=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
    /// Assert.assertEquals(actualSuccessHeading,dataProp.getProperty("accountSuccessfullyCreatedHeading")	,"Account Success Page Is Not Displayed");

}


@Test(priority=3)

public void verifyRegisterAnAccountWitAllFields() {
   //since on registerPage only so no need to write accountSuccessPage= o simply write registerPage.register
	registerPage.registerWithAllFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),prop.getProperty("validEmail"),dataProp.getProperty("telephoneNumber"),prop.getProperty("validPassword"));
	Assert.assertTrue(registerPage.retrieveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")),"Warning message regarding duplicate email adress is not displayed");

	//RegisterPage registerPage=new RegisterPage(driver);
	///registerPage.enterFirstName(dataProp.getProperty("firstName"));
	//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(dataProp.getProperty("firstName"));	
	///registerPage.enterLastName(dataProp.getProperty("lastName"));
	//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(dataProp.getProperty("lastName"));	
  ///	registerPage.enterEmailAdress(prop.getProperty("validEmail"));
//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("validEmail"));
	///registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
//driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(dataProp.getProperty("telephoneNumber"));	
	///registerPage.enterPassword(prop.getProperty("validPassword"));	
//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("validPassword"));
	///registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(prop.getProperty("validPassword"));
	///registerPage.selectYesNewsLetterOption();
//driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();

///registerPage. selectPrivacyPolicy();
//driver.findElement(By.xpath("//input[@name='agree']")).click();
///registerPage. clickOnContinueButton() ;
//driver.findElement(By.xpath("//input[@value='Continue']")).click();
///String actualWarning=registerPage.retrieveDuplicateEmailAddressWarning();
//String actualWarning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
///Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")),"Warning message regarding duplicate email adress is not displayed");

}

@Test(priority=4)

public void verifyRegisterAnAccountWitoutFillingAnyFields() {
	
	//RegisterPage registerPage=new RegisterPage(driver);
	registerPage. clickOnContinueButton() ;
//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
// /String actualPrivacyPolicyWarning=registerPage.retrievePrivacyPolicyWarning();
//String actualPrivacyPolicyWarning=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
///Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),"Warning message regarding duplicate email adress");
	Assert.assertTrue(registerPage.displayStatusOffWarningMesssages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"),dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning")));
	
	
	
	///Assert.assertTrue(registerPage.retrievePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")),"Warning message regarding duplicate email adress");

///String actualFirstNameWarning=registerPage.retrieveFirstNameWarning();
//String actualFirstNameWarning=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
///Assert.assertEquals(actualFirstNameWarning,dataProp.getProperty("firstNameWarning"),"FirstName Warning message is not displayed");


///String actualLastNameWarning=registerPage.retrieveLastNameWarning();
//String actualLastNameWarning=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
///Assert.assertEquals(actualLastNameWarning,dataProp.getProperty("lastNameWarning"),"LastName Warning message is not displayed");

///String actualEmailWarning=registerPage.retrieveEmailWarning();
//String actualEmailWarning=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
///Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailWarning"),"E-Mail Warning message is not displayed");

///String actualTelephoneWarning=registerPage.retrieveTelephoneWarning();
//String actualTelephoneWarning=driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
///Assert.assertEquals(actualTelephoneWarning,dataProp.getProperty("telephoneWarning"),"Telephone Warning message is not displayed");


///String actualPasswordWarning=registerPage.retrievePasswordWarning();
//String actualPasswordWarning=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
///Assert.assertEquals(actualPasswordWarning,dataProp.getProperty("passwordWarning"),"Password Warning message is not displayed");


}


}

