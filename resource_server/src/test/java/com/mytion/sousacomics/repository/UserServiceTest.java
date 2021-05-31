package com.mytion.sousacomics.repository;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mytion.sousacomics.dao.UserRepository;
import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

	@Mock
	private UserServiceImpl userService;
	
	@Mock
	private UserRepository repository;
	
	

}
