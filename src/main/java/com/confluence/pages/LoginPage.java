package com.confluence.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Pages
{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how = How.ID, using = "username")
    private static WebElement uname;
	
	@FindBy(how = How.ID, using = "password")
    private static WebElement pword;
	
	@FindBy(how = How.ID, using = "login")
    private static WebElement logInbtn;
	
	@FindBy(how = How.ID, using = "remember-me")
    private static WebElement keepmeloggedin;
	
	@FindBy(how = How.ID, using = "forgot")
    private static WebElement iforgot;

  public static void LogIn(String sUsername, String sPassword) 
  {
	  uname.clear();
	  uname.sendKeys(sUsername);
	  pword.clear();
	  pword.sendKeys(sPassword);
	  logInbtn.click();
  }
  
  public static void KeepMeLoggedIn()
  {
	  keepmeloggedin.click();
  }
  
  public static void UnableToAccessYourAccount()
  {
	  iforgot.click();
  }
}
