package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUnit {
	private final String DOCTOR_GREEN = "doctorgreen";
	EntityManagerFactory factory;
	EntityManager em;

	public void persist() {
		factory = Persistence.createEntityManagerFactory(DOCTOR_GREEN);
		em = factory.createEntityManager();
	}
}
