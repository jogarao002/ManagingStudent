package com.intellect.reportManagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_ENQUARY_ENTITY")
public class StudentEnqEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentEnquaryId;
	
	private String studentName;
	
	private String phoneNumber;
	
	private String classMode;
	
	private String courseName;
	
	private String enquaryStatus;
	
	private LocalDate createdDate;
	
	private LocalDate updatedDate;

	public Integer getStudentEnquaryId() {
		return studentEnquaryId;
	}

	public void setStudentEnquaryId(Integer studentEnquaryId) {
		this.studentEnquaryId = studentEnquaryId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEnquaryStatus() {
		return enquaryStatus;
	}

	public void setEnquaryStatus(String enquaryStatus) {
		this.enquaryStatus = enquaryStatus;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "StudentEnqEntity [studentEnquaryId=" + studentEnquaryId + ", studentName=" + studentName
				+ ", phoneNumber=" + phoneNumber + ", classMode=" + classMode + ", courseName=" + courseName
				+ ", enquaryStatus=" + enquaryStatus + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
	
}