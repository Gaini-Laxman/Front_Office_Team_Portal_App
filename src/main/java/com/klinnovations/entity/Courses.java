package com.klinnovations.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="KLIT_COURSES")
public class Courses {
	
	@Id
	@GeneratedValue
	private Integer courseId;
	private String courseName;
	

}
