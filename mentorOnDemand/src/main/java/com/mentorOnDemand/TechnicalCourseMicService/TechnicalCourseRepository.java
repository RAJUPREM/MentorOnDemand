package com.mentorOnDemand.TechnicalCourseMicService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TechnicalCourseRepository extends JpaRepository<TechnicalCourse,Integer>{

}
