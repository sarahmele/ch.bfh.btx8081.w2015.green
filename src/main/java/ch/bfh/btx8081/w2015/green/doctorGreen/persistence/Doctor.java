package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Doctor extends Person {

	@Column
	private String title;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DOCTOR_PATIENT", joinColumns = @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "pid") , inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "pid") )
	private List<Patient> patientList;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

}