package com.comcast.crm.vtigerapplicationtest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseclassutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClasssObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewLeadsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadsInfoPage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * @author Sindhura
 * Leads Module 
 * TestScript 1 : createLeads_Test
 * 
 */

public class Leads_Test extends BaseClass {

	@Test (groups = "Smoke")
	public void createLeads_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String LastName = eLib.getDataFromExcel("leads", 2, 2)+ jLib.getRandomNumber();
		String companyNmae = eLib.getDataFromExcel("leads", 2, 3)+ jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();
		
		LeadsPage lep = new LeadsPage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to Leads page");

		lep.getCreateNewLeadsBtn().click();
		
		CreateNewLeadsPage clp = new CreateNewLeadsPage(driver);
		clp.createLeads(LastName, companyNmae);
		
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		
		String actHeader = lip.getHeaderMsg().getText();
		boolean res = actHeader.contains(LastName);
		Assert.assertTrue(res);
		
	}
}
