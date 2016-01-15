package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUnit {
	private final String DOCTOR_GREEN = "doctorgreen";

	EntityManagerFactory factory = Persistence.createEntityManagerFactory(DOCTOR_GREEN);
	EntityManager em = factory.createEntityManager();

	public void persistObject(Object object) {
		em.persist(object);
		em.close();
	}
}
