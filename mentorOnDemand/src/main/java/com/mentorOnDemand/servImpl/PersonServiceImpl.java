package com.mentorOnDemand.servImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mentorOnDemand.Admin.Admin;
import com.mentorOnDemand.Admin.AdminRepository;
import com.mentorOnDemand.MentorMicService.Mentor;
import com.mentorOnDemand.MentorMicService.MentorRepository;
import com.mentorOnDemand.UserMicService.User;
import com.mentorOnDemand.UserMicService.UserRepository;
import com.mentorOnDemand.entity.Person;
import com.mentorOnDemand.exception.PersonNotFoundException;
import com.mentorOnDemand.repo.PersonRepository;
import com.mentorOnDemand.serv.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Person> getAllPerson() {
		List<Person> persons = personRepository.findAll();
        if(persons.size() == 0){
            throw new PersonNotFoundException("Person is not found");
        }
		return persons;
	}


	@Override
	public Person getPersonById(int personId) {
		Optional<Person> tempPerson=personRepository.findById(personId);
		Person person=tempPerson.get();
		return person;
	}

	@Override
	public void savePerson() {
		
		List<Person> lperson=personRepository.findAll();
		
		List<Admin> ladmin=adminRepository.findAll();
		
		for(Admin admin:ladmin)
		{
			Optional<Person> tempAdmin=personRepository.findByPersonName(admin.getAdminName());
			
			if(tempAdmin.isEmpty())
			{
				Person person=new Person();
				person.setPassword(admin.getAdminPassword());
				person.setPersonName(admin.getAdminName());
				person.setRole("ADMIN");
				personRepository.save(person);
			}
		}
		
		List<Mentor> lmentor=mentorRepository.findAll();
		
		for(Mentor mentor:lmentor)
		{
			Optional<Person> tempMentor=personRepository.findByPersonName(mentor.getMentorName());
			if(tempMentor.isEmpty())
			{
				Person person=new Person();
				person.setPassword(mentor.getMentorPassword());
				person.setPersonName(mentor.getMentorName());
				person.setRole("MENTOR");
				personRepository.save(person);
			}
		}
		
		
		List<User> luser=userRepository.findAll();
		
		for(User user:luser)
		{
			Optional<Person> tempUser=personRepository.findByPersonName(user.getUserName());
			if(tempUser.isEmpty())
			{
				Person person=new Person();
				person.setPassword(user.getPassword());
				person.setPersonName(user.getUserName());
				person.setRole("USER");
				personRepository.save(person);
			}
		}
		
	}

	@Override
	public Person updatePersonByPersonId(Person person, int personId) {
		Optional<Person> tempPerson = personRepository.findById(personId);
		Person newPerson=tempPerson.get();
		newPerson.setPersonName(person.getPersonName());
		newPerson.setPassword(new BCryptPasswordEncoder().encode(person.getPassword()));
		newPerson.setRole(person.getRole());
		personRepository.save(newPerson);
		return newPerson;
	}

	@Override
	public Person deletePersonByPersonId(int personId) {
		Optional<Person> tempPerson = personRepository.findById(personId);
		Person person=tempPerson.get();
		personRepository.delete(person);
		return person;
	}
	
	
}
