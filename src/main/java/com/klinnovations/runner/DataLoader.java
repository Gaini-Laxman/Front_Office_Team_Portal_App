package com.klinnovations.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.klinnovations.entity.Courses;
import com.klinnovations.entity.EnquiryStatus;
import com.klinnovations.repository.CoursesRepository;
import com.klinnovations.repository.EnquiryStatusRepository;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	private CoursesRepository courseRepo;
	
	@Autowired
	private EnquiryStatusRepository statusRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		courseRepo.deleteAll();

		Courses c1 = new Courses();
		c1.setCourseName("Java");
		
		Courses c2 = new Courses();
		c2.setCourseName("Python");
		
		Courses c3 = new Courses();
		c3.setCourseName("Dot Net");
		
		Courses c4 = new Courses();
		c4.setCourseName("AWS");
		
		Courses c5 = new Courses();
		c5.setCourseName("DevOps");
		
		courseRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		
		statusRepo.deleteAll();
		
		EnquiryStatus s1 = new EnquiryStatus();
		s1.setStatusName("New");
		
		EnquiryStatus s2 = new EnquiryStatus();
		s2.setStatusName("Enrolled");
		
		EnquiryStatus s3 = new EnquiryStatus();
		s3.setStatusName("Lost");
		
		statusRepo.saveAll(Arrays.asList(s1, s2, s3));
		
	}
	
	

}
