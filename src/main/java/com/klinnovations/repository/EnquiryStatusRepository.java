package com.klinnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klinnovations.entity.EnquiryStatus;

public interface EnquiryStatusRepository extends JpaRepository<EnquiryStatus, Integer> {

}
