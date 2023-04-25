package com.klinnovations.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klinnovations.binding.DashBoardResponse;
import com.klinnovations.binding.EnquiryForm;
import com.klinnovations.binding.EnquirySearchCriteria;
import com.klinnovations.entity.Courses;
import com.klinnovations.entity.EnquiryStatus;
import com.klinnovations.entity.StudentEnquiries;
import com.klinnovations.entity.UserDetails;
import com.klinnovations.repository.CoursesRepository;
import com.klinnovations.repository.EnquiryStatusRepository;
import com.klinnovations.repository.StudentEnquiriesRepository;
import com.klinnovations.repository.UserDetailsRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private UserDetailsRepository userDetailsRepo;

	@Autowired
	private CoursesRepository courseRepo;

	@Autowired
	private EnquiryStatusRepository statusRepo;
	
	@Autowired
	private StudentEnquiriesRepository  studentEnquiriesRepo;
	
	@Autowired
	private HttpSession session;

	@Override
	public DashBoardResponse getDashBoardData(Integer userId) {

		DashBoardResponse response = new DashBoardResponse();

		Optional<UserDetails> findById = userDetailsRepo.findById(userId);

		if (findById.isPresent()) {
			UserDetails userEntity = findById.get();
			List<StudentEnquiries> enquiries = userEntity.getEnquiries();

			Integer totalCount = enquiries.size();

			Integer entrolledCount = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("Enrolled"))
					.collect(Collectors.toList()).size();
			Integer lostCount = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("Lost"))
					.collect(Collectors.toList()).size();

			response.setTotalEnquiriesCount(totalCount);
			response.setEntrolledCount(entrolledCount);
			response.setLostCount(lostCount);

		}

		return response;

	}

	@Override
	public List<String> getCourses() {

		List<Courses> findAll = courseRepo.findAll();
		List<String> names = new ArrayList<>();
		for (Courses course : findAll) {
			names.add(course.getCourseName());
		}

		return names;
	}

	@Override
	public List<String> getEnquiryStatuses() {
      
	List<EnquiryStatus>	findAll	= statusRepo.findAll();
	List<String> statusList = new ArrayList<>();
	
	for(EnquiryStatus status : findAll ) {
		statusList.add(status.getStatusName());
	}
		
		
		
		return statusList;
	}

	@Override
	public boolean saveEnquiry(EnquiryForm form) {
		
		StudentEnquiries enquiryEntity = new StudentEnquiries();
		BeanUtils.copyProperties(form, enquiryEntity);
		
		Integer userId = (Integer) session.getAttribute("userId");
		 UserDetails userEntity = userDetailsRepo.findById(userId).get();
		 enquiryEntity.setUser(userEntity);
		 
		 
		studentEnquiriesRepo.save(enquiryEntity);
		
		
		
		
		return true;
	}

	@Override
	public List<EnquiryForm> getEnquiries(Integer userId, EnquirySearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnquiryForm> getEnquiry(Integer enquiryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
