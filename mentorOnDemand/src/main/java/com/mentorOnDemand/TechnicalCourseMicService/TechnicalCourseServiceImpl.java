package com.mentorOnDemand.TechnicalCourseMicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorOnDemand.MentorMicService.Mentor;
import com.mentorOnDemand.MentorMicService.MentorRepository;

@Service
public class TechnicalCourseServiceImpl implements TechnicalCourseService{

	@Autowired
	TechnicalCourseRepository technicalCourseRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Override
	public List<TechnicalCourse> getAllTechnicalCourse() {
		List<TechnicalCourse> ltechnicalcourses=technicalCourseRepository.findAll();
		return ltechnicalcourses;
	}

	@Override
	public TechnicalCourse getTechnicalCourseById(int technicalCourseId) {
		Optional<TechnicalCourse> tempTechnicalCourse=technicalCourseRepository.findById(technicalCourseId);
		TechnicalCourse technicalCourse=tempTechnicalCourse.get();
		return technicalCourse;
	}

	@Override
	public TechnicalCourse saveTechnicalCourse(TechnicalCourse technicalCourse) {
		technicalCourseRepository.save(technicalCourse);
		return technicalCourse;
	}

	@Override
	public TechnicalCourse updateTechnicalCourseByTechnicalCourseId(TechnicalCourse technicalCourse,
			int technicalCourseId) {
		Optional<TechnicalCourse> tempTechnicalCourse=technicalCourseRepository.findById(technicalCourseId);
		TechnicalCourse newTechnicalCourse=tempTechnicalCourse.get();
		newTechnicalCourse.setTechnicalCourseName(technicalCourse.getTechnicalCourseName());
		technicalCourseRepository.save(newTechnicalCourse);
		return newTechnicalCourse;
	}

	@Override
	public TechnicalCourse deleteTechnicalCourseByTechnicalCourseId(int technicalCourseId) {
		technicalCourseRepository.deleteById(technicalCourseId);
		return null;
	}

	@Override
	public TechnicalCourse addMentorByMentorIdAndTechnicalCourseId(int mentorId,int technicalCourseId) {
		Optional<Mentor> tempMentor=mentorRepository.findById(mentorId);
		Mentor mentor=tempMentor.get();
		
		Optional<TechnicalCourse> tempTechnicalCourse=technicalCourseRepository.findById(technicalCourseId);
		TechnicalCourse technicalCourse=tempTechnicalCourse.get();
		
		List<Mentor> lmentor=technicalCourse.getMentors();
		lmentor.add(mentor);
		
		
		technicalCourse.setMentors(lmentor);
		technicalCourseRepository.save(technicalCourse);
		
		return technicalCourse;
	}

}
