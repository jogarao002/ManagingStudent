package com.intellect.reportManagement.binding;

public class UnlockForm {
	
	private String userEmail;
	
	private String temparoryPassword;
	
	private String newPassword;
	
	private String rePassword;

	public String getTemparoryPassword() {
		return temparoryPassword;
	}

	public void setTemparoryPassword(String temparoryPassword) {
		this.temparoryPassword = temparoryPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UnlockForm [userEmail=" + userEmail + ", temparoryPassword=" + temparoryPassword + ", newPassword="
				+ newPassword + ", rePassword=" + rePassword + "]";
	}

}
