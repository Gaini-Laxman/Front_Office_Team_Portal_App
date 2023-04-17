package com.klinnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klinnovations.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{

}
