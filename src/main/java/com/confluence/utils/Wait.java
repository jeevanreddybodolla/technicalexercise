package com.confluence.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Wait{

	
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForPresenceOfElement(WebDriver driver, By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void waitForelementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static void waitForExpectedCondition(WebDriver driver, ExpectedCondition<WebElement> expectedCondition)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(expectedCondition);
		
	}
		
	public static void WaitForPageLoad(WebDriver driver)
    {
		waitForDocumentLoad(driver);
        waitForAjaxLoad(driver);
        waitForDocumentLoad(driver);
    }
	
	private static void waitForDocumentLoad(WebDriver driver){
		
		 WebDriverWait wait = new WebDriverWait(driver, 30);

		    wait.until(new ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver driver) {
		            return ((JavascriptExecutor) driver).executeScript(
		                "return document.readyState"
		            ).equals("complete");
		        }
		    });	
	}
	
	private static boolean waitForAjaxLoad(WebDriver driver){

		 WebDriverWait wait = new WebDriverWait(driver, 30);

		    return wait.until(new ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver driver) {
		        	return driver.findElements(By.cssSelector(".waiting, .tb-loading")).size() == 0;
		        }
		    });	    
	}
		
}
