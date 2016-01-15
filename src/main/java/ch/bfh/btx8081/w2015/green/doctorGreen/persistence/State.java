package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class State {
	@Id
	private int id;

	private String name;

	@ManyToOne
	private Patient patient;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
