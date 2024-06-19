package com.intellect.reportManagement.service;

import javax.mail.MessagingException;

import com.intellect.reportManagement.binding.SignUpForm;

public interface UserService {
	
	boolean getSignupDetails(SignUpForm signUpForm) throws MessagingException; 
}
