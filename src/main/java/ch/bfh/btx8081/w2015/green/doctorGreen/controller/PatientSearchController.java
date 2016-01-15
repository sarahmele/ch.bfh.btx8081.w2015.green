package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;

public class PatientSearchController {

	public Patient getPatient(String insuranceNb, String firstname, String lastname) {
		// TODO Search Patient

		return new Patient();
	}

	public List<Patient> getPatientList(String insuranceNb, String firstname, String lastname) {
		List<Patient> patientList = new ArrayList<Patient>();

		// TODO searchPatients

		return patientList;

	}
}
