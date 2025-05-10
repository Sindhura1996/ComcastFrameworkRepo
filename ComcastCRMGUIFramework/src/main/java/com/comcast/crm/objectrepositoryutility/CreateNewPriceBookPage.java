package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPriceBookPage {
	
	
	WebDriver driver;
	public CreateNewPriceBookPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(name="bookname")
		private WebElement PriceBookNameEdt;
		
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		public WebElement getPriceBookNameEdt() {
			return PriceBookNameEdt;
		}


		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		/**
		 * @param bookName
		 */
		public void createPriceBook(String bookName)
		{
			PriceBookNameEdt.sendKeys(bookName);
			saveBtn.click();
		}
		

}
