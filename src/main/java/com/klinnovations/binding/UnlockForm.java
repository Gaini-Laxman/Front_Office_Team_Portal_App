package com.klinnovations.binding;

import lombok.Data;

@Data
public class UnlockForm {
	
	private String email;
	
	private String tempararypassword;
	
	private String newpassword;
	
	private String confirmpassword;

}
