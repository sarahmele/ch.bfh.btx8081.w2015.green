

@Entity
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Date treatmentDate;
	
	@ManyToOne
	private PatientCase patientCase;
	
	
	private int duration; // in minutes
	
	private String treatmentPlan;
	private String medication;
	private boolean invoiced = false;

	public Date getTreatmentDate() {
		return treatmentDate;
	}

	public void setTreatmentDate(Date id) {
		this.treatmentDate = treatmentDate;
	}

	public PatientCase getPatientCase() {
		return patientCase;
	}

	public void setPatientCase(PatientCase patientCase) {
		this.patientCase = patientCase;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTreatmentPlan() {
		return treatmentPlan;
	}
	
	public void setTreatmentPlan(String treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}
	
	public String getMedication() {
		return medication;
	}
	
	public void setTreatmentPlan(String medication) {
		this.medication = medication;
	}
	
	public boolean isInvoiced() {
		return invoiced;
	}

	public void setInvoiced(boolean invoiced) {
		this.invoiced = invoiced;
	}
}
