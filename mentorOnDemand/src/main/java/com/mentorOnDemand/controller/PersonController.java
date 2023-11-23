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


@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/welcome")
    public String welcome(){
       return "Welcome Raju prem";
    }


    @GetMapping("/")
    public ResponseEntity<List<Person>> getAllUsers(){
        List<Person> persons = personRepo.findAll();
        if(persons.size() == 0){
            throw new PersonNotFoundException("Person is not found");
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id){
    	Person user = personRepo.findById(id).orElseThrow(()
                -> new PersonNotFoundException("Person is not found with this id"+id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
    	Person newPerson  = personRepo.save(person);
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updateSave(@RequestBody Person person, @PathVariable int id){
    	Person newUser = personRepo.findById(id).orElseThrow(()
                -> new PersonNotFoundException("Person is not found with this id"+id));
        newUser.setPersonName(person.getPersonName());
        newUser.setPassword(person.getPassword());
        return new ResponseEntity<>(personRepo.save(newUser), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deleteSave(@PathVariable int id){
    	Person newPerson = personRepo.findById(id).orElseThrow(()
                -> new PersonNotFoundException("Person is not found with this id"+id));
        personRepo.delete(newPerson);
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

}
