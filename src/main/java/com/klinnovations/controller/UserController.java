package com.klinnovations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.klinnovations.binding.LoginForm;
import com.klinnovations.binding.SignUpForm;
import com.klinnovations.binding.UnlockForm;
import com.klinnovations.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// Loading Empty Page

	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", new SignUpForm());

		return "signup";
	}

	// Signup Functionality

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

	

	@GetMapping("/unlock")
	public String unlock(@RequestParam String email, Model model) {

		UnlockForm unlockFormObj = new UnlockForm();
		unlockFormObj.setEmail(email);
		model.addAttribute("unlock", unlockFormObj);

		return "unlock";
	}

	@PostMapping("/unlock")
	public String unlockAccount(@ModelAttribute("unlock") UnlockForm unlock, Model model) {

		System.out.println(unlock);

		if (unlock.getNewpassword().equals(unlock.getConfirmpassword())) {

			boolean status = userService.unlockAccount(unlock);

			if (status) {
				model.addAttribute("succMsg", "Your Account Unlocked Successfully..");
			} else {
				model.addAttribute("errMsg", "Give Temparary Password is incorrect, Check your Email");
			}

		} else {
			model.addAttribute("errMsg", "New Password and Confirm Password Should be Same");
		}

		return "unlock";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());

		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {

		
		String status = userService.login(loginForm);
		
		if(status.contains("success")) {
			
			 
			
			return "redirect:/dashBoard";
		}
		
		model.addAttribute("errMsg", status);
		
		return "login";
	}
	
	
	
	
	@GetMapping("/forgetPassword")
	public String forgetPasswordPage() {

		return "forgetPassword";
	}
	
	@PostMapping("/forgetPassword")
	public String forgetPassword(@RequestParam("email") String email, Model model) {
		
		System.out.println(email);
		
	  boolean status = userService.forgetPassword(email);
	  
	  if(status) {
		  model.addAttribute("succMsg", "Password Sent To Your Email");
		  
	  }else {
		  
		  model.addAttribute("errMsg", "Invalid Email");
	  }

		return "forgetPassword";
	}

}
