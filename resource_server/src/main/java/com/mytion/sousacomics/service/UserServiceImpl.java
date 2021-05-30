package com.mytion.sousacomics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id)
		 	.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not Found"));
	}
	
	
	
}
