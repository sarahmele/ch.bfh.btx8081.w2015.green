package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {
	
	@Id
	private int stateId;

	private String name;
	
	@OneToMany(mappedBy = "state")
	private List<Patient> patientList;
	
	public int getstateId() {
		return stateId;
	}

	public void setstateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
