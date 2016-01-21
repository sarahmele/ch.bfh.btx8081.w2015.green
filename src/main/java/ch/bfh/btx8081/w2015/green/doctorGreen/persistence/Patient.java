package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * This class describes the "Address" Table for the Database<br>
 * <br>
 * 
 * @author Shpend Vladi, Luca Ramos<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - List<Doctor> doctorList<br>
 *         - String insuranceNb<br>
 *         - List<PatientCaseList> patientCaseList<br>
 *         - int state<br>
 * <br>
 *         Methods:<br>
 *         - getDoctorList() returns List<br>
 *         - getInsuranceNb() returns String<br>
 *         - getPatientCaseList() returns List<br>
 *         - getState() returns state<br>
 *<br>
 *         - setDoctorList(List)<br>
 *         - setInsuranceNb(String)<br>
 *         - setPatientCaseList(List)<br>
 *         - setState(State)<br>
 */


@Entity
public class Patient extends Person {

	// All Attributes
	//--------------------------------------------------------------------------------
	@Column
	private String insuranceNb;

	@ManyToOne
	private State state;

	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DOCTOR_PATIENT", joinColumns = @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "pid") , inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "pid") )
	private List<Doctor> doctorList;

	@OneToMany
	private List<PatientCase> patientCaseList;
	
	/**
	 * getInsuranceNb Method<br>
	 * The function to get the Insurance Number<br><br>
	 * 
	 * @param none<br>
	 * @return String - insuranceNumber
	 *   
	 */
	public String getInsuranceNb() {
		return insuranceNb;
	}
	
	/**
	 * setInsuranceNb Method<br>
	 * The function to set the Insurance Number<br><br>
	 * @param String - insuranceNb
	 *   
	 */
	public void setInsuranceNb(String insuranceNb) {
		this.insuranceNb = insuranceNb;
	}

	/**
	 * getDoctorList Method<br>
	 * The function to get the Doctors<br><br>
	 * 
	 * @param none<br>
	 * @return List - Doctors
	 *   
	 */
	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	/**
	 * setDoctorList Method<br>
	 * The function to set the Doctors<br><br>
	 * @param List - Doctors
	 *   
	 */
	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	
	/**
	 * getPatientCaseList Method<br>
	 * The function to get the PatientCases<br><br>
	 * 
	 * @param none<br>
	 * @return List - Patient Cases
	 *   
	 */
	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	/**
	 * setPatientCaseList Method<br>
	 * The function to set the Patient Cases<br><br>
	 * @param List - Patient Cases
	 *   
	 */
	public void setPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCaseList = patientCaseList;
	}

	/**
	 * getState Method<br>
	 * The function to get the State<br><br>
	 * 
	 * @param none<br>
	 * @return State - state
	 *   
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * setState Method<br>
	 * The function to set the State<br><br>
	 * @param state - State
	 *   
	 */
	public void setState(State state) {
		this.state = state;
	}

}