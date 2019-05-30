package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement passw;
	@FindBy(xpath="//submit") WebElement logbutton;
	
	public void logintoHMS(String usernameApplication,String passwordApplication){
			uname.sendKeys(usernameApplication);
			passw.sendKeys(passwordApplication);
			logbutton.click();
	}
}
