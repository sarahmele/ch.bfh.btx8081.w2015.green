package ch.bfh.btx8081.w2015.green.doctorGreen.statepattern;

/**
 * Abstract class for the Patient State of a Patient in the Doctor Green Application <br>
 * <br>
 * 
 * @author Sarah Mele<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - int id<br>
 *         - String name<br>
 * <br>
 * 
 *         Methods:<br>
 *         - doEnter() no return value<br>
 *         - doWhile() no return value<br>
 *         - doExitr() no return value<br>
 *         
 * <br>
 * 
 *         - setPatientStateId() no return value<br>
 *         - setPatientStateName() no return value<br>
 *         
 * <br>
 * 
 *         - getPatientStateId() returns int<br>
 *         - getPatientStateName() returns String<br>
 *              
 * <br>
 * 
 *         - toString() returns String<br>
 */

public abstract class PatientState {
	
	// PatientState Variables
	//--------------------------------------------------------------------------------
	private int id;
	private String name = "";
	
	
	// StateEvents
	//--------------------------------------------------------------------------------
	
	/**
	 * doEnter Method<br>
	 * Function which is called on enter the state.<br>
	 *  * --DO: NOTHING    <br><br>
	 * @param none
	 *   
	 */
	
	public void doEnter(){}
	
	/**
	 * doWhile Method<br>
	 * Function which is called during the state.<br>
	 *  * --DO: NOTHING    <br><br>
	 * @param none
	 *   
	 */
	public void doWhile(){}
	
	/**
	 * doWhile Method<br>
	 * Function which is called on exit the state.<br>
	 *  * --DO: NOTHING    <br><br>
	 * @param none
	 *   
	 */
	public void doExit(){}
	
	
	// State Setter
	//--------------------------------------------------------------------------------
	
	/**
	 * setPatientStateId Method<br>
	 * The function to set the id (int)<br><br>
	 * @param id - int for the identification of the sate
	 *   
	 */
	protected void setPatientStateId(int id){
		this.id = id;
	}
	
	/**
	 * setPatientStateName Method<br>
	 * The function to set the name String<br><br>
	 * @param n - String for the name of the state (to show in Gui)
	 *   
	 */
	protected void setPatientStateName(String n){
		name = n;
	}
	
	// State Getter
	//--------------------------------------------------------------------------------
	
	/**
	 * getPatientStateId Method<br>
	 * The function to get the id (int)<br><br>
	 * 
	 * @param none<br>
	 * @return id - int for the identification of the sate
	 *   
	 */
	public int getPatientStateId(){
		return id;
	}
	
	/**
	 * getPatientStateName Method<br>
	 * The function to get the name string<br><br>
	 * 
	 * @param none<br>
	 * @return name - String for the name of the state (to show in gui)
	 *   
	 */
	public String getPatientStateName(){
		return name;
	}
	
	/**
	 * toString Method<br>
	 * Overriding the toString Method from the Superclass<br><br>
	 * 
	 * @param none<br>
	 * @return name - String for the name of the state (to show in gui)
	 *   
	 */
	@Override
	public String toString(){
		return name;
		
	}

}
