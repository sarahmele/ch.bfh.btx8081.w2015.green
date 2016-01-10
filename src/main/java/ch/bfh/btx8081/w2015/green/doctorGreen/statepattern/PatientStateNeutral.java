package ch.bfh.btx8081.w2015.green.doctorGreen.statepattern;

public class PatientStateNeutral extends PatientState {
	
    // PatientStateDangerous Variables
	//--------------------------------------------------------------------------------
	
	private final String CSS = "patientStateNeutral";
	private final int STATE_ID = 1;
	private final String NAME = "Neutral";

	// PatientStateDangerous Constructor
	//--------------------------------------------------------------------------------
	
	/**
	 * The constructor for the state "neutral"
	 * Sets the css, the id and the state name to abstract parent class.
	 */
	public PatientStateNeutral() {
		super.setColor(CSS);
		super.setPatientStateId(STATE_ID);
		super.setPatientStateName(NAME);
	}
}
