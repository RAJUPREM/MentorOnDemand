package com.mentorOnDemand.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorOnDemand.entity.Person;

import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    public Optional<Person> findByPersonName(String personName);
}
