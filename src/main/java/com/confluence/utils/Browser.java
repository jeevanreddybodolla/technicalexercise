package com.confluence.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	private static  WebDriver driver;
	
	public static WebDriver launchBrowser(String Browser)
	{
	
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();	
		}
		else if(Browser.equalsIgnoreCase("ie"))
		{
			driver = new InternetExplorerDriver(); 
		}
		
		driver.manage().window().maximize();
		
		return driver;
	}
		
	public static String Title()
	{
		return driver.getTitle(); 
	}
	
	public static void Close()
	{
		driver.quit();
	}
		
}
