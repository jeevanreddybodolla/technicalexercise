package com.confluence.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.confluence.pages.CreatePage;
import com.confluence.pages.CreateTemplateDialogPage;
import com.confluence.pages.MainPage;
import com.confluence.pages.SideBarPage;
import com.confluence.pages.LoginPage;
import com.confluence.pages.LogoutPage;
import com.confluence.pages.TopNavigationPage;
import com.confluence.utils.TestBase;


@SuppressWarnings("static-access")

public class CreateNewPageTest_Blank extends TestBase
{

	@Test(dataProvider = "DP For Creation of Blank Page")
	public void CreateNewBlankPage(String Execute, String URL, 
								String Username, String Password,
								String PageTitle, String BodyText)
	{
		
		WebDriver driver = getDriver();
		driver.get(URL);
		LoginPage signin = new LoginPage(driver);
		signin.LogIn(Username,Password);
		
		/*
		 * Verify Homepage is loaded
		 */
		MainPage home = new MainPage(driver);
		Assert.assertTrue(home.IsHomePageLoaded(driver));
		
		/*
		 * Click Create Page Button
		 */
		TopNavigationPage tnp = new TopNavigationPage(driver);
		tnp.clickCreatePageButton(driver);
		
		/*
		 * Click Blank page then create
		 */
		CreateTemplateDialogPage ctdp = new CreateTemplateDialogPage(driver);
		ctdp.clickBlankPage(driver);
		ctdp.clickCreateButton(driver);
		
		/*
		 * Enter details on new Page
		 */
		CreatePage pg = new CreatePage(driver);
		pg.createBlankPage(driver, PageTitle,BodyText);
		
		/*
		 * Validate Title & Body
		 */
		MainPage displaypage = new MainPage(driver);
		Assert.assertTrue(displaypage.validatePageTitle(driver, PageTitle));
		Assert.assertTrue(displaypage.validatePageBody(driver, BodyText));
		Assert.assertTrue(displaypage.BrowserTitle(driver).contains(PageTitle));
		
		/*
		 * Validate created page in page tree
		 */
		SideBarPage sbp = new SideBarPage(driver);
		Assert.assertTrue(sbp.validatePageNameInPageTree(driver, PageTitle));
		
		/*
		 * Delete created page
		 */
		MainPage deletepage = new MainPage(driver);
		deletepage.deleteDisplayedPage(driver);
		
		/*
		 * Logout
		 */
		tnp.logOut(driver);
		LogoutPage lp = new LogoutPage(driver);
		lp.confirmLogout(driver);
	 }
	
	 
		   
}
