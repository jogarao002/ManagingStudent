package com.intellect.reportManagement.serviceImpl;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.reportManagement.binding.SignUpForm;
import com.intellect.reportManagement.entity.UserDtlsEntity;
import com.intellect.reportManagement.repository.UserDtlsRepo;
import com.intellect.reportManagement.service.UserService;
import com.intellect.reportManagement.util.EmailUtils;
import com.intellect.reportManagement.util.PwdUtils;

@Service
public class UserServiceImpl implements UserService {
	
	private static String STATUS = "LOCKED";
	
	@Autowired
	private EmailUtils emailUtil;
	
	@Autowired
	private UserDtlsRepo userDtlsRepo;

	@Override
	public boolean getSignupDetails(SignUpForm signUpForm) throws MessagingException {
		
		UserDtlsEntity dtlsEntity = userDtlsRepo.findByUserEmail(signUpForm.getUserEmail());
		UserDtlsEntity userDtlsEntity = new UserDtlsEntity();
		String password = PwdUtils.genaratePassword();
		userDtlsEntity.setUserPassword(password);
		userDtlsEntity.setAccountStatus(STATUS);
		BeanUtils.copyProperties(signUpForm, userDtlsEntity);
		
		if(dtlsEntity != null) {
			return false;
		}
		userDtlsRepo.save(userDtlsEntity);
		String to = signUpForm.getUserEmail();
		String subject = "Unlock your account";
		StringBuilder body = new StringBuilder();
		body.append("<h2>Hi " + signUpForm.getUserName() + "</h2>");
		body.append("<br>");
		body.append("<h3>Below is for UNLOCK your Account, to login use the below temporary password</h3>");
		body.append("<br>");
		body.append("Temporary password: " + password);
		body.append("<br>");
		body.append("<a href=\"http://localhost:8080/unlock?" + signUpForm.getUserEmail() + "\">Use this link to unlock your Account</a>");
		body.append("<br>");
		body.append("<br>");
		body.append("Thanks,");
		body.append("<br>");
		body.append("B.Jogarao.");
		
		boolean sendEmail = emailUtil.sendEmail(to, subject, body.toString());
		if(sendEmail) {
			return true;
		}
		return false;
	}

}
