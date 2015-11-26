package Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("M")
@Table(name="Message")
public class Message {
	@messageDate
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String messageDate;

	protected String messageText;
	
	protected String messageStatus;

	@ManyToOne
	protected Patient patient;
	
	@ManyToOne
	protected Doctor doctor;

	public String getMessageDate() {
		return messageDate;
	}

	public vomessageDate setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessageText() {
		return messageText;
	}

	public vomessageDate setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	public String getMessageStatus() {
		return messageDate;
	}

	public vomessageDate setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	

}