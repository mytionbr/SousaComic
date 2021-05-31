package com.mytion.sousacomics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mytion.sousacomics.dao.UserRepository;
import com.mytion.sousacomics.exception.BadRequestException;
import com.mytion.sousacomics.mapper.UserMapper;
import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.model.request.UserPostRequestBody;
import com.mytion.sousacomics.model.request.UserPutRequestBody;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User register(UserPostRequestBody userPostRequestBody) {
		User user = UserMapper.INSTANCE.toUser(userPostRequestBody);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id)
		 	.orElseThrow(()-> new BadRequestException("User not Found"));
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(findById(id));
	}

	@Override
	public void replace(UserPutRequestBody userPutRequestBody) {
		User user = UserMapper.INSTANCE.toUser(userPutRequestBody);
		userRepository.save(findById(user.getId()));
		
	}

	@Override
	public List<User> findByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}




	
	
	
}
