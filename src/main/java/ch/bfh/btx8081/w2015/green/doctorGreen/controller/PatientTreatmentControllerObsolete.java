package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PatientTreatmentControllerObsolete {

	private static PatientTreatmentControllerObsolete tc = null;
	DB_Connection dc = DB_Connection.getInstance();
	static Connection connection = null;

	public static PatientTreatmentControllerObsolete getInstance() {

		if (tc == null) {
			tc = new PatientTreatmentControllerObsolete();
		}
		return tc;
	}

	// Static block for initialization
	public PatientTreatmentControllerObsolete() {

		try {
			connection = dc.getConnection();
		} catch (SQLException e) {
			System.err.println("There was an error getting the connection: "
					+ e.getMessage());
		}

	}


	public String getTreatmentID(int pid) {

		Statement stmt = null;
		String query = "select TREATMENTID from PATIENTCASE_TREATMENT where PATIENTCASEID="
				+ pid;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String treatmentId = rs.getString("TREATMENTID");
				return treatmentId;
			}
		} catch (SQLException err) {
			System.out.println(err.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				}
			}
		}
		return null;

	}

	public Date getDate(int treatID) {

		Statement stmt = null;
		String query = "select DATE from TREATMENT where TREATMENTID ="
				+ treatID;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Date treatDate = rs.getDate("DATE");
				return treatDate;
			}
		} catch (SQLException err) {
			System.out.println(err.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				}
			}
		}
		return null;

	}

	
	public String getDiagnosis(int treatID) {

		Statement stmt = null;
		String query = "select DIAGNOSIS from PATIENTCASE where PATIENTCASEID="
				+ treatID;
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String diagnosis = rs.getString("DIAGNOSIS");
				return diagnosis;
			}
		} catch (SQLException err) {
			System.out.println(err.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException err) {
					System.out.println(err.getMessage());
				}
			}
		}
		return null;

	}

	
	public void insertNewCaseId(int pid, int treatID) {

		Statement stmt = null;
		String query = "INSERT INTO PATIENTCASE_TREATMENT VALUES (" + pid + "," + treatID
				+ ")";
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Update CaseID was succesful");
		} catch (SQLException err) {
			System.out.println(err.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException err) {
					System.out.println("inserting new case Id didnt work");
					System.out.println(err.getMessage());
				}
			}
		}
	}

	public void upDateFromDate(String fromDate, int treatID) {
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("UPDATE PATIENTCASE SET FROMDATE = ? WHERE PATIENTCASEID=?");
			// set the preparedstatement parameters
			ps.setString(1, fromDate);
			ps.setInt(2, treatID);
			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
			System.out.println("Update FROMDATE was succesful");
		} catch (Exception e) {
			System.err.println("Update FromDate didnt work ");
			System.err.println(e.getMessage());
		}
	}

	public void upDateToDate(String toDate, int treatID) {
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("UPDATE PATIENTCASE SET TODATE = ? WHERE PATIENTCASEID=?");
			// set the preparedstatement parameters
			ps.setString(1, toDate);
			ps.setInt(2, treatID);
			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
			System.out.println("Update ToDate was succesful");
		} catch (Exception e) {
			System.err.println("Update ToDate didnt work ");
			System.err.println(e.getMessage());
		}
	}

	public void upDateAnamnesis(String anamnesis, int caseID) {
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("UPDATE PATIENTCASE SET ANAMNESIS = ? WHERE PATIENTCASEID=?");
			// set the preparedstatement parameters
			ps.setString(1, anamnesis);
			ps.setInt(2, caseID);
			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
			System.out.println("Update Anamnesis was succesful");
		} catch (Exception e) {
			System.err.println("Update Anamnesis didnt work ");
			System.err.println(e.getMessage());
		}
	}

	public void upDateDiagnosis(String diagnosis, int caseID) {
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("UPDATE PATIENTCASE SET DIAGNOSIS = ? WHERE PATIENTCASEID=?");
			// set the preparedstatement parameters
			ps.setString(1, diagnosis);
			ps.setInt(2, caseID);
			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
			System.out.println("Update Diagnosis was succesful");
		} catch (Exception e) {
			System.err.println("Update Diagnosis didnt work ");
			System.err.println(e.getMessage());
		}
	}

	/*
	public static void main(String[] args) {
		String fromdate = "1999-07-07";
		String todate = "2016-07-07";
		PatientCaseController pController = PatientCaseController.getInstance();
		pController.upDateFromDate(fromdate, 1);
		pController.upDateToDate(todate, 1);
		pController.upDateName("Shpend", "Vladi", 1);
		pController.insertNewCaseId(12, 13);
		pController.upDateAnamnesis("Albinas leg hurts", 1);
		pController.upDateDiagnosis("Albinas leg is broken", 1);
		System.out.println("Name is: " + pController.getPersonName(1));
		System.out.println("CaseID is: " + pController.getCaseID(1));
		System.out.println("Entry Date is: " + pController.getFromDate(1));
		System.out.println("Leaving Date is: " + pController.getToDate(1));
		System.out.println("Anamnesis is: " + pController.getAnamnesis(1));
		System.out.println("Diagnosis is: " + pController.getDiagnosis(1));

	}
	*/

}
