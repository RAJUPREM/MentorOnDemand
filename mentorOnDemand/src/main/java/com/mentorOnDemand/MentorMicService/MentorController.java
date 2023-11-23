package com.mentorOnDemand.MentorMicService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mentors")
public class MentorController {
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to technical course cotroller";
	}

}
