package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void waitPageToload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Select class dropdown
	public void selectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	
	public void selectByVisibleText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void deSelectByVisibleText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	
	public void deSelectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	
	public void deSelectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	
	public void deSelectAll(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();;
	}
	
	//Actions Class
	
	public void moveToTheElement(WebDriver driver, WebElement elemet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemet).perform();;
	}
	
	public void doubleClick(WebDriver driver, WebElement elemet)
	{
		Actions act = new Actions(driver);
		act.doubleClick(elemet).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement elemet, WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(elemet, targetElement).perform();
	}
	
	public void moveToElemetAndClick(WebDriver driver, WebElement elemet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemet).click().perform();
	}
	
	public void scrollDown(WebDriver driver, WebElement elemet)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(elemet).perform();
	}
	
	public void sendKeys(WebDriver driver, WebElement elemet, String value)
	{
		Actions act = new Actions(driver);
		act.sendKeys(elemet, value).perform();
	}
	
	public void getScreenShotOfPage(WebDriver driver, String fileName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\screenshot\\"+fileName);
		FileHandler.copy(src, dest);
	}
	
	public void switchToAlertAndAceept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToAlertAndSendData(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	public void switchFramesByIndex(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchFramesByElement(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchFramesByElement(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToWindowOnUrl(WebDriver driver, String particularUrl)
	{
		Set<String> id = driver.getWindowHandles();
		Iterator<String> itr = id.iterator();
		while(itr.hasNext())
		{
			String windowID = itr.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(particularUrl))
			{
				break;
			}
		}
	}
	public void switchToWindowOnTitle(WebDriver driver, String particularTitle)
	{
		Set<String> id = driver.getWindowHandles();
		Iterator<String> itr = id.iterator();
		while(itr.hasNext())
		{
			String windowiD = itr.next();
			driver.switchTo().window(windowiD);
			
			String actTitle = driver.getTitle();
			if(actTitle.contains(particularTitle));
			{
				break;
			}
		}
	}
	
	// javascript executer
	
	public void scrollByUsingJS(WebDriver driver, WebElement element, int x, int y) 
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+x+","+y+");",element);
	}
	//to send keys values to particular fields
	public void sendDataToElementUsingJS(WebDriver driver, WebElement element,String value)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+value+"';", element);
	}
	// to click on particular element
	public void clickUsingJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
	}	
}
