package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PersistenceUnit;

/**
 * 
 * @author Yannis
 *
 */
public class PatientSearchController {
	PersistenceUnit unit = PersistenceUnit.getInstance();

	private static PatientSearchController instance = null;

	public static PatientSearchController getInstance() {
		if (instance == null) {
			instance = new PatientSearchController();
		}
		return instance;
	}

	/**
	 * 
	 * @param insuranceNb
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public Patient getPatient(String insuranceNb, String firstname, String lastname) {
		// TODO Search Patient

		return new Patient();
	}

	/**
	 * 
	 * @param insuranceNb
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public List<Patient> getPatientList(String insuranceNb, String firstname, String lastname) {
		List<Patient> patientList = new ArrayList<Patient>();

		// TODO searchPatients

		return patientList;

	}

}
