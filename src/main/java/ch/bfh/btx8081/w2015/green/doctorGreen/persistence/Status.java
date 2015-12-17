package ch.bfh.btx8081.w2015.green.doctorGreen.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Status {
	@Id
	@GeneratedValue
	private int statusId;
	@Column
	private String status;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusbyId(int statusId) {
		if (statusId == 3) {
			return "sehr gefährlich";
		} else if (statusId == 2) {
			return "gefährlich";
		} else {
			return "ungefährlich";
		}
	}

}