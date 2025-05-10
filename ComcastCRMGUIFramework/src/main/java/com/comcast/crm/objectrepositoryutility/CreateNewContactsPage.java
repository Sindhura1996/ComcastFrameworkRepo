package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewContactsPage {
	
	WebDriver driver;
	public CreateNewContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(name="lastname")
		private WebElement contactLNameEdt;
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
		private WebElement orgEdit;
		
		@FindBy(name="support_start_date")
		private WebElement startDate;

		@FindBy(name="support_end_date")
		private WebElement endDate;

		@FindBy(name="search_text")
		private WebElement seachEdit;
		
	
		public WebElement getSeachEdit() {
			return seachEdit;
		}

		public WebElement getSeachBtn() {
			return seachBtn;
		}

		@FindBy(name="search")
		private WebElement seachBtn;


		public WebElement getOrgEdit() {
			return orgEdit;
		}

		public WebElement getStartDate() {
			return startDate;
		}

		public WebElement getEndDate() {
			return endDate;
		}

		public WebElement getContactLNameEdt() {
			return contactLNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		/**
		 * @param contactLName
		 */
		public void createContact(String contactLName)
		{
			contactLNameEdt.sendKeys(contactLName);
			saveBtn.click();
		}
		
		/**
		 * @param contactLName
		 * @param orgName
		 */
		public void createContact(String contactLName, String orgName)
		{
			contactLNameEdt.sendKeys(contactLName);
			orgEdit.click();
			WebdriverUtility wLib = new WebdriverUtility();
			wLib.switchToWindowOnUrl(driver, "module=Accounts");
			seachEdit.sendKeys(orgName);
			seachBtn.click();
			driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
			wLib.switchToWindowOnUrl(driver, "module=Contacts");
			saveBtn.click();
		}
		
		
		/**
		 * @param contactLName
		 * @param startDate
		 * @param endDate
		 */
		public void createOrg(String contactLName,String startDate, String endDate)
		{
			contactLNameEdt.sendKeys(contactLName);
			getStartDate().clear();
			getStartDate().sendKeys(startDate);
			getEndDate().clear();
			getEndDate().sendKeys(endDate);
			saveBtn.click();
		}
		
		
		
}

