package com.klinnovations.service;

import com.klinnovations.binding.LoginForm;
import com.klinnovations.binding.SignUpForm;
import com.klinnovations.binding.UnlockForm;

public interface UserService {
	
	public boolean signUp(SignUpForm form);
		
	public boolean unlockAccount(UnlockForm form);
	
	public String login(LoginForm form);
	
    public boolean forgetPassword(String email);
    
    
    
}
