package com.mentorOnDemand.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mentorOnDemand.Admin.Admin;
import com.mentorOnDemand.Admin.AdminRepository;
import com.mentorOnDemand.entity.JWTRequest;
import com.mentorOnDemand.entity.JWTResponse;
import com.mentorOnDemand.exception.PersonNotFoundException;
import com.mentorOnDemand.helper.JWTService;
import com.mentorOnDemand.repo.PersonRepository;
import com.mentorOnDemand.servImpl.CustomPersonDetailsService;
import com.mentorOnDemand.servImpl.PersonServiceImpl;


@RestController
public class JWTController {

    @Autowired
    JWTService jwtHelper;
    
    @Autowired
    PersonServiceImpl personServiceImpl;
    
    @Autowired
    PersonRepository personRepository;
    
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    CustomPersonDetailsService customPersonDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<JWTResponse> getToken(@RequestBody JWTRequest jwtRequest){
        System.out.println(jwtRequest);
        
//        this.personRepository.save(new Person(1, "raju",
// 			   new BCryptPasswordEncoder().encode("Raju@123"), "USER"));
// 		this.personRepository.save(new Person(3, "prem",
// 				new BCryptPasswordEncoder().encode("Prem@123"), "ADMIN"));
// 		this.personRepository.save(new Person(2, "ravi",
//			new BCryptPasswordEncoder().encode("Ravi@123"), "MENTOR"));
        adminRepository.save(new Admin(1,"sourabh",new BCryptPasswordEncoder().encode("Sourabh@123")));   
        
        
        personServiceImpl.savePerson();
 		
        try {
            Authentication authentication =      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getPersonName()
                    , jwtRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                return ResponseEntity.ok(new JWTResponse(jwtHelper.generateToken(jwtRequest.getPersonName())));
            } else {
                throw new PersonNotFoundException("Person is not found sorry !!");
            }
        }
        catch (Exception ex){
            throw new PersonNotFoundException("user name not found");
        }
    }
}
