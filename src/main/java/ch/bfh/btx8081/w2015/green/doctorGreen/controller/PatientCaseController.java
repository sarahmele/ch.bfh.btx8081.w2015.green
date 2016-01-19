package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;

public class PatientCaseController {
	
	static Connection connection = null;
	static DatabaseMetaData metadata = null;

	// Static block for initialization
	public PatientCaseController(){
	

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
	
	public static String getPersonFirstname(int pid)
		    throws SQLException {
		
		    Statement stmt = null;
		    String query = "select FIRSTNAME from PERSON where PID=1";
		    try {
		    	
		        stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            String firstname = rs.getString("FIRSTNAME");
		            System.out.println(firstname);
		            return firstname;
		        }
		    } catch (SQLException err ) {
		    	System.out.println(err.getMessage());
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
			return null;
			
		}
	


}
