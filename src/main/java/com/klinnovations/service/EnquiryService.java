package com.klinnovations.service;

import java.util.List;

import com.klinnovations.binding.DashBoardResponse;
import com.klinnovations.binding.EnquiryForm;
import com.klinnovations.binding.EnquirySearchCriteria;

public interface EnquiryService {
	
	public List<String> getCourseName();
	
	public List<String> enquiryStatus();
	
	public DashBoardResponse getDashBoardData(Integer userId);
	
	public String addenquiry(EnquiryForm form);
	
	public List<EnquiryForm> getEnquiries(Integer userId, EnquirySearchCriteria criteria); 
	
	public List<EnquiryForm> getEnquiry(Integer enquiryId); 

	
	
}
