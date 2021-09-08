package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController {

	private UserService userService = new UserService();

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/hello")
	public void helloTest() {
		System.out.println("Saying Hello from user controller");
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		System.out.println("Client invoked get all Users");
		List<User> users= userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PostMapping("/post")
	public ResponseEntity<User> newUser(@RequestBody User user) {
		System.out.println("Client invoked post new User");
		userService.saveUser(user);
			System.out.println("User saved");
			return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<User> deleteUser(@RequestBody User user){
		userService.deleteUser(user);
		return ResponseEntity.status(HttpStatus.valueOf(202)).build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") int id){
		User user = userService.getById(id);
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.status(HttpStatus.FOUND).build();
		}
		
	}
	
	

}
