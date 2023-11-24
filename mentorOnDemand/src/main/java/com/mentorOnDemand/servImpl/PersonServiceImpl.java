package com.mentorOnDemand.servImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mentorOnDemand.entity.Person;
import com.mentorOnDemand.exception.PersonNotFoundException;
import com.mentorOnDemand.repo.PersonRepo;
import com.mentorOnDemand.serv.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepo personRepo;
	
	@Override
	public List<Person> getAllPerson() {
		List<Person> persons = personRepo.findAll();
        if(persons.size() == 0){
            throw new PersonNotFoundException("Person is not found");
        }
		return persons;
	}


	@Override
	public Person getPersonById(int personId) {
		Optional<Person> tempPerson=personRepo.findById(personId);
		Person person=tempPerson.get();
		return person;
	}

	@Override
	public Person savePerson(Person person) {
		person.setPassword(new BCryptPasswordEncoder().encode(person.getPassword()));
		Person newPerson  = personRepo.save(person);
		return newPerson;
	}

	@Override
	public Person updatePersonByPersonId(Person person, int personId) {
		Optional<Person> tempPerson = personRepo.findById(personId);
		Person newPerson=tempPerson.get();
		newPerson.setPersonName(person.getPersonName());
		newPerson.setPassword(person.getPassword());
		Person p=personRepo.save(newPerson);
		return p;
	}

	@Override
	public Person deletePersonByPersonId(int personId) {
		Optional<Person> tempPerson = personRepo.findById(personId);
		Person person=tempPerson.get();
        personRepo.delete(person);
		return person;
	}
	
	
}
