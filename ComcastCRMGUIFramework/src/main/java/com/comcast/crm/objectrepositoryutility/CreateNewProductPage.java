package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewProductPage {
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath ="//input[@name='vendor_name']/following-sibling::img")
	WebElement vendorsBtn;
	
	@FindBy(name="search_text")
	private WebElement seachEdit;
	
	@FindBy(name="search")
	private WebElement seachBtn;

	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getVendorsBtn() {
		return vendorsBtn;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createProduct(String Pname)
	{
		productNameEdt.sendKeys(Pname);
		saveBtn.click();
	}
	
	/**
	 * @param Pname
	 * @param vendorsName
	 */
	public void createProduct(String Pname, String vendorsName)
	{
		productNameEdt.sendKeys(Pname);
		vendorsBtn.click();
		WebdriverUtility wLib = new WebdriverUtility();
		wLib.switchToWindowOnUrl(driver, "module=Vendors");
		seachEdit.sendKeys(vendorsName);
		seachBtn.click();
		driver.findElement(By.xpath("//a[text()='" + vendorsName + "']")).click();
		wLib.switchToWindowOnUrl(driver, "module=Products");
		saveBtn.click();
	}
}
