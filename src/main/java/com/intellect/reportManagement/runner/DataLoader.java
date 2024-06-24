package com.intellect.reportManagement.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.intellect.reportManagement.entity.CourseEntity;
import com.intellect.reportManagement.entity.EnqStatusEntity;
import com.intellect.reportManagement.repository.CourseRepo;
import com.intellect.reportManagement.repository.EnqStatusRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private EnqStatusRepo enqStatusRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		enqStatusRepo.deleteAll();
		
		EnqStatusEntity e1 = new EnqStatusEntity();
		e1.setStatusName("NEW");
		EnqStatusEntity e2 = new EnqStatusEntity();
		e2.setStatusName("ENTROLLED");
		EnqStatusEntity e3 = new EnqStatusEntity();
		e3.setStatusName("LOST");
		enqStatusRepo.saveAll(Arrays.asList(e1, e2, e3));
		
		courseRepo.deleteAll();
		
		CourseEntity c1 = new CourseEntity();
		c1.setCourseName("JAVA FULLSTACK");
		CourseEntity c2 = new CourseEntity();
		c2.setCourseName("DEVOPS");
		CourseEntity c3 = new CourseEntity();
		c3.setCourseName("AWS");
		courseRepo.saveAll(Arrays.asList(c1, c2, c3));
	}

}
