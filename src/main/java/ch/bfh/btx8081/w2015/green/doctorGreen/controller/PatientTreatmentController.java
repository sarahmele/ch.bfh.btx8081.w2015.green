package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.PatientCase;
import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Treatment;

/**
 * Controller class that manages all treatment related patient data
 * 
 * @author Luca
 *
 */
public class PatientTreatmentController {
	
	private final String DOCTOR_GREEN = "doctorgreen";
	EntityManagerFactory factory;
	EntityManager em;

	private static PatientTreatmentController instance = null;

	public static PatientTreatmentController getInstance() {
		if (instance == null) {
			instance = new PatientTreatmentController();
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
	 * Saves the the treatment data in the database 
	 * 
	 * @param treatment
	 */
	public void saveTreatment(Treatment treatment) {
		createFactory();
		try {
			em.getTransaction().begin();
			
			Treatment dbTreatment = em.find(Treatment.class, treatment.getTreatmentId());
			dbTreatment.setDate(treatment.getDate());
			dbTreatment.setDescription(treatment.getDescription());
			
			
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
		}
	}


	/**
	 * Returns all the treatments of a case
	 * 
	 * @return treatmentList
	 */
	public List<PatientCase> getTreatmentList() {
		createFactory();
		Query q = em.createQuery("select treatment from Treatment treatment");
		List<PatientCase> treatmentList = q.getResultList();
		return treatmentList;
	}
	
}
