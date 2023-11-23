package com.mentorOnDemand.TechnicalCourseMicService;

import com.mentorOnDemand.MentorMicService.Mentor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class TrainingTracker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int trainingId;
	private String trainingTotalDuration;
	private boolean trainingCompletionStatus;
	private int trainingDaysLeft;

	@OneToOne(cascade=CascadeType.ALL)
	private TechnicalCourse technicalCourse;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Mentor mentor;
	

}
