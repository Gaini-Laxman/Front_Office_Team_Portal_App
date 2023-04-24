package com.klinnovations.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klinnovations.binding.LoginForm;
import com.klinnovations.binding.SignUpForm;
import com.klinnovations.binding.UnlockForm;
import com.klinnovations.entity.UserDetails;
import com.klinnovations.repository.UserDetailsRepository;
import com.klinnovations.util.EmailUtils;
import com.klinnovations.util.PasswordUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDetailsRepository userDetailsRepo;

	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean signUp(SignUpForm form) {

		UserDetails user = userDetailsRepo.findByEmail(form.getEmail());

		if (user != null) {
			return false;

		}

		// Copy Data from binding object to entity object

		UserDetails entity = new UserDetails();
		BeanUtils.copyProperties(form, entity);

		// Generate Random Password

		String tempararyPassword = PasswordUtils.generateRandomPassword();
		entity.setPassword(tempararyPassword);

		// Set Account Status as Locked

		entity.setAccountStatus("LOCKED");

		// Insert Record

		userDetailsRepo.save(entity);

		// Send Email To Unlock The Account

		String to = form.getEmail();
		String subject = "Unlock Your Account";
		StringBuffer body = new StringBuffer("");
		body.append("<h1>Use Below Temparary Password To Unlock Your Account</h1>");
		body.append("Temparary Password:" + tempararyPassword);
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\">Click Here To Unlock Your Account</a>");

		emailUtils.sendEmail(to, subject, body.toString());

		return true;
	}
	
	@Override
	public String login(LoginForm form) {
		
		UserDetails entity = userDetailsRepo.findByEmailAndPassword(form.getEmail(), form.getPassword());
		
		if(entity == null) {
			return "Invalid Credentials";
		}
		
		if(entity.getAccountStatus().equals("LOCKED")) {
			return "Your Account Locked";
		}
		
		//create session and store user data in session
		
		session.setAttribute("userId", entity.getUserId());
		
		
		return "success";
	}
	

	@Override
	public boolean unlockAccount(UnlockForm form) {

		UserDetails user = userDetailsRepo.findByEmail(form.getEmail());

		if (user.getPassword().equals(form.getTempararypassword())) {

			user.setPassword(form.getNewpassword());
			user.setAccountStatus("UNLOCKED");
			userDetailsRepo.save(user);
			return true;

		} else {
			return false;
		}
	}

	
	
	@Override
	public boolean forgetPassword(String email) {

		//check record presence in db with given email
		
		UserDetails entity = userDetailsRepo.findByEmail(email);
		
		// if record not available send error message
		
		if(entity == null) {
			
			return false;
		}
		
		//if record is available send password to email send success msg
		
		String subject = "Recover Password ";
		String body = "Your Password : "+entity.getPassword();
		
		emailUtils.sendEmail(email, subject, body);
		
		return true;
	}

}
