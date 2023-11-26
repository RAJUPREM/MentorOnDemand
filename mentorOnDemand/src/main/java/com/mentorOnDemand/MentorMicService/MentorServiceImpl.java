package com.mentorOnDemand.MentorMicService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mentorOnDemand.TechnicalCourseMicService.TechnicalCourse;
import com.mentorOnDemand.TechnicalCourseMicService.TechnicalCourseRepository;

@Service
public class MentorServiceImpl implements MentorService{

	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	TechnicalCourseRepository technicalCourseRepository;
	
	@Override
	public List<Mentor> getAllMentor() {
		List<Mentor> lmentor=mentorRepository.findAll();
		return lmentor;
	}

	@Override
	public Mentor getMentorById(int mentorId) {
		Optional<Mentor> tempMentor=mentorRepository.findById(mentorId);
		Mentor mentor=tempMentor.get();
		return mentor;
	}

	@Override
	public Mentor saveMentor(MentorDto mentorDto) {
		Mentor mentor=new Mentor();
		mentor.setMentorName(mentorDto.getMentorName());
		mentor.setMentorExperience(mentorDto.getMentorExperience());
		mentor.setMentorPassword(new BCryptPasswordEncoder().encode(mentorDto.getMentorPassword()));
		mentor.setTechnicalCourses(null);
		mentorRepository.save(mentor);
		return mentor;
	}

	@Override
	public Mentor updateMentorByMentorId(Mentor mentor, int mentorId) {
		Optional<Mentor> tempMentor=mentorRepository.findById(mentorId);
		Mentor newMentor=tempMentor.get();
		newMentor.setMentorName(mentor.getMentorName());
		mentor.setMentorPassword(new BCryptPasswordEncoder().encode(mentor.getMentorPassword()));
		newMentor.setMentorPassword(mentor.getMentorPassword());
		mentorRepository.save(newMentor);
		return newMentor;
	}

	@Override
	public Mentor deleteMentorByMentorId(int mentorId) {
		mentorRepository.deleteById(mentorId);
		return null;
	}

	@Override
	public Mentor addTechnicalCourseByTechnicalCourseIdAndMentorId(int mentorId, int technicalCourseId) {
		Optional<Mentor> tempMentor=mentorRepository.findById(mentorId);
		Mentor mentor=tempMentor.get();
		
		Optional<TechnicalCourse> tempTechnicalCourse=technicalCourseRepository.findById(technicalCourseId);
		TechnicalCourse technicalCourse=tempTechnicalCourse.get();
		
		List<TechnicalCourse> ltechnicalcourse=mentor.getTechnicalCourses();
		ltechnicalcourse.add(technicalCourse);
		
		
		mentor.setTechnicalCourses(ltechnicalcourse);
		mentorRepository.save(mentor);
		return mentor;
	}

}
