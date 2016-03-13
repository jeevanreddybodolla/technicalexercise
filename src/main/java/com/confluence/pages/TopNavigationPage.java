package com.confluence.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.confluence.utils.Wait;

public class TopNavigationPage extends Pages{
	
	public TopNavigationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(how = How.ID, using = "create-page-button")
    private static WebElement createpagebutton;
	
	@FindBy(how = How.ID, using = "user-menu-link")
    private static WebElement usermenulink;
	
	@FindBy(how = How.ID, using = "logout-link")
    private static WebElement logoutlink;
	
	@FindBy(how = How.ID, using = "quick-create-page-button")
    private static WebElement quickCreateButton;
	
	public static void clickCreatePageButton(WebDriver driver)
	{
		createpagebutton.click();
		Wait.WaitForPageLoad(driver);
	}
	
	public static void logOut(WebDriver driver)
	{
		usermenulink.click();
		logoutlink.click();
		Wait.WaitForPageLoad(driver);
	}
		
}
