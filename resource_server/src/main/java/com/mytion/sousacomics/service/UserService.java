package com.mytion.sousacomics.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.model.request.UserPostRequestBody;
import com.mytion.sousacomics.model.request.UserPutRequestBody;
import com.mytion.sousacomics.model.response.UserResponseBody;

public interface UserService {
	
	User register(UserPostRequestBody userPostRequestBody);
	
	Page<User> getAll(Pageable pageable);
	
	User findById(Long id);

	void delete(Long id);

	void replace(UserPutRequestBody userPutRequestBody);
	
	List<UserResponseBody> findByFirstName(String firstName);
	
	

}
