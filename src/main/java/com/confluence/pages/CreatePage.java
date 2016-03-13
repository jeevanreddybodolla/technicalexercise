package com.confluence.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.confluence.utils.Wait;

import junit.framework.Assert;

public class CreatePage extends Pages{
	
	public CreatePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = ".//*[@class='duplicate-title']")
	private static WebElement duplicateTitle;
	
	@FindBy(how = How.ID, using = "wysiwygTextarea_ifr")
    private static WebElement bodyframe;
	
	@FindBy(how = How.ID, using = "content-title")
    private static WebElement pageTitle;
	
	@FindBy(how = How.ID, using = "tinymce")
    private static WebElement pageBody;
	
	@FindBy(how = How.ID, using = "rte-button-publish")
    private static WebElement saveButton;
	
	public static void validateExistingPageTitle(WebDriver driver)
	{
		try{
			Wait.waitForExpectedCondition(driver, ExpectedConditions.visibilityOf(duplicateTitle));
			Assert.assertFalse("Duplicate Title detected", duplicateTitle.isDisplayed());
		}catch(NoSuchElementException|TimeoutException e){
			Assert.assertTrue(true);
		}
	}
	
	public static void createBlankPage(WebDriver driver, String title, String bodydesc)
	{
		
		Wait.WaitForPageLoad(driver);
		enterPageTitle(title);
		switchToFrame(driver);
		enterPageBody(bodydesc);
		switchToDefaultFrame(driver);
		savePage(driver);
		Wait.WaitForPageLoad(driver);
		validateExistingPageTitle(driver);
	}
	
	public static void enterPageTitle(String title)
	{
		pageTitle.sendKeys(title);		
	}
	
	public static void switchToFrame(WebDriver driver)
	{
		driver.switchTo().frame(bodyframe);
	}
	
	public static void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public static void enterPageBody(String bodydesc)
	{
		pageBody.sendKeys(bodydesc);
	}
	
	public static void savePage(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, saveButton);
		saveButton.click();
	}
	
	
		
}
