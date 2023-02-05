package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateExtentReport() throws IOException {
	//instaed of void retuen type will be ExtentReports	
	ExtentReports extentReport=new ExtentReports();	
	File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
	
	//somany extentreports will be there so go to extentreports.com n click on docs n click version 5 n click java n click reporters
	//cpoy ExtentSparkReporter n paste here
	//ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");	
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);	
	//using SparkReporter we can add some qualifications
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("TutorialsNinja Test Automation Results");
	sparkReporter.config().setDocumentTitle("TN Automation Report");
    sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
    extentReport.attachReporter(sparkReporter);
    //to get additional information like path of URL,browser name from config.properties into ExtentReport
    Properties configProp=new Properties();    
    File configPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
    try {
    
    FileInputStream fisConfigProp=new FileInputStream(configPropFile);
    configProp.load(fisConfigProp);
    }catch(Throwable e) {
    	e.printStackTrace();
    }
    extentReport.setSystemInfo("Application URL",configProp.getProperty("url")); //"url" alphabets should copy from config.properties
    extentReport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));//copy from congig.properties
    extentReport.setSystemInfo("Email",configProp.getProperty("validEmail"));
    extentReport.setSystemInfo("Password",configProp.getProperty("validPassword"));
    extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
    extentReport.setSystemInfo("User Name",System.getProperty("user.name"));
    extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
    
    return extentReport;//return type will be ExtentReports
	}

}
