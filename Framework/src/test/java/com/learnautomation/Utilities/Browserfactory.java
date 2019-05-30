package com.learnautomation.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserfactory {
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURl) {
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if (browserName.equals("Firefox")) {
			
		}
        else if (browserName.equals("IE")) {
			
		}
        else {
			System.out.println("We do not support any browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
