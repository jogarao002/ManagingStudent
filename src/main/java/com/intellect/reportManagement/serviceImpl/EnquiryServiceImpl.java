package com.intellect.reportManagement.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.reportManagement.binding.DashboardResponse;
import com.intellect.reportManagement.binding.EnquiryForm;
import com.intellect.reportManagement.entity.CourseEntity;
import com.intellect.reportManagement.entity.EnqStatusEntity;
import com.intellect.reportManagement.entity.StudentEnqEntity;
import com.intellect.reportManagement.entity.UserDtlsEntity;
import com.intellect.reportManagement.repository.CourseRepo;
import com.intellect.reportManagement.repository.EnqStatusRepo;
import com.intellect.reportManagement.repository.StudentEnqRepo;
import com.intellect.reportManagement.repository.UserDtlsRepo;
import com.intellect.reportManagement.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private UserDtlsRepo userDtlsRepo;
	
	@Autowired
	private StudentEnqRepo studentEnqRepo;

	@Autowired
	private EnqStatusRepo enqStatusRepo;

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private HttpSession session;

	@Override
	public DashboardResponse getDashBoardDetails(Integer userId) {

		DashboardResponse response = new DashboardResponse();

		Optional<UserDtlsEntity> optUserDtlsEntity = userDtlsRepo.findById(userId);
		if (optUserDtlsEntity.isPresent()) {
			UserDtlsEntity userDtlsEntity = optUserDtlsEntity.get();
			List<StudentEnqEntity> studentEnquiries = userDtlsEntity.getStudentEnquiries();
			Integer totalCount = studentEnquiries.size();

			Integer entrolledCount = studentEnquiries.stream().filter(e -> e.getCourseStatus().equals("ENTROLLED"))
					.collect(Collectors.toList()).size();

			Integer lostCount = studentEnquiries.stream().filter(e -> e.getCourseStatus().equals("LOST"))
					.collect(Collectors.toList()).size();

			response.setTotalCount(totalCount);
			response.setEntrolled(entrolledCount);
			response.setLost(lostCount);
		}
		return response;
	}

	@Override
	public List<String> getCourses() {
		List<CourseEntity> courseEntityList = courseRepo.findAll();
		if (courseEntityList != null && !courseEntityList.isEmpty()) {
			return courseEntityList.stream().map(CourseEntity::getCourseName) 
					.collect(Collectors.toList());
		} else {
			return Collections.emptyList(); 
		}
	}

	@Override
	public List<String> getCourseStatus() {
		List<EnqStatusEntity> enqStatusEntityList = enqStatusRepo.findAll();
		if(null != enqStatusEntityList && !enqStatusEntityList.isEmpty()) {
			return enqStatusEntityList.stream().map(EnqStatusEntity::getStatusName)
					.collect(Collectors.toList());
		}
		return Collections.emptyList(); 
	}

	@Override
	public boolean saveEnquriry(EnquiryForm form) {
		
		StudentEnqEntity studentEnqEntity = new StudentEnqEntity();
		BeanUtils.copyProperties(form, studentEnqEntity);
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		UserDtlsEntity userDtlsEntity = userDtlsRepo.findById(userId).get();
		
		studentEnqEntity.setUser(userDtlsEntity);
		studentEnqRepo.save(studentEnqEntity);
		return true;
	}

	@Override
	public List<StudentEnqEntity> getAllEnquiries() {
		Integer userId = (Integer)session.getAttribute("userId");
		Optional<UserDtlsEntity> optUserDtlsEntity = userDtlsRepo.findById(userId);
		if(optUserDtlsEntity.isPresent()) {
			UserDtlsEntity userDtlsEntity = optUserDtlsEntity.get();
			List<StudentEnqEntity> studentEnquiries = userDtlsEntity.getStudentEnquiries();
			return studentEnquiries;
		}
		return null;
	}


}
