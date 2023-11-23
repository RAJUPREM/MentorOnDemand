package com.mentorOnDemand.controller;
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

import com.mentorOnDemand.entity.Person;
import com.mentorOnDemand.exception.PersonNotFoundException;
import com.mentorOnDemand.repo.PersonRepo;
import com.mentorOnDemand.servImpl.PersonServiceImpl;


@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonRepo personRepo;
    
    @Autowired
    PersonServiceImpl personServiceImpl;

    @GetMapping("/welcome")
    public String welcome(){
       return "Welcome Raju prem";
    }

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> persons = personServiceImpl.getAllPerson();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable int personId){
    	Person person=personServiceImpl.getPersonById(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
    	Person newPerson=personServiceImpl.savePerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<Person> updatePersonByPersonId(@RequestBody Person person, @PathVariable int personId){
    	Person per=personServiceImpl.updatePersonByPersonId(person, personId);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @DeleteMapping("delete/{personId}")
    public ResponseEntity<Person> deletePersonByPersonId(@PathVariable int personId){
    	Person newPerson=personServiceImpl.deletePersonByPersonId(personId);
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

}
