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
	
	public MentorHistory() {
		super();
	}

	public MentorHistory(int mentorHistoryId, List<String> mentorRatingTillDate,
			List<TechnicalCourse> additionOfTechnicalCourse, List<String> mentorManagement,
			List<TrainingTracker> trainingTracker) {
		super();
		this.mentorHistoryId = mentorHistoryId;
		this.mentorRatingTillDate = mentorRatingTillDate;
		this.additionOfTechnicalCourse = additionOfTechnicalCourse;
		this.mentorManagement = mentorManagement;
		this.trainingTracker = trainingTracker;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mentorHistoryId;
	List<String> mentorRatingTillDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<TechnicalCourse> additionOfTechnicalCourse;

	List<String> mentorManagement;

	@OneToMany(cascade=CascadeType.ALL)
	List<TrainingTracker> trainingTracker;

	public int getMentorHistoryId() {
		return mentorHistoryId;
	}

	public void setMentorHistoryId(int mentorHistoryId) {
		this.mentorHistoryId = mentorHistoryId;
	}

	public List<String> getMentorRatingTillDate() {
		return mentorRatingTillDate;
	}

	public void setMentorRatingTillDate(List<String> mentorRatingTillDate) {
		this.mentorRatingTillDate = mentorRatingTillDate;
	}

	public List<TechnicalCourse> getAdditionOfTechnicalCourse() {
		return additionOfTechnicalCourse;
	}

	public void setAdditionOfTechnicalCourse(List<TechnicalCourse> additionOfTechnicalCourse) {
		this.additionOfTechnicalCourse = additionOfTechnicalCourse;
	}

	public List<String> getMentorManagement() {
		return mentorManagement;
	}

	public void setMentorManagement(List<String> mentorManagement) {
		this.mentorManagement = mentorManagement;
	}

	public List<TrainingTracker> getTrainingTracker() {
		return trainingTracker;
	}

	public void setTrainingTracker(List<TrainingTracker> trainingTracker) {
		this.trainingTracker = trainingTracker;
	}

	@Override
	public String toString() {
		return "MentorHistory [mentorHistoryId=" + mentorHistoryId + ", mentorRatingTillDate=" + mentorRatingTillDate
				+ ", additionOfTechnicalCourse=" + additionOfTechnicalCourse + ", mentorManagement=" + mentorManagement
				+ ", trainingTracker=" + trainingTracker + "]";
	}


}
