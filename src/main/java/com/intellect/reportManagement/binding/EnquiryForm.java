package com.intellect.reportManagement.binding;

import java.time.LocalDate;

public class EnquiryForm {
	
	private String userName;
	
	private String userPhoneNumber;
	
	private String classMode;
	
	private String course;
	
	private String courseStatus;
	
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

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
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
		return "EnquiryForm [userName=" + userName + ", userPhoneNumber=" + userPhoneNumber + ", classMode=" + classMode
				+ ", course=" + course + ", courseStatus=" + courseStatus + "]";
	}
	
}