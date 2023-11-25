package com.mentorOnDemand.MentorMicService;

import java.util.List;



public interface MentorService {
	
	public List<Mentor> getAllMentor();
	
	public Mentor getMentorById(int mentorId);
	
	public Mentor saveMentor(Mentor mentor);
	
	public Mentor updateMentorByMentorId( Mentor mentor, int mentorId);
	
	public Mentor deleteMentorByMentorId(int mentorId);

}
