package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUnit {
	private final String DOCTOR_GREEN = "doctorgreen";

	private static PersistenceUnit instance = null;

	public static PersistenceUnit getInstance() {
		if (instance == null) {
			instance = new PersistenceUnit();
		}
		return instance;
	}

	EntityManagerFactory factory = Persistence.createEntityManagerFactory(DOCTOR_GREEN);
	EntityManager em = factory.createEntityManager();

	Patient patient = new Patient();

	public void setPatient() {
		patient.setFirstName("Hans");
		patient.setLastName("Muster");
		persistObject(patient);
	}

	public void persistObject(Object object) {
		em.persist(object);
		em.close();
	}
}
