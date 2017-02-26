package org.vaibhav.ebayAPI.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DbConnection {

	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/ebay_handson";
	final static String USER = "root";
	final static String PASS = "root";
	public Connection con=null;
	public  Connection getConnection()
	{
		if(con==null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection)DriverManager.getConnection(DB_URL, USER, PASS);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public void closeConnection()
	{
		try {
			if(con!=null)
				con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}

