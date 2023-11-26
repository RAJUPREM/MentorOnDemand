package com.mentorOnDemand.TechnicalCourseMicService;

public class TechnicalCourseDto {
	
	public TechnicalCourseDto() {
		super();
	}
	public TechnicalCourseDto(int technicalCourseId, String technicalCourseName) {
		super();
		this.technicalCourseId = technicalCourseId;
		this.technicalCourseName = technicalCourseName;
	}
	private int technicalCourseId;
	private String technicalCourseName;
	public int getTechnicalCourseId() {
		return technicalCourseId;
	}
	public void setTechnicalCourseId(int technicalCourseId) {
		this.technicalCourseId = technicalCourseId;
	}
	public String getTechnicalCourseName() {
		return technicalCourseName;
	}
	public void setTechnicalCourseName(String technicalCourseName) {
		this.technicalCourseName = technicalCourseName;
	}
	@Override
	public String toString() {
		return "TechnicalCourseDto [technicalCourseId=" + technicalCourseId + ", technicalCourseName="
				+ technicalCourseName + "]";
	}

}
