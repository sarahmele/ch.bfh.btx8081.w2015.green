package ch.bfh.btx8081.w2015.green.doctorGreen.statepattern;

public class PatientStateNeutral extends PatientState {
	
    // PatientStateDangerous Variables
	//--------------------------------------------------------------------------------
	
	private final int STATE_ID = 1;
	private final String NAME = "Harmless";

	// PatientStateDangerous Constructor
	//--------------------------------------------------------------------------------
	
	/**
	 * The constructor for the state "harmless"
	 * Sets the id and the state name to abstract parent class.
	 */
	public PatientStateNeutral() {
		super.setPatientStateId(STATE_ID);
		super.setPatientStateName(NAME);
	}
}
