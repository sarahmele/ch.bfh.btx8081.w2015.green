
@Entity
@DiscriminatorValue("S")
@Table(name="Status")
public class Status {
	@statusDate
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String statusDate;

	protected String statusText;


	@OneToMany
	protected PatientCase patientCase;

	public String getStatusDate() {
		return statusDate;
	}

	public vostatusDate setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatusText() {
		return statusText;
	}

	public vostatusDate setStatusText(String statusText) {
		this.statusText = statusText;
	}

}