package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase 
{
//Define Page Factory or Object Repositry
	@FindBy(name="email") WebElement userName;
	@FindBy(name="password") WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")WebElement loginBtn;
	@FindBy(xpath="//a[text()='Sign Up']")WebElement signUp;
	
	//Now initialize all these Object Repo using Page factory
	//Create constructor to achieve the same
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);//means initialize all current class (this) object with driver
		//or you can also write like PageFactory.initElements(driver, LoginPage.class);
	}
	//Now define your action/methods on login page
	
	//This method return title of Login Page
public String validateLoginPageTitle()
{
	return driver.getTitle();
	
}

public HomePage login(String un, String pwd)
{
	userName.sendKeys(un);
	System.out.println("entering password");
	password.sendKeys(pwd);
	System.out.println("clicking");
	loginBtn.click();
	System.out.println("clicked");
	//After clicking of login button it is moving to HomePage,
	//it should return Home Page Object
	
	return new HomePage();
}

}
