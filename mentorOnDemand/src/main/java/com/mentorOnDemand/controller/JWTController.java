package com.mentorOnDemand.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mentorOnDemand.entity.JWTRequest;
import com.mentorOnDemand.entity.JWTResponse;
import com.mentorOnDemand.entity.Person;
import com.mentorOnDemand.exception.UserNotFoundException;
import com.mentorOnDemand.helper.JWTService;
import com.mentorOnDemand.repo.PersonRepo;
import com.mentorOnDemand.servImpl.CustomPersonDetailsService;


@RestController
public class JWTController {

    @Autowired
    JWTService jwtHelper;
    
    @Autowired
    PersonRepo personRepo;

    @Autowired
    CustomPersonDetailsService customPersonDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<JWTResponse> getToken(@RequestBody JWTRequest jwtRequest){
        System.out.println(jwtRequest);
        
//        this.personRepo.save(new Person(1, "raju",
// 			   new BCryptPasswordEncoder().encode("Raju@123"), "USER"));
// 		this.personRepo.save(new Person(3, "prem",
// 				new BCryptPasswordEncoder().encode("Prem@123"), "ADMIN"));
// 		this.personRepo.save(new Person(2, "ravi",
//			new BCryptPasswordEncoder().encode("Ravi@123"), "MENTOR"));
 		
        try {
            Authentication authentication =      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getPersonName()
                    , jwtRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                return ResponseEntity.ok(new JWTResponse(jwtHelper.generateToken(jwtRequest.getPersonName())));
            } else {
                throw new UsernameNotFoundException("Person is not found sorry !!");
            }
        }
        catch (Exception ex){
            throw new UserNotFoundException("user name not found");
        }
    }
}
