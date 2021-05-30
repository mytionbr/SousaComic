package com.mytion.sousacomics.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mytion.sousacomics.dao.UserRepository;
import com.mytion.sousacomics.model.entity.User;

@DataJpaTest
@DisplayName("tests for User Repository")
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	@DisplayName("Save creates user when successful")
	void it_should_save_a_user() {
		User userToBeSaved = createUser();
		User userSaved = userRepository.save(userToBeSaved);
		Assertions.assertThat(userSaved).isNotNull();
		Assertions.assertThat(userSaved.getId()).isNotNull();
		Assertions.assertThat(userSaved.getEmail()).isEqualTo(userToBeSaved.getEmail());
	}
	
	@Test
	@DisplayName("saving a list of users")
	void it_should_save_a_user_list() {
		List<User> usersToBeSaved = creatingMultipleUsers(20);
		List<User> usersSaved = new ArrayList<User>();
		usersToBeSaved.forEach(u -> userRepository.save(u));
		usersSaved = userRepository.findAll();
		
		Assertions.assertThat(usersSaved.size()).isEqualTo(usersToBeSaved.size());
	}
	
	@Test
	void it_should_find_user_by_email() {
		User userToBeSaved = createUser();
		userToBeSaved.setEmail("fulano@gmail.com");
		userRepository.save(userToBeSaved);
		User userData = userRepository.findByEmail("fulano@gmail.com");
		Assertions.assertThat(userData.getEmail()).isEqualTo(userToBeSaved.getEmail());
	}
	
	
	
	private User createUser() {
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
		return user;
	}
	
	private List<User> creatingMultipleUsers(int qty){
		List<User> userList = new ArrayList<User>();
		LongStream.range(1,qty)
				.mapToObj(i -> {
						User u = new User();
						u.setFirstName("Fulano " + i);
						u.setLastName("de tal " + i);
						u.setAddress("rua de tal " + i);
						u.setCity("São Paulo " + i);
						u.setCountry("Brasil " + i);
						u.setEmail("fulano"+i+"@gmail.com");
						u.setPassword(i + "2345");
						u.setPhone(i+"111111111");
						u.setState("São Paulo " + i);
						u.setZip("121212121" + i);
						return u;
				}).map(u -> userList.add(u))
				.forEach(System.out::println);
		return userList;
	}
	
}
