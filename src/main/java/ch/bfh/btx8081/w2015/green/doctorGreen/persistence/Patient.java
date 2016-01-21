package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Patient extends Person {

	@Column
	private String insuranceNb;

	@ManyToOne
	private State state;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DOCTOR_PATIENT", joinColumns = @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "pid") , inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "pid") )
	private List<Doctor> doctorList;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PATIENT_CASE", joinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "pid") , inverseJoinColumns = @JoinColumn(name = "PATIENT_CASE_ID", referencedColumnName = "patientCaseId") )
	private List<PatientCase> patientCaseList;

	public String getInsuranceNb() {
		return insuranceNb;
	}

	public void setInsuranceNb(String insuranceNb) { 
		this.insuranceNb = insuranceNb;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	public void setPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCaseList = patientCaseList;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}