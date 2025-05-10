package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber()
	{
		Random r = new Random();
		int randromNumber = r.nextInt(5000);
		return randromNumber;
	}
	
	public String getSystemDateDDMMYYYY()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(d);
		return date;
	}
	
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(d);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String endDate = sdf.format(cal.getTime());
		return endDate;

	}
	
	public void ifcontains(String actual, String expected, String text)
	{
		if(actual.contains(expected))
		{
			System.out.println(expected+ " " +text+"  header is verified");
		}
		else
		{
			System.out.println(expected+ " " +text+" header is not verified");

		}
	}
	
	public void ifequals(String actual, String expected, String text)
	{
		if(actual.equals(expected))
		{
			System.out.println(expected+ " " +text+" information is verified");
		}
		else
		{
			System.out.println(expected+ " " +text+" information is not verified");

		}
	}
}
