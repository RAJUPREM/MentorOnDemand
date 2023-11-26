package com.mentorOnDemand.UserMicService;

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

import com.mentorOnDemand.MentorMicService.Mentor;
import com.mentorOnDemand.TechnicalCourseMicService.TechnicalCourseDto;
import com.mentorOnDemand.TechnicalCourseMicService.TechnicalCourseServiceImpl;
import com.mentorOnDemand.TechnicalCourseMicService.TrainingTracker;
import com.mentorOnDemand.TechnicalCourseMicService.TrainingTrackerDto;
import com.mentorOnDemand.TechnicalCourseMicService.TrainingTrackerServiceImpl;

@RestController
@RequestMapping("/userown")
public class UserOwnController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	TechnicalCourseServiceImpl technicalCourseServiceImpl;
	
	@Autowired
	TrainingTrackerServiceImpl trainingTrackerServiceImpl;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to user cotroller";
	}
	
	@GetMapping("/mentors")
    public ResponseEntity<List<Mentor>> getAllMentorsByTechnicalCourseName(@RequestBody TechnicalCourseDto technicalCourseDto)
    {
    	List<Mentor> lmentor=technicalCourseServiceImpl.getAllMentorsByTechnicalCourseName(technicalCourseDto.getTechnicalCourseName());
    	return new ResponseEntity<>(lmentor,HttpStatus.OK);
    }
	
	@PostMapping("/select")
    public ResponseEntity<TrainingTracker> saveTrainingTracker(@RequestBody TrainingTrackerDto trainingTrackerDto){
    	TrainingTracker newTrainingTracker=trainingTrackerServiceImpl.saveTrainingTracker(trainingTrackerDto);
        return new ResponseEntity<>(newTrainingTracker, HttpStatus.OK);
    }
	
	@GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId){
    	User user=userServiceImpl.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	@PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUserByUserId(@RequestBody User user, @PathVariable int userId){
    	User userRes=userServiceImpl.updateUserByUserId(user, userId);
        return new ResponseEntity<>(userRes, HttpStatus.OK);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<User> deleteUserByuserId(@PathVariable int userId){
    	User userRes=userServiceImpl.deleteUserByUserId(userId);
        return new ResponseEntity<>(userRes, HttpStatus.OK);
    }

}
