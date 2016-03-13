package com.confluence.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.confluence.utils.Wait;

public class LogoutPage extends Pages{

	public LogoutPage(WebDriver driver)
	{
		super(driver);	
	}
	
	@FindBy(how = How.ID, using = "logout")
    private static WebElement logout;
	
	@FindBy(how = How.ID, using = "cancel")
    private static WebElement cancel;
	
	public static void confirmLogout(WebDriver driver)
	{
		logout.click();
		Wait.WaitForPageLoad(driver);
	}
	
	public static void cancelLogout()
	{
		cancel.click();
	}
	
}
