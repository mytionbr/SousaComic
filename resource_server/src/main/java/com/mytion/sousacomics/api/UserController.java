package com.mytion.sousacomics.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.model.request.UserPostRequestBody;
import com.mytion.sousacomics.model.request.UserPutRequestBody;
import com.mytion.sousacomics.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	
	
	@GetMapping()
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
		return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping(path = "/find")
	public ResponseEntity<List<User>> findByFistName(@RequestParam String firstName){
		return new ResponseEntity<>(userService.findByFirstName(firstName),HttpStatus.OK);
	}	
	
	@PostMapping
	public ResponseEntity<User> register (@RequestBody UserPostRequestBody userPostRequestBody){
		return new ResponseEntity<>(userService.register(userPostRequestBody),HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping()
	public ResponseEntity<Void> replace(@RequestBody UserPutRequestBody userPutRequestBody){
		userService.replace(userPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

	
	
}
