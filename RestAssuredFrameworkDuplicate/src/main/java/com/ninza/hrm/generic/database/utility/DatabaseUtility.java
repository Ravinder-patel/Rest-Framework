package com.ninza.hrm.generic.database.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
import com.ninza.hrm.generic.file.utility.PropertiesFileUtility;

public class DatabaseUtility {
	PropertiesFileUtility putil=new PropertiesFileUtility();

	Connection connect;

	// To establish connection with database
	public void getConnection(String url, String username, String password) throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connect = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
		}
	}
// overloaded method
	public void getConnection() throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connect = DriverManager.getConnection(putil.getDataFromProperties("DBUrl"), putil.getDataFromProperties("DB_Username"), putil.getDataFromProperties("DB_Password"));
			System.out.println("==============DB Connected==========");
		} catch (Exception e) {
		}
	}

	// To close the database connection
	public void closeConnection() throws Throwable {
		try {
			connect.close();
			System.out.println("=========DB Connection closed==========");

		} catch (Exception e) {
		}
	}

	// To read data from database
	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
			Statement statement = connect.createStatement();
			result = statement.executeQuery(query);
		} catch (Exception e) {

		}
		return result;
		
	}

	//To write data or update database
	public int executeNonSelectQuery(String query) throws Throwable {
		int result = 0;
		try {
			Statement statement = connect.createStatement();
			result = statement.executeUpdate(query);
		} catch (Exception e) {

		}
		return result;
	}
	
}
