package com.mentorOnDemand.MentorMicService;

import java.util.List;

public interface MentorHistoryService {
	
	public List<MentorHistory> getAllMentorHistory();
	
	public MentorHistory getMentorHistoryById(int mentorHistoryId);
	
	public MentorHistory saveMentorHistory(MentorDto mentorDto);
	
	public MentorHistory updateMentorHistoryByMentorHistoryId( MentorHistory mentorHistory, int mentorHistoryId);
	
	public MentorHistory deleteMentorHistoryByMentorHistoryId(int mentorHistoryId);

}
