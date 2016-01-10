package ch.bfh.btx8081.w2015.green.doctorGreen.statepattern;

public class PatientStateVeryDangerous extends PatientState{
	
	  // PatientStateDangerous Variables
		//--------------------------------------------------------------------------------
		
		private final String CSS = "patientStateVeryDangerous";
		private final int STATE_ID = 3;
		private final String NAME = "VeryDangerous";

		// PatientStateDangerous Constructor
		//--------------------------------------------------------------------------------
		
		/**
		 * The constructor for the state "dangerous"
		 * Sets the css, the id and the state name to abstract parent class.
		 */
		public PatientStateVeryDangerous() {
			super.setColor(CSS);
			super.setPatientStateId(STATE_ID);
			super.setPatientStateName(NAME);
		}

}
