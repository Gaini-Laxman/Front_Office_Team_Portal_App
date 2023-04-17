package com.klinnovations.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="KLIT_USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	private String email;
	private Integer phno;
	private String password;
	private String accountStatus;
	

}
