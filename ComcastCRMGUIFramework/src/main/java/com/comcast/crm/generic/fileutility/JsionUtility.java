package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsionUtility {

	public String getDataFromJsonFile(String key) throws Throwable
	{
		FileReader FileR = new FileReader("./configAppData/jasonCommondata.json");
		JSONParser jp = new JSONParser();
		Object obj = jp.parse(FileR);
		JSONObject jobj = (JSONObject)obj;
		String data = (String) jobj.get(key);
		return data;
		
	}
}
