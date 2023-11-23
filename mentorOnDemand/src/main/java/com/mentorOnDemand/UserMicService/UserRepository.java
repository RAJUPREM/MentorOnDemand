package com.mentorOnDemand.UserMicService;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	public Optional<User> findByUserName(String userName);

}
