package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
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