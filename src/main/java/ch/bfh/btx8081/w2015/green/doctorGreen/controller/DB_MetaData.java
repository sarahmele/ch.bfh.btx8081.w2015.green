package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DB_MetaData {
	static Connection connection = null;
	static DatabaseMetaData metadata = null;

	// Static block for initialization

	static {

		try {
			connection = DB_Connection.getConnection();
		} catch (SQLException e) {
			System.err.println("There was an error getting the connection: "
					+ e.getMessage());
		}
		try {
			metadata = connection.getMetaData();
		} catch (SQLException e) {
			System.err.println("There was an error getting the metadata: "
					+ e.getMessage());
		}

	}
	
	
	// Printing in the console the metadata of the database
	public static void printGeneralMetadata() throws SQLException {
			        System.out.println("Database Product Name: " + metadata.getDatabaseProductName());
		
			        System.out.println("Database Product Version: " + metadata.getDatabaseProductVersion());
		
			        System.out.println("Logged User: " + metadata.getUserName());
		
			        System.out.println("JDBC Driver: " + metadata.getDriverName());
		
			        System.out.println("Driver Version: " + metadata.getDriverVersion());
		
			        System.out.println("\n");
		
			    }
	
	// Returnig with an Arraylist the tables names
	public static ArrayList<String> getTablesMetadata() throws SQLException {
		
			        String table[] = { "TABLE" };
			        ResultSet rs = null;
			        ArrayList<String> tables = null;
			        
			        // receive the Type of the object in a String array.
			        rs = metadata.getTables(null, null, null, table);
			        
			        tables = new ArrayList<String>();
			        
			        while (rs.next()) {
			            tables.add(rs.getString("TABLE_NAME"));
			        }
			        return tables;
			    }
	
	public static void getColumnsMetadata(ArrayList<String> tables)
	
		            throws SQLException {
	
		        ResultSet rs = null;
	
		        // Print the columns properties of the actual table
	
		        for (String actualTable : tables) {
	
		            rs = metadata.getColumns(null, null, actualTable, null);
	
		            System.out.println(actualTable.toUpperCase());
	
		            while (rs.next()) {
		                System.out.println(rs.getString("COLUMN_NAME") + " "
		                        + rs.getString("TYPE_NAME") + " "
		                        + rs.getString("COLUMN_SIZE"));
		            }
		            System.out.println("\n");
		        }
		    }
	
	public static void changeCelciusToFahrenheid()
	{
		try {
			Connection con = DB_Connection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Temperature FROM BODYTEMPERATURE");
			
			while (rs.next()) {
				  String temperature = rs.getString("temperature");
				  System.out.println(temperature + "\n");
				}
		}
		catch (SQLException err)
		{
			System.out.println(err.getMessage());
		}
	}
	
	public static void SearchingNameWenk()
	{
		try {
			Connection con = DB_Connection.getConnection();
			Statement stmt_Name = con.createStatement();
			Statement stmt_Firstname = con.createStatement();
			Statement stmt_PatientNb = con.createStatement();
			ResultSet rs_name = stmt_Name.executeQuery("SELECT Name FROM PATIENT");
			ResultSet rs_Firstname = stmt_Firstname.executeQuery("SELECT Firstname FROM PATIENT");
			ResultSet rs_PatientNb = stmt_PatientNb.executeQuery("SELECT PatientNb FROM PATIENT");
			
			while (rs_name.next()) {
				  String name = rs_name.getString("name");
				  System.out.println(name + "\n");
				}
			while (rs_Firstname.next()) {
				  String Firstname = rs_Firstname.getString("Firstname");
				  System.out.println(Firstname + "\n");
				}
			while (rs_PatientNb.next()) {
				  String PatientNb = rs_PatientNb.getString("PatientNb");
				  System.out.println(PatientNb + "\n");
				}
		}
		catch (SQLException err)
		{
			System.out.println(err.getMessage());
		}
	}
	
	
	 public static void main(String[] args) {
		 	        try {
		 	            printGeneralMetadata();
		 	            // Print all the tables of the database scheme, with their names and
		 	            // structure
		 	            getColumnsMetadata(getTablesMetadata());
		 	            SearchingNameWenk();
		 	        } catch (SQLException e) {
		 	            System.err
		 	                    .println("There was an error retrieving the metadata properties: "
		 	                            + e.getMessage());
		 	        }
		 	    }


}
