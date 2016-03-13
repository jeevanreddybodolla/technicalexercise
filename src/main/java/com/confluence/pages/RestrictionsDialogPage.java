package com.confluence.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.confluence.utils.Wait;

public class RestrictionsDialogPage extends Pages {

	public RestrictionsDialogPage(WebDriver driver) 
	{
		super(driver);
	}
		
	@FindBy(how = How.ID, using = "s2id_page-restrictions-dialog-selector")
	private static WebElement pagerestrictionsDropDown;

	@FindBy(how = How.ID, using = "s2id_restrictions-dialog-auto-picker")
	private static WebElement pagerestrictionsSearchBox;
	
	@FindBy(how = How.ID, using = "page-restrictions-add-button")
	private static WebElement pagerestrictionsAddButton;

	@FindBy(how = How.ID, using = "page-restrictions-dialog-save-button")
	private static WebElement pagerestrictionsSaveButton;

	@FindBy(how = How.ID, using = "page-restrictions-dialog-close-button")
	private static WebElement pagerestrictionsCloseButton;
	
	@FindBy(how = How.XPATH, using = ".//*[@data-username='admin']//*[@class='user-avatar-title']")
	private static WebElement adminuser;
	
	@FindBy(how = How.XPATH, using = ".//*[@data-username='admin']//*[@class='restrictions-dialog-entity-permission-wrapper']")
	private static WebElement adminuserpermission;
	
	@FindBy(how = How.ID, using = "page-restrictions-permission-selector")
	private static WebElement pagepermissionDropDown;
	
	@FindBy(how = How.ID, using = "select2-drop")
	private static WebElement pagerestrictionsDropDown_inner;
		
	public boolean verifyOptionInDropDown(WebDriver driver, String option)
	{
		Select dropdown = new Select(pagepermissionDropDown);
		List<WebElement> options = dropdown.getOptions();
		for(WebElement e: options)
		{
			if(option.equalsIgnoreCase(e.getText())) return true;
		}		
		return false;
	}
	
	public void clickSave()
	{
		Wait.waitForelementToBeClickable(driver, pagerestrictionsSaveButton);
		pagerestrictionsSaveButton.click();
	}
	public boolean verifyAdminUserAccess(WebDriver driver, String permission)
	{
		Wait.waitForelementToBeClickable(driver, adminuserpermission);
		return adminuserpermission.getText().equalsIgnoreCase(permission);
	}
	
	public static boolean verifyAdminUser(WebDriver driver, String name)
	{
		Wait.waitForelementToBeClickable(driver, adminuser);
		return adminuser.getText().contains(name);
	}
	
	public void selectFromPageRestrictionsDropDown(WebDriver driver, String value)
	{
		Wait.waitForelementToBeClickable(driver, pagerestrictionsDropDown);
		pagerestrictionsDropDown.click();
		WebElement maindropdownValue = driver.findElement(By.xpath(".//*[@id='select2-drop']//span[text()='"+value+"']"));
		maindropdownValue.click();
	}
	
	public static boolean canSearchWhoToRestrict(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, pagerestrictionsSearchBox);
		return pagerestrictionsSearchBox.isDisplayed();
	}
	
	public static boolean canAddWhoToRestrict(WebDriver driver)
	{
		Wait.waitForelementToBeClickable(driver, pagerestrictionsSearchBox);
		return pagerestrictionsSearchBox.isDisplayed();
	}
	
		
}
