package com.mytion.sousacomics.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mytion.sousacomics.model.entity.User;
import com.mytion.sousacomics.model.request.UserPostRequestBody;
import com.mytion.sousacomics.model.request.UserPutRequestBody;
import com.mytion.sousacomics.model.response.UserResponseBody;
import com.mytion.sousacomics.service.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/users")
@Controller
@RequiredArgsConstructor
public class UserController extends ApiController {
	
	private final UserService userService;
	
		
	@GetMapping()
	public ResponseEntity<Page<User>> getAll(Pageable pageable){
		return new ResponseEntity<>(userService.getAll(pageable),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
		return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping(path = "/find")
	public ResponseEntity<List<UserResponseBody>> findByFistName(@RequestParam String firstName){
		return new ResponseEntity<>(userService.findByFirstName(firstName),HttpStatus.OK);
	}	
	
	@PostMapping
	public ResponseEntity<User> register (@RequestBody @Valid UserPostRequestBody userPostRequestBody){
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
