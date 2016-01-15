package ch.bfh.btx8081.w2015.green.doctorGreen.statepattern;

public class PatientStateDangerous extends PatientState {

    // PatientStateDangerous Variables
	//--------------------------------------------------------------------------------
	
	private final int STATE_ID = 2;
	private final String NAME = "Dangerous";

	// PatientStateDangerous Constructor
	//--------------------------------------------------------------------------------
	
	/**
	 * The constructor for the state "dangerous"
	 * Sets the id and the state name to abstract parent class.
	 */
	public PatientStateDangerous() {
		super.setPatientStateId(STATE_ID);
		super.setPatientStateName(NAME);
	}
}
