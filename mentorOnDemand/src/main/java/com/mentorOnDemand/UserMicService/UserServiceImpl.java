package com.mentorOnDemand.UserMicService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUser() {
		List<User> luser=userRepository.findAll();
		return luser;
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> tempUser=userRepository.findById(userId);
		User user=tempUser.get();
		return user;
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		User use=userRepository.save(user);
		return use;
	}

	@Override
	public User updateUserByUserId(User user, int userId) {
		Optional<User> tempUser=userRepository.findById(userId);
		User use=tempUser.get();
		use.setUserName(user.getUserName());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		use.setPassword(user.getPassword());
		userRepository.save(use);
		return use;
	}

	@Override
	public User deleteUserByUserId(int userId) {
		userRepository.deleteById(userId);
		return null;
	}

}
