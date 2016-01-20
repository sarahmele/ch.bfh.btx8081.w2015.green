package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;

/**
 * 
 * @author Yannis
 *
 */
public class PatientSearchController {

	private final String DOCTOR_GREEN = "doctorgreen";
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(DOCTOR_GREEN);
	EntityManager em = factory.createEntityManager();

	private static PatientSearchController instance = null;

	public static PatientSearchController getInstance() {
		if (instance == null) {
			instance = new PatientSearchController();
		}
		return instance;
	}

	public List<Patient> getPatientList() {
		// em.getTransaction().begin();
		// Query q = em.createQuery("SELECT e FROM Patient e");
		// List<Patient> patientList = q.getResultList();
		//
		// em.close();
		// factory.close();
		
		

		List<Patient> patientList = new ArrayList<Patient>();
		Patient patient1 = new Patient();
		patient1.setFirstName("test");
		patient1.setLastName("lastname");
		patient1.setInsuranceNb("1245");

		Patient patient2 = new Patient();
		patient2.setFirstName("tes2t");
		patient2.setLastName("lastname2");
		patient2.setInsuranceNb("1245");

		patientList.add(patient1);
		patientList.add(patient2);

		return patientList;
	}

}
