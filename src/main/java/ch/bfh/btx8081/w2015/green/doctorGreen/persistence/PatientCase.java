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
@DiscriminatorValue("PC")
@Table(name="PatientCase")
public class PatientCase {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private	  String	caseNb;
	
	protected Date 		fromtDate;
	protected Date		toDate;
	protected String	anamnesis;
	protected String	diagnosis;

	@ManyToOne
	private Patient patient;
	
	//@ManyToOne
	//private Treatment treatment;
	
	//@ManyToOne
	//private String status;
	
	private Date fromDate;
	
	@OneToMany(mappedBy = "PatientCase")
	private final List<Treatment> treatments = new ArrayList<Treatment>();
	
	@OneToMany(mappedBy = "PatientCase")
	private final List<Status> status = new ArrayList<Status>();
	
	public List<Treatment> getTreatment() {
		return treatments;
	}

	public void removeTreatment(Treatment t) {
		treatments.remove(t);
	}

	public void addTreatment(Treatment t) {
		treatments.add(t);
	}
	
	public List<Status> getStatus() {
		return status;
	}

	public void removeStatus(Status s) {
		status.remove(s);
	}

	public void addStatus(Status s) {
		status.add(s);
	}
	
	
	public String getCaseNb() {
		return caseNb;
	}
	
	public void setCaseNb(String caseNb) {
		this.caseNb = caseNb;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public String getAnamnesis() {
		return anamnesis;
	}
	
	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
}