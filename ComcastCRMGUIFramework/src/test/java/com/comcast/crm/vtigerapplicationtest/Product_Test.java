package com.comcast.crm.vtigerapplicationtest;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseclassutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClasssObject;
import com.comcast.crm.objectrepositoryutility.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.CreateNewVendorsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInfoPage;
import com.comcast.crm.objectrepositoryutility.ProductPage;
import com.comcast.crm.objectrepositoryutility.VendorsInfoPage;
import com.comcast.crm.objectrepositoryutility.VendorsPage;

/**
 * @author Sindhura
 * Product Module 
 * TestScript 1 : craeteProduct_Test
 * TestScript 2 : createProductWithVendors_Test
 * 
 */
//@Listeners(com.comcast.crm.listenerutility.ListenerImplimentationClass.class)
public class Product_Test extends BaseClass {

	@Test (groups = "Smoke")
	public void craeteProduct_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String productName = eLib.getDataFromExcel("product", 2, 3)+ jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to Product page");
		hp.getProductLink().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getCreateNewProductBtn().click();
		
		CreateNewProductPage cpp = new CreateNewProductPage(driver);
		cpp.createProduct(productName);
		
		ProductInfoPage pip = new ProductInfoPage(driver);
		
		String headerMsg = pip.getHeaderMsg().getText();
		tLib.hardAssertContains(headerMsg, productName);
	}
	
	@Test
	public void createProductWithVendors_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String vendorsName = eLib.getDataFromExcel("vendor", 2, 2) + jLib.getRandomNumber();
		String productName = eLib.getDataFromExcel("product", 2, 3)+ jLib.getRandomNumber();

		//vendors

		HomePage hp = new HomePage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to Vendors page");

		hp.getVendors();
		
		VendorsPage vp = new VendorsPage(driver);
		vp.getcreateNewVendorsBtn().click();
		
		CreateNewVendorsPage cvp = new CreateNewVendorsPage(driver);
		cvp.createvendors(vendorsName);
				  
		VendorsInfoPage vip = new VendorsInfoPage(driver);
		
		  String actVendorsName = vip.getHeaderMsg().getText();
		  tLib.hardAssertContains(actVendorsName, vendorsName);
		  
		  //product
			UtilityClasssObject.getTest().log(Status.INFO, "Navigate to Product page");
		  hp.getProductLink().click();
			
			ProductPage pp = new ProductPage(driver);
			pp.getCreateNewProductBtn().click();
			
			CreateNewProductPage cpp = new CreateNewProductPage(driver);
			cpp.createProduct(productName, vendorsName);	
			ProductInfoPage pip = new ProductInfoPage(driver);
			String headerMsg = pip.getHeaderMsg().getText();
			tLib.softAssertContains(headerMsg, productName);
		String	actVendorName = driver.findElement(By.linkText(""+vendorsName+"")).getText();
			tLib.hardAssertEquals(actVendorName, vendorsName);
		
	}
}
