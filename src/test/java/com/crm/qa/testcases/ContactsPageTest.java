package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase

{
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactPage;

	public ContactsPageTest()
	{
		super();
	}
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		loginPage =new LoginPage ();
		contactPage=new ContactsPage();
		
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactPage=homePage.clickonContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactPage.checkLabel(),"Contact label is missing");
	}
	
	@Test(priority=2)
	public void selectContactsTest()
	{
		contactPage.selectContacts("Referred by1");
		contactPage.selectContacts("Assistant1 ");
	}
	
	
	/*@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}*/

}
