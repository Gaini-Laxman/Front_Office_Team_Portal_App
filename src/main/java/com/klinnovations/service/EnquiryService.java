package com.klinnovations.service;

import java.util.List;

import com.klinnovations.binding.DashBoardResponse;
import com.klinnovations.binding.EnquiryForm;
import com.klinnovations.binding.EnquirySearchCriteria;

public interface EnquiryService {
	
	public DashBoardResponse getDashBoardData(Integer userId);
	
    public List<String> getCourses();
	
	public List<String> getEnquiryStatuses();
	
	public boolean saveEnquiry(EnquiryForm form);
	
	public List<EnquiryForm> getEnquiries(Integer userId, EnquirySearchCriteria criteria); 
	
	public List<EnquiryForm> getEnquiry(Integer enquiryId); 

	
	
}
