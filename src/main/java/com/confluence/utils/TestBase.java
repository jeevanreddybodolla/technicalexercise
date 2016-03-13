package com.confluence.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.confluence.testdata.Constant;
import com.confluence.testdata.ExcelUtils;

public class TestBase
{
	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
		
	@BeforeMethod
	  public void SetUp() 
	  {
		 driver = Browser.launchBrowser("firefox");
		 Wait.WaitForPageLoad(driver);
		 
	  }

	@AfterMethod
	 public void TearDown()
	 {
		Browser.Close();
	 }
	
	@DataProvider(name = "DP For Creation of Blank Page") 
    public Object[][] getDataPoolforBlankPage() throws Exception{
 
         Object[][] testObjArray = ExcelUtils.getTableArray(Constant.Path_TestData+Constant.File_TestData, "BlankPage", "createNewBlankPage");
 
         return (testObjArray);

		}
	
	@DataProvider(name = "DP For Validate Restriction Access")
    public Object[][] getDataPoolforValidatePageRestriction() throws Exception{
		 
        Object[][] testObjArray = ExcelUtils.getTableArray(Constant.Path_TestData+Constant.File_TestData, "PageRestrictions", "validatePageRestrictions");

        return (testObjArray);

		}

	  
}
