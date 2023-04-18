package com.klinnovations.service;

import com.klinnovations.binding.LoginForm;
import com.klinnovations.binding.SignUpForm;
import com.klinnovations.binding.UnlockForm;

public interface UserService {
	
	public String login(LoginForm form);
	
	public String signUp(SignUpForm form);
		
	public String unlock(UnlockForm form);
	
    public String forgetPassword(String email);
    
    
    
}
