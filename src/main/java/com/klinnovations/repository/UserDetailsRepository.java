package com.klinnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klinnovations.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{
	
	public UserDetails findByEmail(String email);

	public UserDetails findByEmailAndPassword(String email, String password);
	
	
	

}
