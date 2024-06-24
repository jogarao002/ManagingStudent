package com.intellect.reportManagement.controller;


import javax.mail.MessagingException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intellect.reportManagement.binding.LoginForm;
import com.intellect.reportManagement.binding.UnlockForm;
import com.intellect.reportManagement.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/unlock")
	public String getUnlockPage(@RequestParam String email, Model model) {
		UnlockForm unlockForm = new UnlockForm();
		unlockForm.setUserEmail(email);
		model.addAttribute("unlock", unlockForm);
		return "unlock";
	}

	@PostMapping("/unlock")
	public String unlockUserAccount(@ModelAttribute("unlock") UnlockForm unlock, Model model) {
		// System.out.println(unlock);
		String status = userService.getUnlockAccount(unlock);
		model.addAttribute("msg", status);
		return "unlock";
	}
	
	@GetMapping("/forgotPwd")
	public String forgetPwd() {
		return "forgotPwd";
	}
	
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam("email") String email, Model model) throws MessagingException {
		//System.out.println(email);
		boolean status = userService.getForgotPassword(email);
		if(status) {
			model.addAttribute("success", "Check your mail");
		} else {
			model.addAttribute("error", "inavalid email");
		}
		return "forgotPwd";
	}

	@PostMapping("/login")
	public String loginPage(@ModelAttribute("login") LoginForm loginForm, Model model) {
	    try {
	        String status = userService.getloginAccount(loginForm);
	        if (status.equals("Account logged successfully")) {
	            return "redirect:/dashboard"; 
	        	//System.out.println("iam redirect to dashboard");
	        }
	        model.addAttribute("error", status);
	    } catch (Exception e) {
	        model.addAttribute("error", "Failed to login: " + e.getMessage());
	    }
	    return "login";
	}

}
