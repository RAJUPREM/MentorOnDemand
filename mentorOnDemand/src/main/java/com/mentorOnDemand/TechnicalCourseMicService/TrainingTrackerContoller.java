package com.mentorOnDemand.TechnicalCourseMicService;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainingTrackers")
public class TrainingTrackerContoller {
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to training trackers";
	}
	
	@Autowired
	TrainingTrackerServiceImpl trainingTrackerServiceImpl;
	
	@GetMapping("/")
    public ResponseEntity<List<TrainingTracker>> getAllTrainingTrackers(){
        List<TrainingTracker> trainingTrackers = trainingTrackerServiceImpl.getAllTrainingTracker();
        return new ResponseEntity<>(trainingTrackers, HttpStatus.OK);
    }

    @GetMapping("/{trainingTrackerId}")
    public ResponseEntity<TrainingTracker> getTrainingTrackerById(@PathVariable int trainingTrackerId){
    	TrainingTracker trainingTracker=trainingTrackerServiceImpl.getTrainingTrackerById(trainingTrackerId);
        return new ResponseEntity<>(trainingTracker, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TrainingTracker> saveTrainingTracker(@RequestBody TrainingTrackerDto trainingTrackerDto){
    	TrainingTracker newTrainingTracker=trainingTrackerServiceImpl.saveTrainingTracker(trainingTrackerDto);
        return new ResponseEntity<>(newTrainingTracker, HttpStatus.OK);
    }

    @PutMapping("/update/{trainingTrackerId}")
    public ResponseEntity<TrainingTracker> updateTrainingTrackerByTrainingTrackerId(@RequestBody TrainingTracker trainingTracker, @PathVariable int trainingTrackerId){
    	TrainingTracker trainingTrackerRes=trainingTrackerServiceImpl.updateTrainingTrackerByTrainingTrackerId(trainingTracker, trainingTrackerId);
        return new ResponseEntity<>(trainingTrackerRes, HttpStatus.OK);
    }

    @DeleteMapping("delete/{trainingTrackerId}")
    public ResponseEntity<TrainingTracker> deleteTrainingTrackerByTrainingTrackerId(@PathVariable int trainingTrackerId){
    	TrainingTracker newTrainingTracker=trainingTrackerServiceImpl.deleteTrainingTrackerByTrainingTrackerId(trainingTrackerId);
        return new ResponseEntity<>(newTrainingTracker, HttpStatus.OK);
    }

}
