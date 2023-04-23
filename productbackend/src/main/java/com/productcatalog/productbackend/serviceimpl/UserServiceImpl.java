package com.productcatalog.productbackend.serviceimpl;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
import org.springframework.stereotype.Service;

import com.productcatalog.productbackend.model.User;
import com.productcatalog.productbackend.repositry.UserRepositry;
import com.productcatalog.productbackend.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositry userRepositry;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public ResponseEntity<User> addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		User userObj = userRepositry.findByEmail(user.getEmail());
		if (userObj != null) {
			header.add("description", "User Alredy Resgister");
			return new ResponseEntity<User>(userObj, header, HttpStatus.OK);
		} else {
			header.add("description", "Data Added Scuessfully");
			userObj = userRepositry.save(user);
		}
		return new ResponseEntity<User>(userObj, header, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<User> findUser(String email) {
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		User userObj = userRepositry.findByEmail(email);
		if (userObj == null) {
			header.add("description", "User Not Found");
			return new ResponseEntity<User>(userObj, header, HttpStatus.NOT_FOUND);
		} else {
			header.add("description", "User Found Scuessfully");
			return new ResponseEntity<User>(userObj, header, HttpStatus.OK);
		}
	}


	@Override
	public ResponseEntity<Void> deleteUser(String email) {
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		try {
			this.userRepositry.deleteById(email);
			return ResponseEntity.status(HttpStatus.OK).build();
		}catch (Exception e) {
			logger.error("Error " + e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
