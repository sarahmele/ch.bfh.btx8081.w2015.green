package Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Inheritance(strateg=InheritanceType.JOINED)
@DiscriminatorColumn(name="Person_Type")
@Table(name="PERSON")
public class Person {
	@pid
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String pid;

	protected String firstName;
	protected String lastName;
	protected String gender;
	protected String birthDate;

	@OneToOne
	protected Address address;

	public String getPid() {
		return pid;
	}

	public vopid setPid(String pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public vopid setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public vopid setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public vopid setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public vopid setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public vopid setAddress(Address address) {
		this.address = address;
	}
}