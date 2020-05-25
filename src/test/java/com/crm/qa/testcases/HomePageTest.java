package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase	
{
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactPage;

	public HomePageTest()
	{
		super();
	}
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		
		loginPage =new LoginPage ();
		//contactPage=new ContactsPage();
		
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@Test(priority=1)
	public void  homePageTitle()
	{
		String title=homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM","Home Page Title not matched");
	}

	@Test(priority=2)
	public void verifyUserName()
	{
	Assert.assertTrue(homePage.verifyCorrectUserName());
		
		
	}
@Test(priority=3)
public void verifyContactLink()
{
	contactPage=homePage.clickonContactsLink();
	
}
/*@AfterMethod
public void tearDown() throws InterruptedException
{
	Thread.sleep(5000);
	driver.quit();
}*/
}