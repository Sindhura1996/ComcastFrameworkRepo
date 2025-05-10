package com.comcast.crm.generic.baseclassutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.databaseutilitycom.comcast.crm.generic.testngutility.TestngUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClasssObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	//for implimentation class to access wedriver ref
	
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	public WebdriverUtility wLib = new WebdriverUtility();
	public TestngUtility tLib = new TestngUtility();
	
	@BeforeSuite(groups = "Smoke")
	public void configBS() throws SQLException
	{
		System.out.println("====connect to database , report config=====");
		dLib.getConnectionToDataBase();
	}
	@Parameters("BROWSER")
	@BeforeClass(groups = "Smoke")
	public void configBC(@Optional("chrome") String browser) throws Throwable
	{
		System.out.println("===launch the browser===");
		
		//String BROWSER = browser;
				//fLib.getDataFromPropertiesFile("browser");
		
		
		// to get read data from maven cmd
		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertiesFile("browser"));
		
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		sdriver=driver; // after lauching wedriver it is going to store session it in sdriver
		UtilityClasssObject.setDriver(driver);
		
}
	
	
	@BeforeMethod(groups = "Smoke")
	public void configBM() throws Throwable
	{
		System.out.println("=login=");
		
		//String USERNAME = fLib.getDataFromPropertiesFile("username");
		//String PASSWORD = fLib.getDataFromPropertiesFile("password");
		//String URL = fLib.getDataFromPropertiesFile("url"); 
		
		
		// to get read data from maven cmd
		String USERNAME = System.getProperty("username", fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", fLib.getDataFromPropertiesFile("password"));
		String URL = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));

		LoginPage lp = new LoginPage(driver);
		lp.loginToappliaction(URL,USERNAME, PASSWORD);
		

	}
	
	@AfterMethod(groups = "Smoke")
	public void configAM()
	{
		System.out.println("=logout=");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups = "Smoke")
	public void configAC()
	{
		System.out.println("===close the browser===");
		driver.quit();
	}
	
	@AfterSuite(groups = "Smoke")
	public void configAS() throws SQLException
	{
		System.out.println("====close the database, backup report=====");
		dLib.closeDbConnection();
	}

}
