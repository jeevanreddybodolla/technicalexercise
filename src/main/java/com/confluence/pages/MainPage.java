package com.confluence.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.confluence.utils.Wait;

public class MainPage extends Pages{

	public MainPage(WebDriver driver)
	{
		super(driver);	
	}
	
	/*
	 * For Elements that encounter Stale Element 
	 */
	final private static String titletext_id = "title-text";
	final private static String maincontent_id = "main-content";
	
	@FindBy(how = How.ID, using = titletext_id)
    private static WebElement titletext;
	
	@FindBy(how = How.ID, using = maincontent_id)
    private static WebElement maincontent;
	
	@FindBy(how = How.ID, using = "action-menu-link")
    private static WebElement actionmenulink;

	@FindBy(how = How.ID, using = "action-remove-content-link")
	private static WebElement actionremovecontentlink;
	
	@FindBy(how = How.ID, using = "confirm")
	private static WebElement confirmdelete;
	
	@FindBy(how = How.ID, using = "content-metadata-page-restrictions")
	private static WebElement pagerestrictions;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='tipsy-inner']")
	private static WebElement tooltip;
	
	
	public String getPageRestrictionTitle()
	{
		Actions builder=new Actions(driver);
		Wait.waitForelementToBeClickable(driver, pagerestrictions);
		builder.moveToElement(pagerestrictions).perform();
		Wait.waitForElementToBeVisible(driver, tooltip);
		return tooltip.getText();
	}
	
	public static boolean validatePageTitle(WebDriver driver, String title)
	{
		try{
			Wait.waitForElementToBeVisible(driver, titletext);
			return titletext.getText().equals(title);
		}
		catch(StaleElementReferenceException e)
		{
			return driver.findElement(By.id(titletext_id)).getText().equals(title);
		}
	}
	
	public static boolean validatePageBody(WebDriver driver, String body)
	{
		try{
			Wait.waitForElementToBeVisible(driver, maincontent);
			return maincontent.getText().equals(body);
		}
		catch(StaleElementReferenceException e)
		{
			return driver.findElement(By.id(maincontent_id)).getText().equals(body);
		}
	}
	 
	public static void clickPageRestrictionsButton(WebDriver driver)
	{
		pagerestrictions.click();
	}
	
	public static void deleteDisplayedPage(WebDriver driver)
	{		
		actionmenulink.click();
		actionremovecontentlink.click();
		Wait.WaitForPageLoad(driver);
		confirmdelete.click();
	}
	
	public static String BrowserTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public static boolean IsHomePageLoaded(WebDriver driver)
    {
        return driver.getTitle().equals("Dashboard - Confluence");
    }
	
	
}
