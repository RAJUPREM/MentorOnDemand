package com.mentorOnDemand.TechnicalCourseMicService;

public class TrainingTrackerDto {
	
	public TrainingTrackerDto(String trainingTotalDuration, boolean trainingCompletionStatus, int trainingDaysLeft,
			int technicalCourseId, int mentorId) {
		super();
		this.trainingTotalDuration = trainingTotalDuration;
		this.trainingCompletionStatus = trainingCompletionStatus;
		this.trainingDaysLeft = trainingDaysLeft;
		this.technicalCourseId = technicalCourseId;
		this.mentorId = mentorId;
	}
	public TrainingTrackerDto() {
		super();
	}
	
	private String trainingTotalDuration;
	private boolean trainingCompletionStatus;
	private int trainingDaysLeft;
	private int technicalCourseId;
	private int mentorId;
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
	public int getTechnicalCourseId() {
		return technicalCourseId;
	}
	public void setTechnicalCourseId(int technicalCourseId) {
		this.technicalCourseId = technicalCourseId;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	@Override
	public String toString() {
		return "TrainingTrackerDto [trainingTotalDuration=" + trainingTotalDuration + ", trainingCompletionStatus="
				+ trainingCompletionStatus + ", trainingDaysLeft=" + trainingDaysLeft + ", technicalCourseId="
				+ technicalCourseId + ", mentorId=" + mentorId + "]";
	}
	

}
