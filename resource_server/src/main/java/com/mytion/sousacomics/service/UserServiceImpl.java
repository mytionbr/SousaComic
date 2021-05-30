package com.mytion.sousacomics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytion.sousacomics.dao.UserRepository;
import com.mytion.sousacomics.model.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User register(User user) {
		return userRepository.save(user);
	}
	
}
