package com.confluence.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.confluence.utils.Wait;

public class CreateTemplateDialogPage extends Pages{

	public CreateTemplateDialogPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "(.//*[@class='template-name'])[contains(.,'Blank page')]")
	private static WebElement blankpage;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='create-dialog-create-button aui-button aui-button-primary']")
	private static WebElement createbutton;
	
	public static void clickBlankPage(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, blankpage);
		blankpage.click();
	}
	
	public static void clickCreateButton(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, createbutton);
		createbutton.click();
	}
			
}
