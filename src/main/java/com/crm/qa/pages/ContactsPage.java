package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{

	@FindBy(xpath="//span[text()='Contacts']") WebElement contactsLabel;
	
	@FindBy(xpath="//button[text()='New']") WebElement contactNewbtn;
	/*@FindBy(xpath="//td[text()='Referred by1']//preceding-sibling::td/div[@class='ui fitted read-only checkbox']//input[@name='id']") 
	WebElement checkBox;
	*/
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkLabel()
	{
		return contactsLabel.isDisplayed();
	}
	public void selectContacts(String name)
	{
		WebElement checkBox = driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td/div[@class='ui fitted read-only checkbox']//input[@name='id']"));
		Actions action = new Actions(driver);
		action.moveToElement(checkBox).click().build().perform();
		
	}
	public void NewContact()
	{
		 contactNewbtn.click();
	}

}
