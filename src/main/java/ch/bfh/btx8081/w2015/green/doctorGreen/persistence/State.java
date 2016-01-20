package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This class describes the "Message" Table for the Database<br>
 * <br>
 * 
 * @author Shpend Vladi, Luca Ramos<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - int stateId<br>
 *         - List<Patient> patientList<br>
 *         - String name<br>
 * <br>
 *         Methods:<br>
 *         - getName() returns String<br>
 *         - getstateId() returns int<br>
 *<br>
 *		   - setName(String)<br>
 *  	   - setStateId(int)<br>
 */

@Entity
public class State {
	
	// All Attributes
	//--------------------------------------------------------------------------------
	@Id
	private int stateId;

	private String name;
	
	@OneToMany(mappedBy = "state")
	private List<Patient> patientList;
	
	/**
	 * getstateId Method<br>
	 * The function to get the state<br><br>
	 * 
	 * @param none<br>
	 * @return int - state id
	 *   
	 */
	public int getstateId() {
		return stateId;
	}
	
	/**
	 * setstateId<br>
	 * The function to set the state Id<br><br>
	 * @param int - State Id
	 *   
	 */
	public void setstateId(int stateId) {
		this.stateId = stateId;
	}
	
	/**
	 * getName Method<br>
	 * The function to get the name<br><br>
	 * 
	 * @param none<br>
	 * @return name - String
	 *   
	 */
	public String getName() {
		return name;
	}

	/**
	 * setNameMethod<br>
	 * The function to set the name<br><br>
	 * @param name - String
	 *   
	 */
	public void setName(String name) {
		this.name = name;
	}
}
