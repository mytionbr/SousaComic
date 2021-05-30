package com.mytion.sousacomics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytion.sousacomics.model.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
