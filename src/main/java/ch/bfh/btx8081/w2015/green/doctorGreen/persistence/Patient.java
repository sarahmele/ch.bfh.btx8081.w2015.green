package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;



@Entity
@DiscriminatorValue("P")
@Table(name="PATIENT")
public class Patient extends Person {


	@OneToMany(mappedBy = "patient")
	private final List<PatientCase> cases = new ArrayList<PatientCase>();

	@OneToMany(mappedBy = "patient")
	private final List<Treatment> treatments = new ArrayList<Treatment>();
	

	public List<PatientCase> getPatientCases() {
		return cases;
	}

	public void removePatientCase(PatientCase p) {
		cases.remove(p);
	}

	public void addPatientCase(PatientCase p) {
		cases.add(p);
	}
	
	public List<Treatment> getTreatment() {
		return treatments;
	}

	public void removeTreatment(Treatment p) {
		treatments.remove(p);
	}

	public void addTreatment(Treatment p) {
		treatments.add(p);
	}
}