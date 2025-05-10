package examples;

	import java.io.FileInputStream;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

	public class JavaScriptExecuter {

		public static void main(String[] args) throws Throwable {
			// TODO Auto-generated method stub
			FileUtility fLib = new FileUtility();
			String USERNAME = fLib.getDataFromPropertiesFile("username");
			String PASSWORD = fLib.getDataFromPropertiesFile("password");
			String URL = fLib.getDataFromPropertiesFile("url");
			String BROWSER = fLib.getDataFromPropertiesFile("browser");
			
			
			JavaUtility jLib = new JavaUtility();

			ExcelUtility eLib = new ExcelUtility();
			String orgName = eLib.getDataFromExcel("org", 2, 1)+ jLib.getRandomNumber();
			
			
				WebDriver driver = null;
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
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
				driver.get(URL);

			WebElement element =driver.findElement(By.name("user_name"));
		
			WebdriverUtility wLib = new WebdriverUtility();
			wLib.sendDataToElementUsingJS(driver, element, USERNAME);
				
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				WebElement element1 =	driver.findElement(By.xpath("//input[@type='submit']"));
				wLib.clickUsingJS(driver,element1);
		}
	}
