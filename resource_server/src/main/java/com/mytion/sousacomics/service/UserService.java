package com.mytion.sousacomics.service;

import java.util.List;

import com.mytion.sousacomics.model.entity.User;

public interface UserService {
	
	User register(User user);
	
	List<User> getAll();
	
	User findById(Long id);
}
