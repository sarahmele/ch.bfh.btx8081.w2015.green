package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

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
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Date messageDate;

	protected String messageText;
	
	protected String messageStatus;

	@ManyToOne
	protected Patient patient;
	
	@ManyToOne
	protected Doctor doctor;

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	

}