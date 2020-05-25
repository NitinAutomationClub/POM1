package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase 
{
@FindBy(name="first_name") WebElement contactFirstName;
@FindBy(name="last_name") WebElement contactLastName;
@FindBy(xpath ="//button[text()='Save']") WebElement contactSavebtn;
@FindBy(xpath="//div[text()='Create New Contact']") WebElement newContactLabel;
@FindBy(xpath="//div[@name='channel_type']//i[@class='dropdown icon']") WebElement dropDownIcon;
@FindBy(xpath="//input[@class='search']") WebElement companyValue;
@FindBy(xpath="//span[text()='Add ']") WebElement addCompany;


public NewContactPage()
{
	PageFactory.initElements(driver, this);
	
}

public boolean validateNewContactLabel()
{
	return newContactLabel.isDisplayed();
	
}
public void createNewContact(String ftName, String ltName,String compName) throws InterruptedException
{
	contactFirstName.sendKeys(ftName);
	contactLastName.sendKeys(ltName);
	companyValue.sendKeys(compName);
	addCompany.click();
	Thread.sleep(3000);
	contactSavebtn.click();
	
}

}
