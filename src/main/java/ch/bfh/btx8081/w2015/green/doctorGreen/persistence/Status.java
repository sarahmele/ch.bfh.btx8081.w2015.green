package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {
	@Id
	@GeneratedValue
	private int statusId;
	@Column
	private String status;
	@Column
	private String risk;

	@OneToMany
	private List<PatientCaseStatus> patientCaseStatusList;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public List<PatientCaseStatus> getPatientCaseStatusList() {
		return patientCaseStatusList;
	}

	public void setPatientCaseStatusList(List<PatientCaseStatus> patientCaseStatusList) {
		this.patientCaseStatusList = patientCaseStatusList;
	}

}