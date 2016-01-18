package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Treatment;

public class PatientController {

	private static PatientController instance = null;

	public static PatientController getInstance() {
		if (instance == null) {
			instance = new PatientController();
		}
		return instance;
	}

	// TODO: aktuelles Status Objekt abfragen
	// Status status = new Status();

	public void createTreatment() {
		Treatment treatment = new Treatment();

	}

}
