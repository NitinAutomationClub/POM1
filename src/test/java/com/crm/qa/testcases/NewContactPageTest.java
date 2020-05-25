package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase
{
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactPage;
	NewContactPage newContactPage;
	String sheetName="contacts";
	
	

	public NewContactPageTest()
	{
		super();
	}
	@BeforeMethod()
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage =new LoginPage ();
		contactPage=new ContactsPage();
		newContactPage=new NewContactPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(5000);
		contactPage=homePage.clickonContactsLink();
		Thread.sleep(5000);
		contactPage.NewContact();
		
	}
	@DataProvider
	public Object[][] geCRMtData()
	{
		Object [][]data=TestUtil.getTestData(sheetName);
		return data;
	}
//	@Test
//	public void verifyNewContactLabel()
//	{
//		Assert.assertTrue(newContactPage.validateNewContactLabel(),"Contact is missing");
//	}
	@Test(priority=2,dataProvider="geCRMtData")
	public void validateCreateNewContact(String fname ,String Lname, String cName ) throws InterruptedException
	{
		newContactPage.createNewContact(fname,Lname,cName);	
	}
	
	
}
