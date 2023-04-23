package com.productcatalog.productbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.productbackend.model.User;
import com.productcatalog.productbackend.service.UserService;

@RestController
@RequestMapping(value = "/user/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControlller {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/{email}")
	public ResponseEntity<User> getUser(@PathVariable(value = "email") String email) {
		return userService.findUser(email);
	}

	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		System.out.println(user);
		return userService.addUser(user);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value = "email") String email) {
		return userService.deleteUser(email);
	}

	

}
