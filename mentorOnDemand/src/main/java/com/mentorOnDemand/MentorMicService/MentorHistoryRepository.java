package com.mentorOnDemand.MentorMicService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorHistoryRepository extends JpaRepository<MentorHistory,Integer>{

}
