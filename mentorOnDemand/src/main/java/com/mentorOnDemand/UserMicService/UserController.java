package com.mentorOnDemand.UserMicService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to user cotroller";
	}

}
