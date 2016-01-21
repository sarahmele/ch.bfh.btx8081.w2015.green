package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
/**
 * This class implements all methods which are used in the CaseView GUI to communicate with the database. There are getter methods<br>
 * and update methods implemented in JDBC. <br>
 * <br>
 * 
 * @author Shpend Vladi<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - PatientCaseController pc <br>
 *         - DB_Connection dc <br>
 *         - Connection connection <br>
 * <br>
 * 
 *         Methods:<br>
 *         - String getPersonName (int pid)<br>
 *         - String getCaseID (int pid)<br>
 *         - Date getFromDate (int caseID)<br>
 *         - Date getToDate (int caseID)<br>
 *         - String getAnamnesis (int caseID)<br>
 *         - String getDiagnosis (int caseID)<br>
 *         - upDateName(String firstname, String lastname, int pid)<br>
 *         - upDateFromDate(Date FromDate, int caseID)<br>
 *         - upDateToDate(Date ToDate, int caseID)<br>
 *         - upDateAnamnesis(String anamnesis, int caseID)<br>
 *         - upDateDiagnosis(String diagnosis, int caseID)<br>
 *         	
 * <br>
 */
public class PatientCaseController {
	
	// Defining the objects that are needed to create the methods
	private static PatientCaseController pc = null;
	private static DB_Connection dc = DB_Connection.getInstance();
	private static Connection connection = null;
	
	/**
	 * With the getInstance method we make sure that only one object of the PatientCaseController will be used<br>
	 * <br>
	 *
	 * @param none
	 * @return pc
	 * 
	 * <br>
	 */
	public static PatientCaseController getInstance() {
		
		if (pc == null) {
			pc = new PatientCaseController();
		}
		return pc;
	}
	
