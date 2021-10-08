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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Users;
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

//	@GetMapping("/hello")
//	public String helloTest() {
//		log.info("Saying Hello from user controller");
//		return "home";
//	}

	@GetMapping("/getusers")
	public ResponseEntity<List<Users>> getAllUsers() {
		log.info("Client invoked get all Users");
		List<Users> users= userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PostMapping("/post")
	public ResponseEntity<Users> newUser(@RequestBody Users user) {
		log.info("Client invoked post new User");
//		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//		user.setRole(roleRepository.findOne(user.getRole().getId()));
		userService.saveUser(user);		
		log.info("User saved"+user);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Users> deleteUser(@RequestBody Users user){
		userService.deleteUser(user);
		return ResponseEntity.status(HttpStatus.valueOf(202)).build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<Users> updateUser(@RequestBody Users user){
		userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getById(@PathVariable("id") int id){
		Users user = userService.getById(id);
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.status(HttpStatus.FOUND).build();
		}
		
	}
	
	@PostMapping("/login")
	public void login(@RequestParam("username") String username) {
		log.info("Client invoked login method");
		System.out.println(username);
		Users user= userService.loadUserByUsername2(username);
		
//		log.info(password);
		System.out.println(user);
//		bcrypt.checkPassword(password)
//		if(password=="thomas123") {
//		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//			return ("<h3>200</h3>");
//		}else
//		{
//		return ("404");
//			return ResponseEntity.status(HttpStatus.valueOf("404")).build();
//		}
		
			
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Users> logout(){
		log.info("Client invoked logout method");
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	

}
