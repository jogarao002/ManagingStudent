package com.intellect.reportManagement.binding;

public class SignUpForm {
	
	private String userName;
	
	private String userEmail;
	
	private String userPhoneNumber;

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

	@Override
	public String toString() {
		return "SignUpForm [userName=" + userName + ", userEmail=" + userEmail + ", userPhoneNumber=" + userPhoneNumber
				+ "]";
	}
	
}
