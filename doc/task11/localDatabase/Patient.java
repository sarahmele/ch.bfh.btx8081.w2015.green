



@Entity
@DiscriminatorValue("P")
@Table(name="PATIENT")
public class Patient extends Person {

	@ManyToOne
	private Insurance insurance;

	@OneToMany(mappedBy = "patient")
	private final List<PatientCase> cases = new ArrayList<PatientCase>();

	@OneToMany(mappedBy = "patient")
	private final List<Treatment> treatments = new ArrayList<Treatment>();
	
	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<PatientCase> getPatientCases() {
		return cases;
	}

	public void removePatientCase(PatientCase p) {
		cases.remove(p);
	}

	public void addPatientCase(PatientCase p) {
		cases.add(p);
	}
	
	public List<Treatment> getTreatment() {
		return treatments;
	}

	public void removeTreatment(Treatment p) {
		treatments.remove(p);
	}

	public void addTreatment(Treatment p) {
		treatments.add(p);
	}
}