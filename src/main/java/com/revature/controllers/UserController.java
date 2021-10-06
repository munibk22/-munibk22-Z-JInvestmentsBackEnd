package com.revature.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
//import com.revature.util.Bcrypt;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController {

	private UserService userService = new UserService();
//	private Bcrypt bcrypt= new Bcrypt();
	Logger log=  LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/hello")
	public String helloTest() {
		log.info("Saying Hello from user controller");
		return "home.jsp";
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		log.info("Client invoked get all Users");
		List<User> users= userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PostMapping("/post")
	public ResponseEntity<User> newUser(@RequestBody User user) {
		log.info("Client invoked post new User");
//		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//		user.setRole(roleRepository.findOne(user.getRole().getId()));
		userService.saveUser(user);		
		log.info("User saved"+user);
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
	
	@GetMapping("/login")
	public String login() {
		log.info("Client invoked login method");
		String password="thomas123";
//		bcrypt.checkPassword(password)
		if(password=="thomas123") {
//		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			return ("<h3>200</h3>");
		}else
		{
		return ("404");
//			return ResponseEntity.status(HttpStatus.valueOf("404")).build();
		}
		
			
	}
	
	@GetMapping("/logout")
	public ResponseEntity<User> logout(){
		log.info("Client invoked logout method");
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	

}
