package com.comcast.crm.vtigerapplicationtest;

import org.openqa.selenium.WebDriver;
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
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * @author Sindhura
 * Organization Module 
 * TestScript 1 : createorg_Test
 * TestScript 2 : createOrgWithIndustry_Test
 * TestScript 3 : createOrgWithPhNumber_Test
 * 
 */
public class Organization_Test extends BaseClass{

	@Test (groups = "Smoke")
	public void createorg_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org", 2, 1)+ jLib.getRandomNumber();
	
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to organization page");
		
		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.createOrg(orgName);
		
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();
		boolean res = headerInfo.contains(orgName);
		Assert.assertTrue(res);
		String actOrgName = oip.getActOrgName().getText();	
		Assert.assertEquals(actOrgName, orgName);
	}
	@Test
	public void createOrgWithIndustry_Test() throws Throwable
	{
		
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org", 2, 1) + jLib.getRandomNumber();
		String industryName = eLib.getDataFromExcel("org", 5, 2);
		String typeName = eLib.getDataFromExcel("org", 5, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to organization page");
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.createOrg(orgName, industryName, typeName);
		  OrganizationsInfoPage oip = new OrganizationsInfoPage(driver); 
		  String actIndustry = oip.getIndustryName().getText();
			Assert.assertEquals(actIndustry, industryName);
		  String actType = oip.getType().getText();
			Assert.assertEquals(actType, typeName);
	}
	
	@Test
	public void createOrgWithPhNumber_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org", 2, 1)+ jLib.getRandomNumber();
		String phno = eLib.getDataFromExcel("org", 8, 2);
		HomePage hp = new HomePage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to organization page");
		hp.getOrgLink().click();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.createOrg(orgName, phno);
		
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String actpho = oip.getPhno().getText();
		
		Assert.assertEquals(actpho, phno);

	}
}
