package com.mentorOnDemand.MentorMicService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImpl implements MentorService{

	@Autowired
	MentorRepository mentorRepository;
	
	@Override
	public List<Mentor> getAllMentor() {
		List<Mentor> lmentor=mentorRepository.findAll();
		return lmentor;
	}

	@Override
	public Mentor getMentorById(int mentorId) {
		Optional<Mentor> tempMentor=mentorRepository.findById(mentorId);
		Mentor mentor=tempMentor.get();
		return mentor;
	}

	@Override
	public Mentor saveMentor(Mentor mentor) {
		mentor.setMentorPassword(new BCryptPasswordEncoder().encode(mentor.getMentorPassword()));
		mentorRepository.save(mentor);
		return mentor;
	}

	@Override
	public Mentor updateMentorByMentorId(Mentor mentor, int mentorId) {
		Optional<Mentor> tempMentor=mentorRepository.findById(mentorId);
		Mentor newMentor=tempMentor.get();
		newMentor.setMentorName(mentor.getMentorName());
		mentor.setMentorPassword(new BCryptPasswordEncoder().encode(mentor.getMentorPassword()));
		newMentor.setMentorPassword(mentor.getMentorPassword());
		mentorRepository.save(newMentor);
		return newMentor;
	}

	@Override
	public Mentor deleteMentorByMentorId(int mentorId) {
		mentorRepository.deleteById(mentorId);
		return null;
	}

}
