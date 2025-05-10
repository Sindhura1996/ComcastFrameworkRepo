package com.comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImpClass implements IRetryAnalyzer{
	int count = 0;
	int maxLimit =2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxLimit)
		{
			count++;
			return true;
		}
		//else false
		return false;
	}

}
