package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.baseclassutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClasssObject;

public class ListenerImplimentationClass implements ITestListener, ISuiteListener{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("==Report configuration====");
		String time = new Date().toString().replace(" ", "_").replace(":", "_"); // to pring the screenshot along with file name with time date also we can print
		 spark = new ExtentSparkReporter("./AdvannceReport/report"+time+".html");
		spark.config().setDocumentTitle("TekP Selenium");
		spark.config().setReportName("Reopt");
		spark.config().setTheme(Theme.DARK);
		/* add envirnonment information and create test*/
		
		 report = new ExtentReports();
		report.attachReporter(spark);
		/* information can be provided*/
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("browser", "chrome");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("==Report backup====");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		//to disply testcase name
		System.out.println("====="+result.getMethod().getMethodName()+"====START====");
		//before excuting testcase this method will execute 1st
		//we create a test case to get that test case in extent report
		 //using this ref we write logs, which means to that particular test case 

		 test =  report.createTest(result.getMethod().getMethodName());
		//before excecuting any test case this method will use so here we have to mention thae static varialble
		 UtilityClasssObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"===>Started<====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====="+result.getMethod().getMethodName()+"====END======");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"===>Completed<====");


	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//to get the failed test case name
		String tesName = result.getMethod().getMethodName();
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_"); // to pring the screenshot along with file name with time date also we can print
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		// in base class we havreated one static driver ref of wedriver to access through class name
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath, tesName+"_"+time);//path+scrrenshot name
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"===>Failed<====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
