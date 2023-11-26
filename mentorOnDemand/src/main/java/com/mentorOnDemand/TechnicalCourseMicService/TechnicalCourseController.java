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
@RequestMapping("/technicalCourses")
public class TechnicalCourseController {
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to technical course cotroller";
	}
	
	@Autowired
	TechnicalCourseServiceImpl technicalCourseServiceImpl;
	
	@GetMapping("/")
    public ResponseEntity<List<TechnicalCourse>> getAllTechnicalCourses(){
        List<TechnicalCourse> technicalCourses = technicalCourseServiceImpl.getAllTechnicalCourse();
        return new ResponseEntity<>(technicalCourses, HttpStatus.OK);
    }

    @GetMapping("/{technicalCourseId}")
    public ResponseEntity<TechnicalCourse> getTechnicalCourseById(@PathVariable int technicalCourseId){
    	TechnicalCourse technicalCourse=technicalCourseServiceImpl.getTechnicalCourseById(technicalCourseId);
        return new ResponseEntity<>(technicalCourse, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TechnicalCourse> saveTechnicalCourse(@RequestBody TechnicalCourseDto technicalCourseDto){
    	TechnicalCourse newTechnicalCourse=technicalCourseServiceImpl.saveTechnicalCourse(technicalCourseDto);
        return new ResponseEntity<>(newTechnicalCourse, HttpStatus.OK);
    }

    @PutMapping("/update/{technicalCourseId}")
    public ResponseEntity<TechnicalCourse> updateTechnicalCourseByTechnicalCourseId(@RequestBody TechnicalCourse TechnicalCourse, @PathVariable int technicalCourseId){
    	TechnicalCourse technicalCourseRes=technicalCourseServiceImpl.updateTechnicalCourseByTechnicalCourseId(TechnicalCourse, technicalCourseId);
        return new ResponseEntity<>(technicalCourseRes, HttpStatus.OK);
    }

    @DeleteMapping("delete/{technicalCourseId}")
    public ResponseEntity<TechnicalCourse> deleteTechnicalCourseByTechnicalCourseId(@PathVariable int technicalCourseId){
    	TechnicalCourse newTechnicalCourse=technicalCourseServiceImpl.deleteTechnicalCourseByTechnicalCourseId(technicalCourseId);
        return new ResponseEntity<>(newTechnicalCourse, HttpStatus.OK);
    }
    
//    @PostMapping("/addMentor")
//    public ResponseEntity<TechnicalCourse> addMentorByMentorIdAndTechnicalCourseId(@RequestBody TechnicalCourseMentorDto  technicalCourseMentorDto) {
//    	TechnicalCourse technicalCourse=technicalCourseServiceImpl.addMentorByMentorIdAndTechnicalCourseId(technicalCourseMentorDto.getMentorId(), technicalCourseMentorDto.getTechnicalCourseId());
//    	return new ResponseEntity<>(technicalCourse,HttpStatus.OK);
//    }

}
