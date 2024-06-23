package com.intellect.reportManagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboardpage() {
		return "dashboard";
	}
	
	@GetMapping("/enquiry")
	public String addEnquiry() {
		return "add-enquiry";
	}
	
	@GetMapping("/enquires")
	public String viewEnquiry() {
		return "view-enquiries";
	}
}
