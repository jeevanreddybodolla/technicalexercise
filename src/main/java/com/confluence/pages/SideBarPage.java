package com.confluence.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.confluence.utils.Wait;

public class SideBarPage extends Pages{

	public SideBarPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(how = How.XPATH, using = ".//*[@class='plugin_pagetree_children_list']")
	private static WebElement pagetree;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='sidebar-spaces']//*[text() = 'Test']")
    private static WebElement myspacesTest;
    
	@FindBy(how = How.XPATH, using = "(.//*[@id='sidebar-spaces']//*[@class='aui-nav-item-label'])[1]")
    private static WebElement firstspace;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='ia-secondary-content']//*[text() = '2016-03-09 Meeting notes']")
    private static WebElement editrestrictionPageTest;
	
	@FindBy(how = How.XPATH, using = ".//*[@data-macro-name='pagetree']//li[1]//*[@class='plugin_pagetree_children_span']")
    private static WebElement editrestrictionPageFirst;
	
	public static void clickOnAPageInThePageTree(WebDriver driver, String myPage)
	{
		Wait.waitForelementToBeClickable(driver, editrestrictionPageFirst);
		WebElement thespace = driver.findElement(By.xpath(".//*[@class='ia-secondary-content']//*[text() = '"+myPage+"']"));
		thespace.click();
	}
	
	public static void clickASpace(WebDriver driver, String mySpace)
	{
		Wait.waitForelementToBeClickable(driver, firstspace);
		WebElement thespace = driver.findElement(By.xpath(".//*[@id='sidebar-spaces']//*[text() = '"+mySpace+"']"));
		thespace.click();
	}
	
	public static void clickFirstPageinPageTree(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, firstspace);
		editrestrictionPageFirst.click();
	}
	
	public static void clickMyFirstSpace(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, firstspace);
		firstspace.click();
	}
	
	public static void clickMySpaceTest(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, myspacesTest);
		myspacesTest.click();
	}
	
	public static void clickTestPageForEditRestriction(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, editrestrictionPageTest);
		editrestrictionPageTest.click();
	}
	
	public static boolean validatePageNameInPageTree(WebDriver driver, String body)
	{
		Wait.waitForelementToBeClickable(driver, pagetree);
		return pagetree.getText().contains(body);
	}
		
}
