package com.klinnovations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.klinnovations.binding.SignUpForm;
import com.klinnovations.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	//Loading Empty Page
	
	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", new SignUpForm());

		return "signup";
	}
	
	//Signup Functionality

	@PostMapping("/signup")
	public String handleSignUp(@ModelAttribute("user") SignUpForm form, Model model) {
		boolean status = userService.signUp(form);

		if (status) {
			model.addAttribute("succMsg", "Account Created, Check your Email");

		} else {
			model.addAttribute("errMsg", "Given Email Allready Teken");
		}

		return "SignUp";

	}

	@GetMapping("/login")
	public String loginPage() {

		return "login";
	}

	@GetMapping("/unlock")
	public String unLock() {

		return "unLock";
	}

	@GetMapping("/forgetPassword")
	public String forgetPassword() {

		return "forgetPassword";
	}

}
