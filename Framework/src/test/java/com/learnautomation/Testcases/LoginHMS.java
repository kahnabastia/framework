package com.learnautomation.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.Baseclass;
import com.learnautomation.pages.LoginPage;

public class LoginHMS extends Baseclass {
	
	
	@Test
	public void loginApp() {
		reports.createTest("Log in to HMS");
		
		LoginPage logpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Login to HMS");
		logpage.logintoHMS(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		
		logger.pass("Test Success");
	}

}
