package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricebookPage {
	
	WebDriver driver;
	public PricebookPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = ("//img[@alt='Create Price Book...']"))
	private WebElement createNewPriceBtn;
	
	@FindBy(name="search_text")
	private WebElement searchPriceBook;
	
	@FindBy(name="search_field")
	private WebElement searchFieldBook;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchFieldBook() {
		return searchFieldBook;
	}

	public WebElement getCreateNewPriceBtn() {
		return createNewPriceBtn;
	}

	public WebElement getSearchPriceBook() {
		return searchPriceBook;
	}
	
}
