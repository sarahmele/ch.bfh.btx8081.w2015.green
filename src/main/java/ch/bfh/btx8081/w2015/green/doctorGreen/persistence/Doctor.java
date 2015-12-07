package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("D")
@Table(name="Doctor")
public class Doctor extends Person {
	
	protected Date 		empDate;
	protected String	title;
	protected String	username;
	protected String	password;

	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Message message;

	@OneToMany(mappedBy = "Doctor")
	private final List<Patient> patients = new ArrayList<Patient>();

	@OneToMany(mappedBy = "Doctor")
	private final List<Message> messages = new ArrayList<Message>();
	
	public List<Patient> getPatients() {
		return patients;
	}

	public void removePatient(Patient p) {
		patients.remove(p);
	}

	public void addPatient(Patient p) {
		patients.add(p);
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void removeMessage(Message m) {
		messages.remove(m);
	}

	public void addMessage(Message m) {
		messages.add(m);
	}
	
	public Date getEmpDate() {
		return empDate;
	}
	
	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}