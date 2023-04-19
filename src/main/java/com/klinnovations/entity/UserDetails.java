package com.klinnovations.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private String password;
	private String phno;
	private String accountStatus;
	
	@OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<StudentEnquiries> enquiries ;

}
