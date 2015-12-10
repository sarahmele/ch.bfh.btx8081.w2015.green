package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medication {

	@Id
	@GeneratedValue
	private int medicationId;
	@Column
	private String description;

}
