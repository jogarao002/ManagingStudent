package com.intellect.reportManagement.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.intellect.reportManagement.binding.LoginForm;
import com.intellect.reportManagement.binding.SignUpForm;
import com.intellect.reportManagement.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("login", new LoginForm());
		return "login";
	}
	
	@GetMapping("/signup")
	public String getSignupPage(Model model) {
	    model.addAttribute("signUpForm", new SignUpForm());
	    return "signup";
	}

	@PostMapping("/register")
    public String processSignupForm(@ModelAttribute("signUpForm") SignUpForm signUpForm, Model model) {
        //System.out.println("Received form data: " + signUpForm);
		try {
			boolean signupDetails = userService.getSignupDetails(signUpForm);
			if(signupDetails) {
				model.addAttribute("successMessage", "Please Check Your Mail");
			}else {
				model.addAttribute("errorMessage", "Unique Email Enter");
			}
			
		} catch (MessagingException e) {
			model.addAttribute("errorMessage", "Error processing your request");
			e.printStackTrace();
		}
        return "redirect:/signup"; 
    }
	
}
