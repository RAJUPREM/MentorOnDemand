package com.mentorOnDemand.TechnicalCourseMicService;

public class TechnicalCourseMentorDto {
	
	public TechnicalCourseMentorDto() {
		super();
	}
	public TechnicalCourseMentorDto(int technicalCourseId, int mentorId) {
		super();
		this.technicalCourseId = technicalCourseId;
		this.mentorId = mentorId;
	}
	private int technicalCourseId;
	private int mentorId;
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
		return "TechnicalCourseMentorDto [technicalCourseId=" + technicalCourseId + ", mentorId=" + mentorId + "]";
	}

}
