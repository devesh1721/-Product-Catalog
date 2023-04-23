package com.productcatalog.productbackend.service;

import org.springframework.http.ResponseEntity;

import com.productcatalog.productbackend.model.User;

public interface UserService {

	public ResponseEntity<User> addUser(User user);

	public ResponseEntity<User> findUser(String email);

	public ResponseEntity<Void> deleteUser(String email);

}
