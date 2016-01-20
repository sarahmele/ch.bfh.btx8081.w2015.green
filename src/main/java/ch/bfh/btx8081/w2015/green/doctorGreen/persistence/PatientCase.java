package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PatientCase {
	@Id
	@GeneratedValue
	private int patientCaseId;

	@Column
	private Date fromDate;
	@Column
	private Date toDate;
	@Column
	private String anamnesis;
	@Column
	private String diagnosis;

	@ManyToOne
	private Patient patient;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PATIENTCASE_TREATMENT", joinColumns = @JoinColumn(name = "PATIENTCASEID", referencedColumnName = "patientCaseId") , inverseJoinColumns = @JoinColumn(name = "TREATMENTID", referencedColumnName = "treatmentId") )
	private List<Treatment> treatmentList;

	public int getPatientCaseId() {
		return patientCaseId;
	}

	public void setPatientCaseId(int patientCaseId) {
		this.patientCaseId = patientCaseId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getAnamnesis() {
		return anamnesis;
	}

	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Treatment> getTreatmentList() {
		return treatmentList;
	}

	public void setTreatmentList(List<Treatment> treatmentList) {
		this.treatmentList = treatmentList;
	}

}