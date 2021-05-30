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
	
	@Test
	void it_should_register_a_user() {
		User user = new User();
		user.setFirstName("Fulano");
		user.setLastName("de tal");
		user.setAddress("rua de tal");
		user.setCity("São Paulo");
		user.setCountry("Brasil");
		user.setEmail("fulano@gmail.com");
		user.setPassword("12345");
		user.setPhone("1111111111");
		user.setState("São Paulo");
		user.setZip("121212121");

		// when
		User userData = userService.register(user);

		System.out.println(userData.getCity());
		// then
		then(user).isEqualTo(userData);

	}

}
