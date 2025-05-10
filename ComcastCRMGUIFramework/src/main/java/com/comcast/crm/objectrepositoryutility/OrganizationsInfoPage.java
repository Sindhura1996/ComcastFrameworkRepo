package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {

	WebDriver driver;
	
	public OrganizationsInfoPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
		
		@FindBy(className="dvHeaderText")
		private WebElement headerMsg;

		@FindBy(id="dtlview_Industry")
		private WebElement industryName;
		
		@FindBy(id="dtlview_Type")
		private WebElement type;
		
		@FindBy(id="dtlview_Phone")
		private WebElement phno;
		
		@FindBy(id="dtlview_Organization Name")
		private WebElement actOrgName;
		
		
		
		public WebElement getActOrgName() {
			return actOrgName;
		}


		public WebDriver getDriver() {
			return driver;
		}


		public WebElement getIndustryName() {
			return industryName;
		}


		public WebElement getPhno() {
			return phno;
		}


		public WebElement getType() {
			return type;
		}


		public WebElement getHeaderMsg() {
			return headerMsg;
		}
		
		

		
		
		
		

}
