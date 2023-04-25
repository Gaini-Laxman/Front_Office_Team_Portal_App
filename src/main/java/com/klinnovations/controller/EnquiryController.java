package com.klinnovations.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.klinnovations.binding.DashBoardResponse;
import com.klinnovations.binding.EnquiryForm;
import com.klinnovations.service.EnquiryService;

@Controller
public class EnquiryController {
	
	@Autowired
	private EnquiryService enquiryService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/logout")
	public String logout() {

		session.invalidate();
		return "index";
	}
	
	
	@GetMapping("/dashBoard")
	public String dashboardPage(Model model) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		DashBoardResponse dashboardData = enquiryService.getDashBoardData(userId);
		model.addAttribute("dashboardData", dashboardData);
		
		return "dashBoard";
	}
	
	
	
	
	@PostMapping("/addEnquiry")
	public String addEnquiry(@ModelAttribute("formObj") EnquiryForm formObj, Model model) {
		
		
		boolean status = enquiryService.saveEnquiry(formObj);
		
		if(status) {
			model.addAttribute("succMsg", "Enquiry Added");
		}else {
			model.addAttribute("errMsg", "Problem Occured");
		}
		
		return "addEnquiry";
		
		
	}
	
	
	
	
	@GetMapping("/addEnquiry")
	public String addEnquiry(Model model) {
		
		//get courses for drop down
	    List<String> courses = enquiryService.getCourses();
		
		//get Enquiries status for drop down
	    
	   List<String> enquiryStatuses = enquiryService.getEnquiryStatuses();
	   
		//create binding class object
	   
	   EnquiryForm formObj = new EnquiryForm();
		
		//set data in model object
	   
	   model.addAttribute("courseNames", courses);
	   model.addAttribute("statusNames", enquiryStatuses);
	   model.addAttribute("formObj", formObj);
		
		return "addEnquiry";
	}
	
	@GetMapping("/viewEnquiry")
	public String viewEnquiry() {
		
		return "viewEnquiry";
	}

	
	
	
	
}
