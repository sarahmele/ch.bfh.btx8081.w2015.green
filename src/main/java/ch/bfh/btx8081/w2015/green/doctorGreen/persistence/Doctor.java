package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * This class describes the "Doctor" Table for the Database<br>
 * <br>
 * 
 * @author Shpend Vladi, Luca Ramos<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - List patientList<br>
 *         - String title<br>
 * <br>
 *         Methods:<br>
 *         - getPatientList() returns List<Patient><br>
 *         - getTitle() returns String<br>
 *<br>
 *		   - setPatientList(List<Patient)<br>
 *  	   - setTitle(String)<br>
 */

@Entity
public class Doctor extends Person {
	
	// All Attributes
	//--------------------------------------------------------------------------------
	@Column
	private String title;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DOCTOR_PATIENT", joinColumns = @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "pid") , inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "pid") )
	private List<Patient> patientList;
	
	
	/**
	 * getTitle Method<br>
	 * The function to get the title<br><br>
	 * 
	 * @param none<br>
	 * @return title - String<Patient>
	 *   
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * setTitle Method<br>
	 * The function to set the Title<br><br>
	 * @param title - String<Patient>
	 *   
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * getPatientList Method<br>
	 * The function to get the Patient List<br><br>
	 * 
	 * @param none<br>
	 * @return patientList - List<Patient>
	 *   
	 */
	public List<Patient> getPatientList() {
		return patientList;
	}
	
	/**
	 * setPatientList Method<br>
	 * The function to set the PatientList<br><br>
	 * @param patientList - List<Patient>
	 *   
	 */
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

}