package com.mentorOnDemand.TechnicalCourseMicService;



import java.util.List;

public interface TrainingTrackerService {
	
	
	public List<TrainingTracker> getAllTrainingTracker();
	
	public TrainingTracker getTrainingTrackerById(int trainingTrackerId);
	
	public TrainingTracker saveTrainingTracker(TrainingTrackerDto trainingTrackerDto);
	
	public TrainingTracker updateTrainingTrackerByTrainingTrackerId( TrainingTracker trainingTracker, int trainingTrackerId);
	
	public TrainingTracker deleteTrainingTrackerByTrainingTrackerId(int trainingTrackerId);

}
