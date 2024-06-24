package com.intellect.reportManagement.serviceImpl;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.reportManagement.binding.LoginForm;
import com.intellect.reportManagement.binding.SignUpForm;
import com.intellect.reportManagement.binding.UnlockForm;
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
	
	@Autowired
	private HttpSession session;

	@Override
	public boolean getSignupDetails(SignUpForm signUpForm) throws MessagingException {

		UserDtlsEntity dtlsEntity = userDtlsRepo.findByUserEmail(signUpForm.getUserEmail());
		UserDtlsEntity userDtlsEntity = new UserDtlsEntity();
		String password = PwdUtils.genaratePassword();
		userDtlsEntity.setUserPassword(password);
		userDtlsEntity.setAccountStatus(STATUS);
		BeanUtils.copyProperties(signUpForm, userDtlsEntity);

		if (dtlsEntity != null) {
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
		body.append("<a href=\"http://localhost:8080/unlock?email=" + signUpForm.getUserEmail()
				+ "\">Use this link to unlock your Account</a>");
		body.append("<br>");
		body.append("<br>");
		body.append("Thanks,");
		body.append("<br>");
		body.append("B.Jogarao.");

		boolean sendEmail = emailUtil.sendEmail(to, subject, body.toString());
		if (sendEmail) {
			return true;
		}
		return false;
	}

	@Override
	public String getUnlockAccount(UnlockForm unlock) {
		if (unlock == null) {
			return "Invalid unlock request";
		}

		UserDtlsEntity userDtlsEntity = userDtlsRepo.findByUserEmail(unlock.getUserEmail());
		if (userDtlsEntity == null) {
			return "User details not found";
		}

		if (!unlock.getNewPassword().equals(unlock.getRePassword())) {
			return "New password and confirm password should match";
		}

		if (!unlock.getTemparoryPassword().equals(userDtlsEntity.getUserPassword())) {
			return "Temporary password is not correct";
		}

		userDtlsEntity.setAccountStatus("UNLOCKED");
		userDtlsEntity.setUserPassword(unlock.getNewPassword());
		userDtlsRepo.save(userDtlsEntity);

		return "Account unlocked successfully";
	}

	@Override
	public String getloginAccount(LoginForm loginForm) {
		try {
			UserDtlsEntity userDtlsEntity = userDtlsRepo.findByUserEmail(loginForm.getUserEmail().trim());

			if (userDtlsEntity == null) {
				return "Email id not correct";
			}

			if (!loginForm.getUserEmail().equals(userDtlsEntity.getUserEmail())) {
				return "Email id not correct";
			}

			if (userDtlsEntity.getAccountStatus().equals("LOCKED")) {
				return "Email is there, but Account is locked. Please check your mail to unlock it";
			}

			session.setAttribute("userId", userDtlsEntity.getUserId());
			return "Account logged successfully";
		} catch (Exception e) {
			e.printStackTrace(); 
			return "An error occurred while processing your request";
		}
	}

	@Override
	public boolean getForgotPassword(String email) throws MessagingException {
		UserDtlsEntity userDtlsEntity = userDtlsRepo.findByUserEmail(email);
		if(null != userDtlsEntity) {
			
			String to = email;
			String password = userDtlsEntity.getUserPassword();
			
			String subject = "forgot password";
			StringBuilder body = new StringBuilder();
			body.append("<h2>Hi " + userDtlsEntity.getUserName() + "</h2>");
			body.append("<br>");
			body.append("<h3>Below is your password</h3>");
			body.append("<br>");
			body.append("Your password: " + password);
			body.append("<br>");
			body.append("<br>");
			body.append("Thanks,");
			body.append("<br>");
			body.append("B.Jogarao.");

			boolean sendEmail = emailUtil.sendEmail(to, subject, body.toString());
			
			if(sendEmail) {
				return true;
			}
			
		} 
		return false;
	}
	
	

}
