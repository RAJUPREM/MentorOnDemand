package com.mentorOnDemand.servImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mentorOnDemand.entity.CustomPerson;
import com.mentorOnDemand.exception.PersonNotFoundException;
import com.mentorOnDemand.repo.PersonRepository;


@Component
public class CustomPersonDetailsService implements UserDetailsService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String personName) throws UsernameNotFoundException {
        return new CustomPerson(personRepository.findByPersonName(personName)
                .orElseThrow(() -> new PersonNotFoundException("Person is not found with this personName "+personName)));
    }
}
