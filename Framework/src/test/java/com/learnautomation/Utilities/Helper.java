package com.learnautomation.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshots(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"./Screenshots/"+ getCurrentDateTime() +".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
		} catch (IOException e) {
			System.out.println("unable to get screenshot"+e.getMessage());
		}
		return screenshotpath;
		
	}
	public static String getCurrentDateTime() {
		DateFormat df=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			Date dt=new Date();	
			return df.format(dt);
	}
	
}
