package com.intellect.reportManagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.intellect.reportManagement.binding.DashboardResponse;
import com.intellect.reportManagement.binding.EnquiryForm;
import com.intellect.reportManagement.service.EnquiryService;

@Controller
public class EnquiryController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private EnquiryService enquiryService;
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboardpage(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		DashboardResponse dashboardResponse = enquiryService.getDashBoardDetails(userId);
		
		model.addAttribute("dashboardResponse", dashboardResponse);
		return "dashboard";
	}
	
	@GetMapping("/enquiry")
	public String addEnquiry(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");

		List<String> courses = enquiryService.getCourses();
		
		List<String> status = enquiryService.getCourseStatus();
		
		EnquiryForm formObj = new EnquiryForm();
		
		model.addAttribute("courses", courses);
		model.addAttribute("status", status);
		model.addAttribute("formObj", formObj);
		return "add-enquiry";
	}
	
	@GetMapping("/enquires")
	public String viewEnquiry() {
		return "view-enquiries";
	}
}
