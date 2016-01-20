package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
	private static String DB_URL = "jdbc:jtds:sqlserver://corpus.bfh.ch:55783;DatabaseName=SWE_2015_1";
	private static String DB_USER = "SWE_2015_1";
	private static String DB_PASSWORD = "swe2015";
	
	private static DB_Connection dc = null;
	
	public static DB_Connection getInstance() {
		
		if (dc == null) {
			dc = new DB_Connection();
		}
		return dc;
	}
	
	public Connection getConnection() throws SQLException {
					Connection connection = DriverManager.getConnection(DB_URL, DB_USER,
		                DB_PASSWORD);
					System.err.println("The connection is successfully obtained");
		        return connection;
		    }

}