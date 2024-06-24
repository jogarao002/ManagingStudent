package com.intellect.reportManagement.service;

import javax.mail.MessagingException;

import com.intellect.reportManagement.binding.LoginForm;
import com.intellect.reportManagement.binding.SignUpForm;
import com.intellect.reportManagement.binding.UnlockForm;

public interface UserService {
	
	boolean getSignupDetails(SignUpForm signUpForm) throws MessagingException;

	String getUnlockAccount(UnlockForm unlock);

	String getloginAccount(LoginForm loginForm);

	boolean getForgotPassword(String email) throws MessagingException; 
	
}
