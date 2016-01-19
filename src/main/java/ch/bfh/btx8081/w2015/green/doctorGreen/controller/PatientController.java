package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PatientCase;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Treatment;

public class PatientController {

	private final String DOCTOR_GREEN = "doctorgreen";
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(DOCTOR_GREEN);
	EntityManager em = factory.createEntityManager();

	private static PatientController instance = null;

	public static PatientController getInstance() {
		if (instance == null) {
			instance = new PatientController();
		}
		return instance;
	}

	// TODO: aktuelles Status Objekt abfragen
	// Status status = new Status();

	public void createTreatment(String description, Date date) {
		ArrayList<PatientCase> patientCaseList = new ArrayList<PatientCase>();
		

		em.getTransaction().begin();
		Treatment treatment = new Treatment();

	}

}
