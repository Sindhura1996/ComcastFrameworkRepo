package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	// created globally because we can access to connect to db method and also for close db conncection
	Connection con; 
	
	public void getConnectionToDataBase(String url, String password, String username) throws SQLException
	{	
		//if connection not happened (when we are connceting database try catch is mandatory
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			con = DriverManager.getConnection(url, username, password);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	// if url un passwrd is contant throughout the project directly inside the method declscre url, un,passwrd
	public void getConnectionToDataBase() throws SQLException
	{	
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void closeDbConnection() throws SQLException
	{
		try 
		{
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ResultSet selectQuery(String query) throws SQLException
	{
		ResultSet result = null;
		try {
			Statement state = con.createStatement();
			 result = state.executeQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;

	}
	
	public int nonselectQuery(String query) throws SQLException
	{	
		int result = 0;
		try {
			Statement state = con.createStatement();
			result = state.executeUpdate(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	
	}
}
