package com.tutorialninja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {
	//making searchPage and HomePage global
	SearchPage searchPage;
	 HomePage homePage;
	 
	 
	public SearchTest() {
		super();
	}
	

	
	public WebDriver driver;
	@BeforeMethod()
	public void setup() {
		
			
		    driver = initializingTheBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		    homePage=new HomePage(driver);
			
		}
		
	@AfterMethod()
	
	public void tearDown() {
		driver.quit();
	     }
	@Test(priority=1)
	public void verifySearchWithValidProduct() throws InterruptedException {	
		
		//HomePage homePage=new HomePage(driver);
		///homePage.enterProductNameIntoSearchBoxField(dataProp.getProperty("validProduct"));		
			
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		Thread.sleep(3000);
		//homePage.clickOnSearchButton();
		/// searchPage =homePage.clickOnSearchButton();//return type is search page
		//WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
		//JavascriptExecutor js=(JavascriptExecutor)driver; //not able to click so using javascriptExecutor to click button
	//	js.executeScript("arguments[0].click();",button);
		// SearchPage     searchPage=new SearchPage(driver);//return type is searchpage
	searchPage=homePage.searchForAProduct(dataProp.getProperty("validProduct"));
        Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(),"Valid product  HP is not displayed in the search results ");

}
	
	@Test(priority=2)
	public void verifySearchWithInValidProduct() throws InterruptedException {	
		//HomePage homePage=new HomePage(driver);
		///homePage.enterProductNameIntoSearchBoxField(dataProp.getProperty("invalidProduct"));		
			
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		Thread.sleep(3000);
		//homePage.clickOnSearchButton();
		/// searchPage =homePage.clickOnSearchButton();
		 searchPage=homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));		
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     	//	WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
	//	JavascriptExecutor js=(JavascriptExecutor)driver; //not able to click so using javascriptExecutor to click button
	//	js.executeScript("arguments[0].click();",button);
		//SearchPage searchPage=new SearchPage(driver);
		///String actualSearchMessage=searchPage.retrieveNoProductMessageText();
	//String actualSearchMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		///Assert.assertEquals(actualSearchMessage,dataProp.getProperty("NoProductTextInSearchMessage"),"No product in search results is not displayed");
	//after adding listeners to check msg of test failed
		 ////	Assert.assertEquals(searchPage.retrieveNoProductMessageText(),dataProp.getProperty("NoProductTextInSearchMessage"),"No product in search results is not displayed");
	////to fail the test intentionally
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(),"abcd","No product in search results is not displayed");
		
		
	}

	////to check skipped message after invoking listeners
	///it skipps bkx test3 is depending on test1 and test 2.if any one test fails then test3 will be skipped 
	@Test(priority=3,dependsOnMethods= {"verifySearchWithValidProduct","verifySearchWithInValidProduct"} )
	
	////@Test(priority=3)
	public void verifySearchWithoutAnyProduct()  {	
		//HomePage homePage=new HomePage(driver);
		//homePage.clickOnSearchButton();
		 searchPage =homePage.clickOnSearchButton();
	//	driver.findElement(By.name("search")).sendKeys("");
		
		//WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
	//	JavascriptExecutor js=(JavascriptExecutor)driver; //not able to click so using javascriptExecutor to click button
		//js.executeScript("arguments[0].click();",button);
		
		
		//SearchPage searchPage=new SearchPage(driver);
		///String actualSearchMessage=searchPage.retrieveNoProductMessageText();
	//String actualSearchMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
	
	///Assert.assertEquals(actualSearchMessage,dataProp.getProperty("NoProductTextInSearchMessage"),"No product in search results is not displayed");
	Assert.assertEquals(searchPage.retrieveNoProductMessageText(),dataProp.getProperty("NoProductTextInSearchMessage"),"No product in search results is not displayed");
	
	}
		
		
}