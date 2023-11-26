package com.mentorOnDemand.TechnicalCourseMicService;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mentorOnDemand.MentorMicService.Mentor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class TechnicalCourse {
	
	public TechnicalCourse() {
		super();
	}

	public TechnicalCourse(int technicalCourseId, String technicalCourseName, List<Mentor> mentors) {
		super();
		this.technicalCourseId = technicalCourseId;
		this.technicalCourseName = technicalCourseName;
		this.mentors = mentors;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int technicalCourseId;
	private String technicalCourseName;
	
	@JsonBackReference
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="technicalCourses")
	private List<Mentor> mentors;

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

	public List<Mentor> getMentors() {
		return mentors;
	}

	public void setMentors(List<Mentor> mentors) {
		this.mentors = mentors;
	}

	@Override
	public String toString() {
		return "TechnicalCourse [technicalCourseId=" + technicalCourseId + ", technicalCourseName="
				+ technicalCourseName + ", mentors=" + mentors + "]";
	}
	

}
