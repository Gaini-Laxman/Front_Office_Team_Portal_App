package com.klinnovations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@GetMapping("/dashBoard")
	public String dashboardPage() {
		
		return "dashboard";
	}
	
	@GetMapping("/addEnquiry")
	public String addEnquiry() {
		
		return "addEnquiry";
	}
	
	@GetMapping("/viewEnquiry")
	public String viewEnquiry() {
		
		return "viewEnquiry";
	}

	
	
	
	
}
