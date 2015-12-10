package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PatientCaseStatus {

	@Id
	@GeneratedValue
	private int patientCaseStatusId;
	@Column
	private Date date;

	public int getPatientCaseStatusId() {
		return patientCaseStatusId;
	}

	public void setPatientCaseStatusId(int patientCaseStatusId) {
		this.patientCaseStatusId = patientCaseStatusId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@OneToOne
	private Status status;

}
