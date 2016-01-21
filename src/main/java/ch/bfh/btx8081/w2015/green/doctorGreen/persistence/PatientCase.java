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

/**
 * This class describes the "PatientCase" Table for the Database<br>
 * <br>
 * 
 * @author Shpend Vladi, Luca Ramos<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - int patientCaseId<br>
 *         - String anamnesis<br>
 *         - String diagnosis<br>
 *         - Date fromDate<br>
 *         - Date toDate<br>
 *         - List treatmentList<br>
 * <br>
 *         Methods:<br>
 *         - getAnamnesis() returns String<br>
 *         - getDiagnosis() returns String<br>
 *         - getPatient() returns Patient<br>
 *         - getPatientCaseId() returns int<br>
 *         - getFromDate() returns Date<br>
 *         - getToDate() returns Date<br>
 *         - getTreatmentList() returns List<br>
 *<br>
 *         - setAnamnesis(String)<br>
 *         - setDiagnosis(String)<br>
 *         - setPatient(Patient)<br>
 *         - setPatientCaseId(int)<br>
 *         - getFromDate(Date)<br>
 *         - getToDate(Date)<br>
 *         - getTreatmentList(List)<br>
 */

@Entity
public class PatientCase {
	
	// All Attributes
	//--------------------------------------------------------------------------------
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
	
	/**
	 * getPatientCaseId Method<br>
	 * The function to get the Patient Case Id<br><br>
	 * 
	 * @param none<br>
	 * @return int - Patient Case Id
	 *   
	 */
	public int getPatientCaseId() {
		return patientCaseId;
	}
	
	/**
	 * setPatientCaseId Method<br>
	 * The function to set the PatientCaseId<br><br>
	 * @param int - patientCaseId
	 *   
	 */
	public void setPatientCaseId(int patientCaseId) {
		this.patientCaseId = patientCaseId;
	}
	
	/**
	 * getFromDate Method<br>
	 * The function to get the FromDate from the Patient Case<br><br>
	 * 
	 * @param none<br>
	 * @return Date - from Date
	 *   
	 */
	public Date getFromDate() {
		return fromDate;
	}
	
	/**
	 * setFromDate Method<br>
	 * The function to set the from Date<br><br>
	 * @param date - from Date
	 *   
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * getPatientCaseId Method<br>
	 * The function to get the to date<br><br>
	 * 
	 * @param none<br>
	 * @return date - to date
	 *   
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * setToDate Method<br>
	 * The function to set the to date<br><br>
	 * @param Date - to Date
	 *   
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * getAnamnesis Method<br>
	 * The function to get the Anamnesis<br><br>
	 * 
	 * @param none<br>
	 * @return string - Anamnese
	 *   
	 */
	public String getAnamnesis() {
		return anamnesis;
	}
	
	/**
	 * setAnamnesis Method<br>
	 * The function to set the Anamnesis <br><br>
	 * @param String - anamnesis
	 *   
	 */
	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}

	/**
	 * getDiagnosis Method<br>
	 * The function to get the Diagnosis<br><br>
	 * 
	 * @param none<br>
	 * @return string - diagnosis
	 *   
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * setDiagnosis Method<br>
	 * The function to set the Diagnosis<br><br>
	 * @param String - diagnosis
	 *   
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * getTreatmentList Method<br>
	 * The function to get the treatment list<br><br>
	 * 
	 * @param none<br>
	 * @return List - treatments
	 *   
	 */
	public List<Treatment> getTreatmentList() {
		return treatmentList;
	}

	/**
	 * setTreatmentList Method<br>
	 * The function to set the treatment<br><br>
	 * @param List - treatment
	 *   
	 */
	public void setTreatmentList(List<Treatment> treatmentList) {
		this.treatmentList = treatmentList;
	}

	/**
	 * getPatient Method<br>
	 * The function to get the Patient<br><br>
	 * 
	 * @param none<br>
	 * @return Patient - Patient
	 *   
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * setPatient Method<br>
	 * The function to set the Patient<br><br>
	 * @param Patient - patient
	 *   
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}