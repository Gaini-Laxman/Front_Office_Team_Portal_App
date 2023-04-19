package com.klinnovations.service;

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

	@Override
	public String login(LoginForm form) {
		// TODO Auto-generated method stub
		return null;
	}

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
		StringBuffer body = new StringBuffer();
		body.append("<h1>Use Below Temparary Password To Unlock Your Account</h1>");
		body.append("Temparary Password:" + tempararyPassword);
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\">Click Here To Unlock Your Account</a>");

		emailUtils.sendEmail(to, subject, body.toString());

		return true;
	}

	@Override
	public String unlock(UnlockForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgetPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
