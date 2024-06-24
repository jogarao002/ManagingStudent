package com.intellect.reportManagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "STUDENT_ENQUARY_ENTITY")
public class StudentEnqEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentEnquaryId;
	
	private String userName;
	
	private String userPhoneNumber;
	
	private String classMode;
	
	private String course;
	
	private String courseStatus;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDtlsEntity user;

	public Integer getStudentEnquaryId() {
		return studentEnquaryId;
	}

	public void setStudentEnquaryId(Integer studentEnquaryId) {
		this.studentEnquaryId = studentEnquaryId;
	}

	

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
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

	public UserDtlsEntity getUser() {
		return user;
	}

	public void setUser(UserDtlsEntity user) {
		this.user = user;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	@Override
	public String toString() {
		return "StudentEnqEntity [studentEnquaryId=" + studentEnquaryId + ", userName=" + userName
				+ ", userPhoneNumber=" + userPhoneNumber + ", classMode=" + classMode + ", course=" + course
				+ ", courseStatus=" + courseStatus + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", user=" + user + "]";
	}

}