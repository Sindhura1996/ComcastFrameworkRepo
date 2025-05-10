package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewLeadsPage {
	WebDriver driver;
	public CreateNewLeadsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(name="lastname")
		private WebElement leadsLNameEdt;
		
		@FindBy(name="company")
		private WebElement leadsCompEdt;
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		
		
		public WebElement getLeadsLNameEdt() {
			return leadsLNameEdt;
		}



		public WebElement getLeadsCompEdt() {
			return leadsCompEdt;
		}



		public WebElement getSaveBtn() {
			return saveBtn;
		}



		/**
		 * @param leadsLName
		 * @param company
		 */
		public void createLeads(String leadsLName,String company)
		{
			leadsLNameEdt.sendKeys(leadsLName);
			leadsCompEdt.sendKeys(company);
			saveBtn.click();
		}
		
		
		
}

