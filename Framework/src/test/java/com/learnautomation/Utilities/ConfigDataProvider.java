package com.learnautomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider() {
		File src=new File("./Config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
	      System.out.println("not able to load config file"+e.getMessage());
		}
	}
	public String getDataFromConfig(String keySearch) {
		return pro.getProperty(keySearch);
	}
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	public String getURL() {
		return pro.getProperty("qaURl");
				
	}
}
