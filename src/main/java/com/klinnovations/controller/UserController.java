package com.klinnovations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	
	@GetMapping("/signup")
	public String signUp() {
		
		return "signup";
	}
	
	@GetMapping("/unlock")
	public String unLock() {
		
		return "unLock";
	}
	
	
	
	@GetMapping("/forgetpassword")
	public String forgetPassword() {
		
		return "forgetPassword";
	}
	
	
}
