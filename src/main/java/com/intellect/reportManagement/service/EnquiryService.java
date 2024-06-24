package com.intellect.reportManagement.service;

import java.util.List;

import com.intellect.reportManagement.binding.DashboardResponse;
import com.intellect.reportManagement.binding.EnquiryForm;

public interface EnquiryService {

	DashboardResponse getDashBoardDetails(Integer userId);

	List<String> getCourses();

	List<String> getCourseStatus();
	
	boolean saveEnquriry(EnquiryForm form);
	
}
