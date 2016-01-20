package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PatientCase;

/**
 * Controller Class to manage all Patient actions
 * 
 * @author Yannis
 *
 */
public class PatientSearchController {

	private final String DOCTOR_GREEN = "doctorgreen";
	EntityManagerFactory factory;
	EntityManager em;

	private static PatientSearchController instance = null;

	public static PatientSearchController getInstance() {
		if (instance == null) {
			instance = new PatientSearchController();
		}
		return instance;
	}

	/**
	 * Create the factory and entity Manager for Database Connectivity
	 */
	private void createFactory() {
		factory = Persistence.createEntityManagerFactory(DOCTOR_GREEN);
		em = factory.createEntityManager();
	}

	/**
	 * Returns all Patients from the Database
	 * 
	 * @return
	 */
	public List<Patient> getPatientList() {
		createFactory();
		Query q = em.createQuery("select p from Patient p");
		List<Patient> patientList = q.getResultList();

		return patientList;
	}

	/**
	 * Store the edited Patient into the Database
	 * 
	 * @param patient
	 */
	public void savePatient(Patient patient) {
		createFactory();
		try {
			em.getTransaction().begin();
			
			Patient dbPatient = em.find(Patient.class, patient.getPid());
			dbPatient.setFirstName(patient.getFirstName());
			dbPatient.setLastName(patient.getLastName());
			dbPatient.setInsuranceNb(patient.getInsuranceNb());
			dbPatient.setBirthDate(patient.getBirthDate());
			
			
//			firstname = new TextField("First name");
//			TextField lastname = new TextField("Last name");
//			TextField insuranceNb = new TextField("Insurance Number");
//			DateField birthDate = new DateField("Birth date");
//			ComboBox gender
			
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
		}
	}

	/**
	 * Returns all Patient Cases from the Database
	 * 
	 * @return
	 */
	public List<PatientCase> getPatientCaseList() {
		createFactory();
		Query q = em.createQuery("select pc from PatientCase pc");
		List<PatientCase> patientCaseList = q.getResultList();
		return patientCaseList;
	}
}
