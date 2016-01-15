package ch.bfh.btx8081.w2015.green.doctorGreen.statepattern;

public abstract class PatientState {
	
	// PatientState Variables
	//--------------------------------------------------------------------------------
	
	private String css = "";
	private int id;
	private String name = "";
	
	// StateEvents
	//--------------------------------------------------------------------------------
	
	/**
	 * Function which is called on enter the state.
	 * --DO: NOTHING
	 */
	public void doEnter(){}
	
	/**
	 * Function which is executed while in state
	 * --DO: NOTHING
	 */
	public void doWhile(){}
	
	/**
	 * Function which is executed on exit the state
	 * --DO: NOTHING
	 */
	public void doExit(){}
	
	// State Setter
	//--------------------------------------------------------------------------------
	
	/**
	 * The function to set the id (int)
	 * @param id: int for the identification of the sate
	 */
	protected void setPatientStateId(int id){
		this.id = id;
	}

	/**
	 * The function to set the name string
	 * @param n: String for the name of the state (to show in gui)
	 */
	protected void setPatientStateName(String n){
		name = n;
	}
	
	// State Getter
	//--------------------------------------------------------------------------------
	
	/**
	 * The function to get the id (int)
	 * @return id: int for the identification of the sate
	 */
	public int getPatientStateId(){
		return id;
	}
	
	/**
	 * The function to get the name string
	 * @return name: String for the name of the state (to show in gui)
	 */
	public String getPatientStateName(){
		return name;
	}
	
	
	@Override
	public String toString(){
		return name;
		
	}

}
