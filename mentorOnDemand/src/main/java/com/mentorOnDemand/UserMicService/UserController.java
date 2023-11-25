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



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to user cotroller";
	}
	
	@GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServiceImpl.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId){
    	User user=userServiceImpl.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
    	User newUser=userServiceImpl.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
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
