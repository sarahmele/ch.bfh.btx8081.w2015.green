package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.bfh.btx8081.w2015.green.doctorGreen.persistence.Patient;

public class PatientCaseController {
	
	private final String DOCTOR_GREEN = "doctorgreen";
	private static PatientCaseController instance = null;
	
	public PatientCaseController() {	
	    em = Persistence.createEntityManagerFactory(DOCTOR_GREEN).createEntityManager();
	  }

	public static PatientCaseController getInstance() {
		if (instance == null) {
			instance = new PatientCaseController();
		}
		return instance;
	}
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory(DOCTOR_GREEN);
	EntityManager em = factory.createEntityManager();
	
	public List<String> getPatientFirstname(String pid) {
	    Query query= em.createQuery("select FIRSTNAME from PERSON where PID ="+pid);
	    List<String> results = query.getResultList();
	    
		return results;
	}
	
	
	public static void main(String[] args) {
		PatientCaseController pC = new PatientCaseController();	    
	  }

}
