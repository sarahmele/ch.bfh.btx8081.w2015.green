



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