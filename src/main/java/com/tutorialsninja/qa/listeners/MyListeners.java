package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;
//in pom.xml we have to change scope of testng to compile to imprt listeners to whole project
public class MyListeners implements ITestListener{
	
	ExtentReports extentReport;
	ExtentTest extentTest;
//right click on ITestListener n click on open declaration u can see listeners page	
//	select ITestListener click on source near edit n then click on override/importn then select what u want n finish then all these will appear
	
//in testng.xml u have to create path for listeners to connect with the project  then only it will excute the messages
	//so run thru testng.xml then only listeners will be activated
	//dont run individual test like login,register,search seperately bkz listeners class is not invoked to tests seperately
	
	@Override //when execution of project test started
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	//	System.out.println("Execution of Project Tests Started");
	//	ExtentReports extentReport	=ExtentReporter.generateExtentReport();
		try {
			extentReport=ExtentReporter.generateExtentReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		String testName=result.getName();
		//ExtentTest extentTest = extentReport.createTest(testName);
		extentTest = extentReport.createTest(testName); //ExtentTest made globally
		extentTest.log(Status.INFO,testName+"started executing" );//logging in ExtentReport
	//	System.out.println(testName+"started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		String testName=result.getName();
		//ExtentTest extentTest = extentReport.createTest(testName);// in report we r creating test
		extentTest.log(Status.PASS,testName+"got successfully executed"); // we r logging into report
		//System.out.println(testName+"got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String testName=result.getName();
		//ExtentTest extentTest = extentReport.createTest(testName);
		//extentTest.log(Status.INFO,testName+"got failed");
		
				//System.out.println("Screenshot taken");
			//to take screenshot				
				//to retrieve the driver by using result
				WebDriver driver=null;
				
		 try {
			driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//calling screenshot method from utilities
				String destinationScreenshotPath =Utilities.captureScreenshot(driver, result.getName());
				//to add screenshot to extentreport
				extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
				extentTest.log(Status.INFO,result.getThrowable() );
				
				//System.out.println(result.getThrowable());
				extentTest.log(Status.FAIL,testName+"got failed");
		//System.out.println(testName+"got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		String testName=result.getName();
		//System.out.println(testName+"got skipped");
		//System.out.println(result.getThrowable());
		extentTest.log(Status.INFO,result.getThrowable() );
		extentTest.log(Status.SKIP,testName+"got skipped");
	}


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onFinish(context);
		//System.out.println("Execution of Project Tests is finished");
		extentReport.flush(); //if i dont flush all the reports wont be created in the path which is extentreport.html
		
		//getting path of ExtentREport
		String pathOfExtentReport=System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
		 try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
