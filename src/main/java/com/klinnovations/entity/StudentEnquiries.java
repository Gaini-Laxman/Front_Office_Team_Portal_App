package com.klinnovations.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Entity
@Data
@Table(name="KLIT_STUDENT_ENQUIRIES")
public class StudentEnquiries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	private String studentName;
	private Integer studentPhno;
	private String classMode;
	private String courseName;
	private String enquiryStatus;
	
	@CreationTimestamp
	private LocalDate datecreated;
	
	@UpdateTimestamp
	private LocalDate lastupdated;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails user;
	
	
}
