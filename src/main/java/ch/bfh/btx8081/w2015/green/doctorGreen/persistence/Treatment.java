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
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Date treatmentDate;
	
	@ManyToOne
	private PatientCase patientCase;
	
	
	private int duration; // in minutes
	
	private String treatmentPlan;
	private String medication;


	public Date getTreatmentDate() {
		return treatmentDate;
	}

	public void setTreatmentDate(Date id) {
		this.treatmentDate = treatmentDate;
	}

	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatientCase(PatientCase patientCase) {
		this.patientCase = patientCase;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTreatmentPlan() {
		return treatmentPlan;
	}
	
	public void setTreatmentPlan(String treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}
	
	public String getMedication() {
		return medication;
	}
	
	public void setTreatmentPlan(String medication) {
		this.medication = medication;
	}
	
}
