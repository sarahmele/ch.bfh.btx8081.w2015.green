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
import javax.persistence.OneToMany;

@Entity
public class Treatment {
	@Id
	@GeneratedValue
	private Integer treatmentId;

	@OneToMany
	private List<PatientCase> patientCaseList;

	@Column
	private String description;
	@Column
	private Date date;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TREATMENT_MEDICATION", joinColumns = @JoinColumn(name = "TREATMENT_ID", referencedColumnName = "treatmentId") , inverseJoinColumns = @JoinColumn(name = "MEDICATION_ID", referencedColumnName = "medicationId") )
	private List<Medication> medicationList;

}