package com.klinnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinnovations.entity.StudentEnquiries;

public interface StudentEnquiriesRepository extends JpaRepository<StudentEnquiries, Integer> {

}
