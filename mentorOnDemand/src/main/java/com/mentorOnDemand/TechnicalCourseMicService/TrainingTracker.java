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
	
	public TrainingTracker() {
		super();
	}

	public TrainingTracker(int trainingId, String trainingTotalDuration, boolean trainingCompletionStatus,
			int trainingDaysLeft, TechnicalCourse technicalCourse, Mentor mentor) {
		super();
		this.trainingId = trainingId;
		this.trainingTotalDuration = trainingTotalDuration;
		this.trainingCompletionStatus = trainingCompletionStatus;
		this.trainingDaysLeft = trainingDaysLeft;
		this.technicalCourse = technicalCourse;
		this.mentor = mentor;
	}

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

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingTotalDuration() {
		return trainingTotalDuration;
	}

	public void setTrainingTotalDuration(String trainingTotalDuration) {
		this.trainingTotalDuration = trainingTotalDuration;
	}

	public boolean getTrainingCompletionStatus() {
		return trainingCompletionStatus;
	}

	public void setTrainingCompletionStatus(boolean trainingCompletionStatus) {
		this.trainingCompletionStatus = trainingCompletionStatus;
	}

	public int getTrainingDaysLeft() {
		return trainingDaysLeft;
	}

	public void setTrainingDaysLeft(int trainingDaysLeft) {
		this.trainingDaysLeft = trainingDaysLeft;
	}

	public TechnicalCourse getTechnicalCourse() {
		return technicalCourse;
	}

	public void setTechnicalCourse(TechnicalCourse technicalCourse) {
		this.technicalCourse = technicalCourse;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	@Override
	public String toString() {
		return "TrainingTracker [trainingId=" + trainingId + ", trainingTotalDuration=" + trainingTotalDuration
				+ ", trainingCompletionStatus=" + trainingCompletionStatus + ", trainingDaysLeft=" + trainingDaysLeft
				+ ", technicalCourse=" + technicalCourse + ", mentor=" + mentor + "]";
	}
	

}
