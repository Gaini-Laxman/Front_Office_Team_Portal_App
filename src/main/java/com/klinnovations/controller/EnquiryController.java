package com.klinnovations.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/logout")
	public String logout() {

		session.invalidate();
		return "index";
	}
	
	
	@GetMapping("/dashBoard")
	public String dashboardPage() {
		System.out.println("dashboard call...");
		
		return "dashBoard";
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
