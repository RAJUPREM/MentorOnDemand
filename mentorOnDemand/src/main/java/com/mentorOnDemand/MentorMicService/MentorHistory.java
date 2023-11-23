package com.mentorOnDemand.MentorMicService;

import java.util.List;

import com.mentorOnDemand.TechnicalCourseMicService.TechnicalCourse;
import com.mentorOnDemand.TechnicalCourseMicService.TrainingTracker;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MentorHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mentorHistoryId;
	List<String> mentorRatingTillDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<TechnicalCourse> additionOfTechnicalCourse;

	List<String> mentorManagement;

	@OneToMany(cascade=CascadeType.ALL)
	List<TrainingTracker> trainingTracker;


}
