package com.comcast.crm.vtigerapplicationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseclassutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClasssObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * @author Sindhura
 * Contact Module 
 * TestScript 1 : createContact_Test
 * TestScript 2 : createContactWithOrg_Test
 * TestScript 3 : createContactWithSupportDate_Test
 * 
 */

 //@Listeners(com.comcast.crm.listenerutility.ListenerImplimentationClass.class)
//.....
public class Contact_Test extends BaseClass {

	@Test (groups  = "Smoke")
	public void createContact_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String LastName = eLib.getDataFromExcel("contact", 2, 2)+ jLib.getRandomNumber();		
		HomePage hp = new HomePage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to contact page");
		hp.getOcontactLink().click();

		ContactPage cp = new ContactPage(driver);
		
		UtilityClasssObject.getTest().log(Status.INFO, "click on create new contact");

		cp.getCreateNewConBtn().click();
		CreateNewContactsPage ccp =new CreateNewContactsPage(driver);
		ccp.createContact(LastName);
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String headerMsg = cip.getHeaderMsg().getText();
		boolean res = headerMsg.contains(LastName);
		Assert.assertTrue(res);
	}
	
	@Test(retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImpClass.class)
	public void createContactWithOrg_Test() throws Throwable
	{
		
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");

		String LastName = eLib.getDataFromExcel("contact", 8, 3) + jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("contact", 8, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to organization page");
		hp.getOrgLink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		UtilityClasssObject.getTest().log(Status.INFO, "click on create new organization");
		op.getCreateNewOrgBtn().click();
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createOrg(orgName);
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String headerInfo = oip.getHeaderMsg().getText();	
		tLib.hardAssertContains(headerInfo, orgName);
		UtilityClasssObject.getTest().log(Status.INFO, "Navigate to contact page");
		hp.getOcontactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewConBtn().click();
		UtilityClasssObject.getTest().log(Status.INFO, "click on create new contact");
		CreateNewContactsPage ccp =new CreateNewContactsPage(driver);
		ccp.createContact(LastName, orgName);
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String headerMsg = cip.getHeaderMsg().getText();
		tLib.hardAssertContains(headerMsg, LastName);	
		String actorgCName = driver.findElement(By.linkText(""+orgName+"")).getText();
	
		//to fail the test case i have modified orgName to LastName
		//Assert.assertEquals(actorgCName, LastName);
		Assert.assertEquals(actorgCName, orgName);

	}
	
	@Test
	public void createContactWithSupportDate_Test() throws Throwable
	{
		UtilityClasssObject.getTest().log(Status.INFO, "read data from excel");
		String LastName = eLib.getDataFromExcel("contact", 2, 2)+ jLib.getRandomNumber();

			HomePage hp = new HomePage(driver);
			UtilityClasssObject.getTest().log(Status.INFO, "Navigate to contact page");

			hp.getOcontactLink().click();
			
			ContactPage cp = new ContactPage(driver);
			UtilityClasssObject.getTest().log(Status.INFO, "click on create new contact");

			cp.getCreateNewConBtn().click();
			
	
			String startDate =jLib.getSystemDateDDMMYYYY();
			
			String endDate = jLib.getRequiredDateYYYYMMDD(30);
			
			CreateNewContactsPage ccp =new CreateNewContactsPage(driver);
			ccp.createOrg(LastName, startDate, endDate);
						
			ContactsInfoPage cip = new ContactsInfoPage(driver);
			String actStartDate = cip.getActStartDate().getText();
			
		tLib.hardAssertEquals(actStartDate, startDate);
			String actEndDate = cip.getActEndDate().getText();
			Assert.assertEquals(actEndDate, endDate);
	}
}
