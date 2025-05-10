package com.comcast.crm.generic.databaseutilitycom.comcast.crm.generic.testngutility;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class TestngUtility {
	
	public void softAssertContains(String actualData, String expectedData)
	{
		SoftAssert sa = new SoftAssert();
		boolean res = actualData.contains(expectedData);
		sa.assertTrue(res);
		sa.assertAll();
		Reporter.log("=======>PASS", true);

	}
	
	public void softAssertEquals(String actualData, String expectedData)
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualData, expectedData);
		sa.assertAll();
		Reporter.log("=======>PASS", true);

	}
	
	public void hardAssertEquals(String actualData, String expectedData)
	{
		Assert.assertEquals(actualData, expectedData);
		Reporter.log("=======>PASS", true);

	}
	
	public void hardAssertContains(String actualData, String expectedData)
	{
		boolean res = actualData.contains(expectedData);
		Assert.assertTrue(res);
		Reporter.log("=======>PASS", true);
	}

}
