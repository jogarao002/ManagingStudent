package com.intellect.reportManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENQUARY_STATUS_ENTITY")
public class EnqStatusEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer statusId;
	
	private String statusName;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "EnqStatusEntity [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
}
