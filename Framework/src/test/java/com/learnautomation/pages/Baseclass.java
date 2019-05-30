package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.Utilities.Browserfactory;
import com.learnautomation.Utilities.ConfigDataProvider;
import com.learnautomation.Utilities.ExcelDataProvider;
import com.learnautomation.Utilities.Helper;

public class Baseclass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		Reporter.log("getting up test ready", true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"Reports/HMS"+Helper.getCurrentDateTime()+".html"));
		reports=new ExtentReports();
		reports.attachReporter(extent);
		Reporter.log("setting done test can be started", true);
	}
	@AfterClass
	public void setup() {
		driver=Browserfactory.startApplication(driver, config.getBrowser(), config.getURL());
	}
	@BeforeClass	
	public void tearDown() {
		Browserfactory.quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test passed", 	MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			
		}
		reports.flush();
	}


}
