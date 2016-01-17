package ch.bfh.btx8081.w2015.green.doctorGreen.statepattern;

/**
 * class for the Patient State "Dangerous" of a Patient in the Doctor Green Application <br>
 * <br>
 * 
 * @author Sarah Mele<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - int STATE_ID<br>
 *         - String NAME<br>
 */

public class PatientStateDangerous extends PatientState {

    // PatientStateDangerous Variables
	//--------------------------------------------------------------------------------
	private final int STATE_ID = 2;
	private final String NAME = "Dangerous";

	/**
	 * PatientStateDangerous constructor<br>
	 * Sets the id and the state name to abstract parent class
	 * <br>
	 *
	 * @param none
	 */
	public PatientStateDangerous() {
		super.setPatientStateId(STATE_ID);
		super.setPatientStateName(NAME);
	}
}
