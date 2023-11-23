package com.mentorOnDemand.TechnicalCourseMicService;

import org.springframework.web.bind.annotation.GetMapping;
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

}
