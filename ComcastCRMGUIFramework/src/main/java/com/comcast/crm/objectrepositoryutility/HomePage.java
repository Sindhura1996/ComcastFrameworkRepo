package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ocontactLink;
	
	@FindBy(linkText="Price Books")
	private WebElement pricebookLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy (xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutBtn;
	
	
	
	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getOcontactLink() {
		return ocontactLink;
	}

	public WebElement getPricebookLink() {
		return pricebookLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void getVendors()
	{
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		act.moveToElement(vendorsLink).click().perform();
	}
	
	public void getPriceBook()
	{
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		act.moveToElement(pricebookLink).click().perform();
	}
	
	public void logout()
	{
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		logoutBtn.click();
	}
	
}
