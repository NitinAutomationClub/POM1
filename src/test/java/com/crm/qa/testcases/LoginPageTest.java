package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;//create the reference for Login class 
	
	HomePage homepage;
	//Create constructor
	
	public LoginPageTest()
	{
		super();//to call the constructor of Test Base class where we define the file.properties
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		//create the object of LoginPage Class
		 loginPage=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void loginTest()
	{
		//"login" method returing homepage object so need to assigned to homepage variable
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
	}
	
	
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
//	

}
