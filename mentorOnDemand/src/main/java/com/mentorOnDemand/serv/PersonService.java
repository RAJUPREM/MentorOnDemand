package com.mentorOnDemand.serv;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.mentorOnDemand.entity.Person;

public interface PersonService {
	
	public List<Person> getAllPerson();
	
	public Person getPersonById(int personId);
	
	public Person savePerson(Person person);
	
	public Person updatePersonByPersonId( Person person, int personId);
	
	public Person deletePersonByPersonId(@PathVariable int personId);

}
