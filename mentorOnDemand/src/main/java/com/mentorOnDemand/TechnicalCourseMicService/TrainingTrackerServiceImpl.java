package com.mentorOnDemand.TechnicalCourseMicService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorOnDemand.MentorMicService.Mentor;
import com.mentorOnDemand.MentorMicService.MentorRepository;


@Service
public class TrainingTrackerServiceImpl implements TrainingTrackerService{

	@Autowired
	TrainingTrackerRepository trainingTrackerRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	TechnicalCourseRepository technicalCourseRepository;
	
	@Override
	public List<TrainingTracker> getAllTrainingTracker() {
		List<TrainingTracker> ltrainingtrackers=trainingTrackerRepository.findAll();
		return ltrainingtrackers;
	}

	@Override
	public TrainingTracker getTrainingTrackerById(int trainingTrackerId) {
		Optional<TrainingTracker> tempTrainingTracker=trainingTrackerRepository.findById(trainingTrackerId);
		return tempTrainingTracker.get();
	}

	@Override
	public TrainingTracker saveTrainingTracker(TrainingTrackerDto trainingTrackerDto) {
		Optional<Mentor> tempMentor=mentorRepository.findById(trainingTrackerDto.getMentorId());
		Mentor mentor=tempMentor.get();
		
		Optional<TechnicalCourse> tempTechnicalCourse=technicalCourseRepository.findById(trainingTrackerDto.getTechnicalCourseId());
		TechnicalCourse technicalCourse=tempTechnicalCourse.get();
		
		TrainingTracker trainingTracker=new TrainingTracker();
		trainingTracker.setMentor(mentor);
		trainingTracker.setTechnicalCourse(technicalCourse);
		trainingTracker.setTrainingCompletionStatus(trainingTrackerDto.getTrainingCompletionStatus());
		trainingTracker.setTrainingDaysLeft(trainingTrackerDto.getTrainingDaysLeft());
		trainingTracker.setTrainingTotalDuration(trainingTrackerDto.getTrainingTotalDuration());
		
		trainingTrackerRepository.save(trainingTracker);
		return trainingTracker;
	}

	@Override
	public TrainingTracker updateTrainingTrackerByTrainingTrackerId(TrainingTracker trainingTracker,
			int trainingTrackerId) {
		Optional<TrainingTracker> tempTrainingTracker=trainingTrackerRepository.findById(trainingTrackerId);
		TrainingTracker newTrainingTracker=tempTrainingTracker.get();
		newTrainingTracker.setMentor(trainingTracker.getMentor());
		newTrainingTracker.setTrainingCompletionStatus(trainingTracker.getTrainingCompletionStatus());
		newTrainingTracker.setTechnicalCourse(trainingTracker.getTechnicalCourse());
		newTrainingTracker.setTrainingDaysLeft(trainingTracker.getTrainingDaysLeft());
		newTrainingTracker.setTrainingTotalDuration(trainingTracker.getTrainingTotalDuration());
		trainingTrackerRepository.save(newTrainingTracker);
		return newTrainingTracker;
	}

	@Override
	public TrainingTracker deleteTrainingTrackerByTrainingTrackerId(int trainingTrackerId) {
		trainingTrackerRepository.deleteById(trainingTrackerId);
		return null;
	}

}
