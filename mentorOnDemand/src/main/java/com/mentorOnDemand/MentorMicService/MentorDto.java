package com.mentorOnDemand.MentorMicService;

public class MentorDto {
	
	public MentorDto() {
		super();
	}
	public MentorDto(int mentorId, String mentorName, String mentorPassword, int mentorExperience) {
		super();
		this.mentorId = mentorId;
		this.mentorName = mentorName;
		this.mentorPassword = mentorPassword;
		this.mentorExperience = mentorExperience;
	}
	private int mentorId;
	private String mentorName;
	private String mentorPassword;
	private int mentorExperience;
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public String getMentorPassword() {
		return mentorPassword;
	}
	public void setMentorPassword(String mentorPassword) {
		this.mentorPassword = mentorPassword;
	}
	public int getMentorExperience() {
		return mentorExperience;
	}
	public void setMentorExperience(int mentorExperience) {
		this.mentorExperience = mentorExperience;
	}
	@Override
	public String toString() {
		return "MentorDto [mentorId=" + mentorId + ", mentorName=" + mentorName + ", mentorPassword=" + mentorPassword
				+ ", mentorExperience=" + mentorExperience + "]";
	}

}
