package com.mentorOnDemand.MentorMicService;

import java.util.List;





public interface MentorService {
	
	public List<Mentor> getAllMentor();
	
	public Mentor getMentorById(int mentorId);
	
	public Mentor saveMentor(MentorDto mentorDto);
	
	public Mentor updateMentorByMentorId( Mentor mentor, int mentorId);
	
	public Mentor deleteMentorByMentorId(int mentorId);
	
	public Mentor addTechnicalCourseByTechnicalCourseIdAndMentorId(int mentorId,int technicalCourseId);


}
