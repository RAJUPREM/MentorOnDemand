package com.mentorOnDemand.UserMicService;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	private int userId;
	private String userName;
	private String password;

}
