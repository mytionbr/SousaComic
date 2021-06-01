package com.mytion.sousacomics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytion.sousacomics.dao.UserRepository;
import com.mytion.sousacomics.exception.BadRequestException;
import com.mytion.sousacomics.mapper.user.UserRequestMapper;
import com.mytion.sousacomics.mapper.user.UserResponseMapper;
import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.model.request.UserPostRequestBody;
import com.mytion.sousacomics.model.request.UserPutRequestBody;
import com.mytion.sousacomics.model.response.UserResponseBody;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	@Override
	public User register(UserPostRequestBody userPostRequestBody) {
		User user = UserRequestMapper.INSTANCE.toUser(userPostRequestBody);
		return userRepository.save(user);
	}

	@Override
	public Page<User> getAll(Pageable pageable) {
		return userRepository.findAll(pageable);	 
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
		User user = UserRequestMapper.INSTANCE.toUser(userPutRequestBody);
		userRepository.save(findById(user.getId()));
	}

	@Override
	public List<UserResponseBody> findByFirstName(String firstName) {
		 List<User> userDataList = userRepository.findByFirstName(firstName);
		 
		 List<UserResponseBody> userResponseList = new ArrayList<UserResponseBody>();
		 
		 userDataList.forEach(userData -> 
		 userResponseList.add(UserResponseMapper.INSTANCE.toUserResponseBody(userData)));
		 
		 return userResponseList;
	}

	
}
