package com.klinnovations.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="KLIT_STUDENT_ENQUIRIES")
public class StudentEnquiries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	private String studentName;
	private Integer phno;
	private String classMode;
	private String courseName;
	private String enquiryStatus;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	
	private Integer userId;
	
	
	
}
