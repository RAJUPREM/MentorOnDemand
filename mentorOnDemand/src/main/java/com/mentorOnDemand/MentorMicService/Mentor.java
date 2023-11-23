package com.mentorOnDemand.MentorMicService;

import java.util.List;

import com.mentorOnDemand.TechnicalCourseMicService.TechnicalCourse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Mentor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mentorId;
	private String mentorName;
	private int mentorExperience;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<TechnicalCourse> technicalCourses;

}
