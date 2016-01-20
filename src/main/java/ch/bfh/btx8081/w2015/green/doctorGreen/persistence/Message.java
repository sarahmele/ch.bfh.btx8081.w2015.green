package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class describes the "Message" Table for the Database<br>
 * <br>
 * 
 * @author Shpend Vladi, Luca Ramos<br>
 * <br>
 * 
 *         instance variables:<br>
 *         - id messageId<br>
 *         - String subject<br>
 *         - String text<br>
 *         - Date date<br>
 */

@Entity
public class Message {
	
	// All Attributes
	//--------------------------------------------------------------------------------
	@Id
	@GeneratedValue
	private int messageId;

	@Column
	private String subject;

	@Column
	private Date date;
	@Column
	private String text;

}