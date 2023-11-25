package com.mentorOnDemand.MentorMicService;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MentorRepository extends JpaRepository<Mentor,Integer>{
	
	public Optional<Mentor> findByMentorName(String mentorName);

}
