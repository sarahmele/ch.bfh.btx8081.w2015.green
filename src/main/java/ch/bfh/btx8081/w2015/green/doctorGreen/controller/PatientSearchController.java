package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PatientCase;

/**
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

	private void createFactory() {
		factory = Persistence.createEntityManagerFactory(DOCTOR_GREEN);
		em = factory.createEntityManager();
	}

	public List<Patient> getPatientList() {
		createFactory();
		Query q = em.createQuery("select p from Patient p");
		List<Patient> patientList = q.getResultList();

		return patientList;
	}

	public void savePatient(Patient patient) {
		createFactory();
		try {
			em.getTransaction().begin();
			em.persist(patient);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
		}
	}

	public List<PatientCase> getPatientCaseList() {
		createFactory();
		Query q = em.createQuery("select pc from PatientCase pc");
		List<PatientCase> patientCaseList = q.getResultList();
		return patientCaseList;
	}
}
