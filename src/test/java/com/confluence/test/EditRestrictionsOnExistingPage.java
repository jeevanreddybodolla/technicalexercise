package com.confluence.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.confluence.pages.MainPage;
import com.confluence.pages.RestrictionsDialogPage;
import com.confluence.pages.LoginPage;
import com.confluence.pages.LogoutPage;
import com.confluence.pages.SideBarPage;
import com.confluence.pages.TopNavigationPage;
import com.confluence.utils.TestBase;
import com.confluence.utils.Wait;

public class EditRestrictionsOnExistingPage extends TestBase{

	@SuppressWarnings("static-access")
	public class CreateNewPageTest_Blank extends TestBase
	{


		@Test(dataProvider = "DP For Validate Restriction Access")
		public void SetRestrictions(String Execute, String URL, String Username, String Password,
									String Space, String Page, String AdminName)
		{
			/*
			 * Instantiate driver and Login
			 */
			WebDriver driver = getDriver();
			driver.get(URL);
			LoginPage signin = new LoginPage(driver);
			signin.LogIn(Username,Password);
			
			/*
			 * Verify Homepage is loaded
			 */
			Wait.WaitForPageLoad(driver);
			MainPage mp = new MainPage(driver);
			Assert.assertTrue(mp.IsHomePageLoaded(driver));
			
			/*
			 * Navigate in Sidebar to access Pages to the page to be edited.
			 */
			SideBarPage sbp = new SideBarPage(driver);
			sbp.clickASpace(driver, Space);
			Wait.WaitForPageLoad(driver);			
			sbp.clickOnAPageInThePageTree(driver, Page);
			Wait.WaitForPageLoad(driver);
			/*
			 * Validate default restriction, if not unrestricted - set to default state
			 */
			RestrictionsDialogPage rdp = new RestrictionsDialogPage(driver);
			
			if(!mp.getPageRestrictionTitle().equals("Unrestricted"))
			{
				mp.clickPageRestrictionsButton(driver);
				rdp.selectFromPageRestrictionsDropDown(driver, "No restrictions");
				rdp.clickSave();
				Wait.WaitForPageLoad(driver);
			}
			
			Assert.assertTrue(mp.getPageRestrictionTitle().equals("Unrestricted"));
			
			mp.clickPageRestrictionsButton(driver);
			Wait.WaitForPageLoad(driver);
			
			/*
			 * Validate admin name and access
			 */		
			rdp.selectFromPageRestrictionsDropDown(driver, "Editing restricted");
			Wait.WaitForPageLoad(driver);
			Assert.assertTrue(rdp.verifyAdminUser(driver, AdminName));
			Assert.assertTrue(rdp.verifyAdminUserAccess(driver, "Can edit"));
			
			/*
			 * Validate view and editing restricted options 
			 */
			rdp.selectFromPageRestrictionsDropDown(driver, "Viewing and editing restricted");
			Wait.WaitForPageLoad(driver);
			Assert.assertTrue(rdp.verifyOptionInDropDown(driver, "Can view and edit"));
			Assert.assertTrue(rdp.verifyOptionInDropDown(driver, "Can view"));
			
			/*
			 * Validate Editing restricted applied
			 */
			rdp.selectFromPageRestrictionsDropDown(driver, "Editing restricted");
			Wait.WaitForPageLoad(driver);
			rdp.clickSave();
			Wait.WaitForPageLoad(driver);
			Assert.assertTrue(mp.getPageRestrictionTitle().equals("Restrictions apply"));
			
			/*
			 * Validate Editing restricted applied
			 */
			mp.clickPageRestrictionsButton(driver);
			Wait.WaitForPageLoad(driver);
			rdp.selectFromPageRestrictionsDropDown(driver, "Viewing and editing restricted");
			Wait.WaitForPageLoad(driver);
			rdp.clickSave();
			Wait.WaitForPageLoad(driver);
			Assert.assertTrue(mp.getPageRestrictionTitle().equals("Restrictions apply"));
			
			/*
			 * Revert changes to default
			 */
			mp.clickPageRestrictionsButton(driver);
			rdp.selectFromPageRestrictionsDropDown(driver, "No restrictions");
			rdp.clickSave();
			Wait.WaitForPageLoad(driver);
			Assert.assertTrue(mp.getPageRestrictionTitle().equals("Unrestricted"));
			
			/*
			 * Logout
			 */
			TopNavigationPage tnp = new TopNavigationPage(driver);
			tnp.logOut(driver);
			LogoutPage lp = new LogoutPage(driver);
			lp.confirmLogout(driver);
			
		 }	 
	  
	}
		
	
}
