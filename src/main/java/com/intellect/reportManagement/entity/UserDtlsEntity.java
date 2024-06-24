package com.intellect.reportManagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_ENTITY")
public class UserDtlsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	private String userName;
	
	private String userEmail;
	
	private String userPhoneNumber;
	
	private String userPassword;
	
	private String accountStatus;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<StudentEnqEntity> studentEnquiries;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public List<StudentEnqEntity> getStudentEnquiries() {
		return studentEnquiries;
	}

	public void setStudentEnquiries(List<StudentEnqEntity> studentEnquiries) {
		this.studentEnquiries = studentEnquiries;
	}

	@Override
	public String toString() {
		return "UserDtlsEntity [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPhoneNumber=" + userPhoneNumber + ", userPassword=" + userPassword + ", accountStatus="
				+ accountStatus + ", studentEnquiries=" + studentEnquiries + "]";
	}

}
