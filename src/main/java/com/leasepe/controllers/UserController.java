package com.leasepe.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leasepe.custom_exception.UserHandlingException;
import com.leasepe.entities.User;
import com.leasepe.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	 Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService uservice;
	public UserController() {
		//System.out.println("In User Controller");
	}
	
	@GetMapping("/{email}/{password}")
	public ResponseEntity<User> findByEmailAndPassword(@PathVariable String email,@PathVariable String password) throws UserHandlingException {
		
		 logger.trace("User controller : findByEmailAndPassword method Accessed");
		User user = uservice.validateUser(email, password);
		if(user == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<User> ValidUser(@RequestBody User user)  throws UserHandlingException{
		
		logger.trace("User controller : ValidUser method Accessed");
		User validuser = uservice.validateUser(user.getEmail(), user.getPassword());
		if(validuser == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(validuser);
	}
	
	@PutMapping("/update/{id}") 
	public ResponseEntity<?> updatePassword(@PathVariable int id, @RequestBody User user) {
		
		logger.trace("User controller : updatePassword method Accessed");
		System.out.println("in update a/c " + user + " " + id);
		return ResponseEntity.ok(uservice.updateAccount(id, user));
	}
	
	@PutMapping("/edit-profile/{id}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int id, @RequestBody User user ) {
		
		logger.trace("User controller : updateUserDetails method Accessed");
		System.out.println("in rest : update details " + id + " " + user);
		return ResponseEntity.ok(uservice.updateUserProfile(id, user));
	}
	
	 @PostMapping("/signup")
	   public ResponseEntity<?> createAccount(@RequestBody User a){
		 
		 logger.trace("User controller : createAccount method Accessed");
		   return ResponseEntity.ok(uservice.SignupCustomerAccount(a));
	   }
	
	
}