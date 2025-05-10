package com.comcast.crm.vtigerapplicationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseclassutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClasssObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewVendorsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.VendorsInfoPage;
import com.comcast.crm.objectrepositoryutility.VendorsPage;

/**
 * @author Sindhura
 * Vendors Module 
 * TestScript 1 : createVendors_Test
 * 
 */
public class Vendors_Test extends BaseClass{
	
	@Test (groups = "Smoke")
	public void createVendors_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String vendorsName = eLib.getDataFromExcel("vendor", 2, 2) + jLib.getRandomNumber();

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
	}

}
