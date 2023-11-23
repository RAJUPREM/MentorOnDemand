package com.mentorOnDemand.TechnicalCourseMicService;

import java.util.List;

import com.mentorOnDemand.MentorMicService.Mentor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class TechnicalCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int technicalCourseId;
	private String technicalCourseName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Mentor> mentors;
	

}