	/**
	 * PatientCaseController constructor<br>
	 * gets the connection with the database which is used for the methods<br>
	 * <br>
	 *
	 * @param none
	 * @exception the SQL Exception is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	// Static block for initialization
	public PatientCaseController() {
	

		try {
			connection = dc.getConnection();
		} catch (SQLException e) {
			System.err.println("There was an error getting the connection: "
					+ e.getMessage());
		}

	
	}
	
	/**
	 * The getPersonName method gets the Firstname and Last name of the Person from the pid and puts it to one String together.<br>
	 * <br>
	 * @param pid - the parameter which should be given to the method to find the right Person name
	 * @return name - name of the Person which fits with the pid in the database will be returned
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public  String getPersonName (int pid)
		   {
		
		    Statement stmt = null;
		    String query = "select FIRSTNAME, LASTNAME from PERSON where PID="+pid;
		    try {
		    	
		        stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            String firstname = rs.getString("FIRSTNAME");
		            String lastname = rs.getString("LASTNAME");
		            String name = firstname +" "+ lastname;
		            return name;
		        }
		    } catch (SQLException err ) {
		    	System.out.println(err.getMessage());
		    } finally {
		        if (stmt != null) { try {
					stmt.close();
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				} }
		    }
			return null;
			
		}
	
	/**
	 * The getCaseID method gets the case Identification number of the Person from the pid.<br>
	 * <br>
	 * @param pid - the parameter which should be given to the method to find the right caseId<br>
	 * @return caseId - the caseId of the Person which fits with the pid in the database will be returned<br>
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public  Integer getCaseID (int pid)
	   {
	
	    Statement stmt = null;
	    String query = "select PATIENT_CASE_ID from PATIENT_CASE where PATIENT_ID="+pid;
	    try {
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            Integer caseId = rs.getInt("PATIENT_CASE_ID");
	            return caseId;
	        }
	    } catch (SQLException err ) {
	    	System.out.println(err.getMessage());
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException err) {
				System.out.println(err.getMessage());
			} }
	    }
		return null;
		
	}
	
	/**
	 * The getFromDate method gets the entry Date of the Person from the caseId.<br>
	 * <br>
	 * @param caseId - the parameter which should be given to the method to find the right date<br>
	 * @return fromDate - the entry date of the Person which fits with the caseId in the database will be returned<br>
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public  Date getFromDate (int caseID)
	   {
	
	    Statement stmt = null;
	    String query = "select FROMDATE from PATIENTCASE where PATIENTCASEID =" +caseID;
	    try {
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            Date fromDate = rs.getDate("FROMDATE");
	            return fromDate;
	        }
	    } catch (SQLException err ) {
	    	System.out.println(err.getMessage());
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException err) {
				System.out.println(err.getMessage());
			} }
	    }
		return null;
		
	}
	
	/**
	 * The getToDate method gets the leaving Date of the Person from the caseId.<br>
	 * <br>
	 * @param caseId - the parameter which should be given to the method to find the right date<br>
	 * @return toDate - the leaving date of the Person which fits with the caseId in the database will be returned<br>
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public  Date getToDate (int caseID)
	   {
	
	    Statement stmt = null;
	    String query = "select TODATE from PATIENTCASE where PATIENTCASEID="+caseID;
	    try {
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            Date toDate = rs.getDate("TODATE");
	            return toDate;
	        }
	    } catch (SQLException err ) {
	    	System.out.println(err.getMessage());
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException err) {
				System.out.println(err.getMessage());
			} }
	    }
		return null;
		
	}
	
	/**
	 * The getAnamnesis method gets the anamnesis text of the Person from the caseId.<br>
	 * <br>
	 * @param caseId - the parameter which should be given to the method to find the right anamnesis text<br>
	 * @return anamnesis - the anamnesis text of the Person which fits with the caseId in the database will be returned<br>
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public  String getAnamnesis (int caseID)
	   {
	
	    Statement stmt = null;
	    String query = "select ANAMNESIS from PATIENTCASE where PATIENTCASEID=" +caseID;
	    try {
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            String anamnesis = rs.getString("ANAMNESIS");
	            return anamnesis;
	        }
	    } catch (SQLException err ) {
	    	System.out.println(err.getMessage());
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException err) {
				System.out.println(err.getMessage());
			} }
	    }
		return null;
		
	}
	
	/**
	 * The getDiagnosis method gets the diagnosis text of the Person from the caseId.<br>
	 * <br>
	 * @param caseId - the parameter which should be given to the method to find the right diagnosis text<br>
	 * @return diagnosis - the dagnosis text of the Person which fits with the caseId in the database will be returned<br>
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public  String getDiagnosis (int caseID)
	   {
	
	    Statement stmt = null;
	    String query = "select DIAGNOSIS from PATIENTCASE where PATIENTCASEID="+caseID;
	    try {
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            String diagnosis = rs.getString("DIAGNOSIS");
	            return diagnosis;
	        }
	    } catch (SQLException err ) {
	    	System.out.println(err.getMessage());
	    } finally {
	        if (stmt != null) { try {
				stmt.close();
			} catch (SQLException err) {
				System.out.println(err.getMessage());
			} }
	    }
		return null;
		
	}
	
	/**
	 * The upDateName method updates the name of the Person from the Person with the pid.<br>
	 * <br>
	 * @param firstname - the String which should be given to the method to update the right Firstname<br>
	 * @param lastname - the String which should be given to the method to update the right Lastname<br>
	 * @param pid - the parameter which should be given to the method to find the right Person for the update<br>
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public void upDateName(String firstname, String lastname, int pid) {
		PreparedStatement ps = null;
		    try {
		    	ps = connection.prepareStatement("UPDATE PERSON SET FIRSTNAME =?, LASTNAME = ? WHERE PID=?");
		    	// set the preparedstatement parameters
		        ps.setString(1,firstname);
		        ps.setString(2,lastname);
		        ps.setInt(3, pid);
		        // call executeUpdate to execute our sql update statement
		        ps.executeUpdate();
		        ps.close();
		        System.out.println("Update Name was succesful");
		        }
		    catch (Exception e)
		    {
		      System.err.println("Update Name didnt work ");
		      System.err.println(e.getMessage());
		    }
		    } 
	
	/**
	 * The upDateFromDate method updates the entry date of the Person from the Person with the caseID.<br>
	 * <br>
	 * @param FromDate - the Date which should be given to the method to update the right entry date<br>
	 * @param caseID - the parameter which should be given to the method to find the right Case for the update<br>
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public void upDateFromDate(Date FromDate, int caseID) {
		PreparedStatement ps = null;
		    try {
		    	ps = connection.prepareStatement("UPDATE PATIENTCASE SET FROMDATE = ? WHERE PATIENTCASEID=?");
		    	// set the preparedstatement parameters
		        ps.setDate(1,FromDate);
		        ps.setInt(2,caseID);
		        // call executeUpdate to execute our sql update statement
		        ps.executeUpdate();
		        ps.close();
		        System.out.println("Update FROMDATE was succesful");
		        }
		    catch (Exception e)
		    {
		      System.err.println("Update FromDate didnt work ");
		      System.err.println(e.getMessage());
		    }
		    } 
	
	/**
	 * The upDateToDate method updates the leaving date of the Person from the Person with the caseID.<br>
	 * <br>
	 * @param ToDate - the Date which should be given to the method to update the right leaving date
	 * @param caseID - the parameter which should be given to the method to find the right Case for the update
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public void upDateToDate(Date ToDate, int caseID) {
		PreparedStatement ps = null;
		    try {
		    	ps = connection.prepareStatement("UPDATE PATIENTCASE SET TODATE = ? WHERE PATIENTCASEID=?");
		    	// set the preparedstatement parameters
		        ps.setDate(1,ToDate);
		        ps.setInt(2,caseID);
		        // call executeUpdate to execute our sql update statement
		        ps.executeUpdate();
		        ps.close();
		        System.out.println("Update ToDate was succesful");
		        }
		    catch (Exception e)
		    {
		      System.err.println("Update ToDate didnt work ");
		      System.err.println(e.getMessage());
		    }
		    } 
	
	/**
	 * The upDateAnamnesis method updates the anamnesis text Person from the Person with the caseID.<br>
	 * <br>
	 * @param anamnesis - the anamnesis text which should be given to the method to update the right anamnesis text
	 * @param caseID - the parameter which should be given to the method to find the right Case for the update
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public void upDateAnamnesis(String anamnesis, int caseID) {
		PreparedStatement ps = null;
		    try {
		    	ps = connection.prepareStatement("UPDATE PATIENTCASE SET ANAMNESIS = ? WHERE PATIENTCASEID=?");
		    	// set the preparedstatement parameters
		        ps.setString(1,anamnesis);
		        ps.setInt(2,caseID);
		        // call executeUpdate to execute our sql update statement
		        ps.executeUpdate();
		        ps.close();
		        System.out.println("Update Anamnesis was succesful");
		        }
		    catch (Exception e)
		    {
		      System.err.println("Update Anamnesis didnt work ");
		      System.err.println(e.getMessage());
		    }
		    } 
	
	/**
	 * The upDateDiagnosis method updates the diagnosis text Person from the Person with the caseID.<br>
	 * <br>
	 * @param diagnosis - the diagnosis text which should be given to the method to update the right diagnosis text
	 * @param caseID - the parameter which should be given to the method to find the right Case for the update
	 * @exception the SQL Excepion is catched and shows if the connection failed
	 * 
	 * <br>
	 */
	public void upDateDiagnosis(String diagnosis, int caseID) {
		PreparedStatement ps = null;
		    try {
		    	ps = connection.prepareStatement("UPDATE PATIENTCASE SET DIAGNOSIS = ? WHERE PATIENTCASEID=?");
		    	// set the preparedstatement parameters
		        ps.setString(1,diagnosis);
		        ps.setInt(2,caseID);
		        // call executeUpdate to execute our sql update statement
		        ps.executeUpdate();
		        ps.close();
		        System.out.println("Update Diagnosis was succesful");
		        }
		    catch (Exception e)
		    {
		      System.err.println("Update Diagnosis didnt work ");
		      System.err.println(e.getMessage());
		    }
		    } 
	

}
