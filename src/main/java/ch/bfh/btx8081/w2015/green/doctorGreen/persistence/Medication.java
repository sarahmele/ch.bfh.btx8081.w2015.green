package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class describes the "Medication" Table for the Database<br>
 * <br>
 * 
 * @author Shpend Vladi, Luca Ramos<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - String description<br>
 *         - id medicationId<br>
 */

@Entity
public class Medication {

	// All Attributes
	//--------------------------------------------------------------------------------
	@Id
	@GeneratedValue
	private int medicationId;
	@Column
	private String description;

}
