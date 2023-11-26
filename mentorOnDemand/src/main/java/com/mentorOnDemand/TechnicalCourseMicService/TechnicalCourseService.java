package com.mentorOnDemand.TechnicalCourseMicService;

import java.util.List;

public interface TechnicalCourseService {
	
	public List<TechnicalCourse> getAllTechnicalCourse();
	
	public TechnicalCourse getTechnicalCourseById(int technicalCourseId);
	
	public TechnicalCourse saveTechnicalCourse(TechnicalCourseDto technicalCourseDto);
	
	public TechnicalCourse updateTechnicalCourseByTechnicalCourseId( TechnicalCourse technicalCourse, int technicalCourseId);
	
	public TechnicalCourse deleteTechnicalCourseByTechnicalCourseId(int technicalCourseId);
	
	//public TechnicalCourse addMentorByMentorIdAndTechnicalCourseId(int mentorId,int technicalCourseId);


}
