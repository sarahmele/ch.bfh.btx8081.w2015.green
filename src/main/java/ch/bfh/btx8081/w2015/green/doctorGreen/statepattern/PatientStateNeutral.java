package ch.bfh.btx8081.w2015.green.doctorGreen.statepattern;

/**
 * class for the Patient State "Harmless" of a Patient in the Doctor Green Application <br>
 * <br>
 * 
 * @author Sarah Mele<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - int STATE_ID<br>
 *         - String NAME<br>
 */

public class PatientStateNeutral extends PatientState {
	
    // PatientStateNeutral Variables
	//--------------------------------------------------------------------------------
	private final int STATE_ID = 1;
	private final String NAME = "Harmless";

	/**
	 * PatientStateNeutral constructor<br>
	 * Sets the id and the state name to abstract parent class
	 * <br>
	 *
	 * @param none
	 */
	public PatientStateNeutral() {
		super.setPatientStateId(STATE_ID);
		super.setPatientStateName(NAME);
	}
}
