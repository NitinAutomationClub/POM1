package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Nitin Goyal')]") WebElement userNameLabel;
	@FindBy (xpath="//span[contains(text(),'Contacts')]") WebElement contactsLink;
	@FindBy(xpath="//span[contains(text(),'Deals')]")WebElement   dealsLink;
	@FindBy(xpath="//span[contains(text(),'Tasks')]") @CacheLookup WebElement taskLinks;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle()
	{
		return driver.getTitle();
		
	}
	public ContactsPage clickonContactsLink()
	{
		contactsLink.click();
		
		return new ContactsPage();
	}
	
	public boolean verifyCorrectUserName()
	
	{
		return userNameLabel.isDisplayed();
		
	}

	public DealsPage clickonDealsLink()
	
	{

		dealsLink.click();
		return new DealsPage();
	}
	
public TaskPage clickonTaskLink()
	
	{

	taskLinks.click();
		return new TaskPage();
		
		
	}

}
