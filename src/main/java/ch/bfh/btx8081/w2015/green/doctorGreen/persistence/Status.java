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