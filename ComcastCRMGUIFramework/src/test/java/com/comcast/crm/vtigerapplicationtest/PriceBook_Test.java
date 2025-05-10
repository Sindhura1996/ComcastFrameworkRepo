package com.comcast.crm.vtigerapplicationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseclassutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClasssObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewPriceBookPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.PriceBookInfoPage;
import com.comcast.crm.objectrepositoryutility.PricebookPage;
//@Listeners(com.comcast.crm.listenerutility.ListenerImplimentationClass.class)
/**
 * @author Sindhura
 * PriceBook Module 
 * TestScript 1 : createPriceBook_Test
 * TestScript 2 : createAndSeachPriceBook_Test
 * 
 */
public class PriceBook_Test extends BaseClass{

	@Test (groups = "Smoke")
	public void createPriceBook_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String priceBooks = eLib.getDataFromExcel("priceBook", 2, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getPriceBook();
		
		PricebookPage pp = new PricebookPage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to PriceBook page");

		pp.getCreateNewPriceBtn().click();
		
		CreateNewPriceBookPage cpp = new CreateNewPriceBookPage(driver);
		cpp.createPriceBook(priceBooks);
				  
		PriceBookInfoPage Pb = new PriceBookInfoPage(driver);
		
		  String headerMsg = Pb.getHeaderMsg().getText();
		  boolean res = headerMsg.contains(priceBooks);
		  Assert.assertTrue(res);
	}
	
	@Test
	public void createAndSeachPriceBook_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String priceBooks = eLib.getDataFromExcel("priceBook", 2, 2) + jLib.getRandomNumber();;

		HomePage hp = new HomePage(driver);
		hp.getPriceBook();
		
		PricebookPage pp = new PricebookPage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to PriceBook page");
		pp.getCreateNewPriceBtn().click();
		CreateNewPriceBookPage cpp = new CreateNewPriceBookPage(driver);
		cpp.createPriceBook(priceBooks);
				  
		PriceBookInfoPage Pb = new PriceBookInfoPage(driver);
		
		  String headerMsg = Pb.getHeaderMsg().getText();
		  tLib.softAssertContains(headerMsg, priceBooks);
		 hp.getPricebookLink().click();
			
		  pp.getSearchPriceBook().sendKeys(priceBooks);
		  wLib.selectByVisibleText(pp.getSearchFieldBook(), "Price Book Name");
		  pp.getSearchBtn().click();
		  
		 driver.findElement(By.linkText(""+priceBooks+"")).click();
		 
		 String serchpriceBook = Pb.getPbNAme().getText();
		 
		 Assert.assertEquals(serchpriceBook, priceBooks);

			//to fail the test case i have modified priceBooks to "1234"
		// Assert.assertEquals(serchpriceBook, "1234");
	}
}
