package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	WebDriver driver;
	
	public ContactsInfoPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
		
		@FindBy(className="dvHeaderText")
		private WebElement headerMsg;

		@FindBy(id="mouseArea_Organization Name")
		private WebElement ActOrgName;
		
		@FindBy(id="dtlview_Support Start Date")
		private WebElement actStartDate;
		
		@FindBy(id="dtlview_Support End Date")
		private WebElement actEndDate;

		public WebElement getHeaderMsg() {
			return headerMsg;
		}

		public WebElement getActOrgName() {
			return ActOrgName;
		}

		public WebElement getActStartDate() {
			return actStartDate;
		}

		public WebElement getActEndDate() {
			return actEndDate;
		}
		
		

}
