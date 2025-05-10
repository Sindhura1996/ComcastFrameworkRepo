package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewOrganizationPage {
	
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(name="accountname")
		private WebElement orgNameEdt;
		
		@FindBy(name="industry")
		private WebElement industryNAmeEdt;
		
		@FindBy(name="accounttype")
		private WebElement typeEdt;
		
		@FindBy(id="phone")
		private WebElement PhnoEdt;
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}

		
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getIndustryNAmeEdt() {
			return industryNAmeEdt;
		}


		public WebElement getTypeEdt() {
			return typeEdt;
		}


		public WebElement getPhnoEdt() {
			return PhnoEdt;
		}


		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		/**
		 * @param orgName
		 */
		public void createOrg(String orgName)
		{
			orgNameEdt.sendKeys(orgName);
			saveBtn.click();
		}
		
		/**
		 * @param orgName
		 * @param industry
		 * @param type
		 */
		public void createOrg(String orgName, String industry, String type)
		{
			orgNameEdt.sendKeys(orgName);
			WebdriverUtility wLib = new WebdriverUtility();
			wLib.selectByVisibleText(industryNAmeEdt, industry);
			wLib.selectByVisibleText(typeEdt, type);
			
			saveBtn.click();
		}
		
		/**
		 * @param orgName
		 * @param pno
		 */
		public void createOrg(String orgName, String pno)
		{
			orgNameEdt.sendKeys(orgName);
			PhnoEdt.sendKeys(pno);
			saveBtn.click();
		}
		
		
		
}
