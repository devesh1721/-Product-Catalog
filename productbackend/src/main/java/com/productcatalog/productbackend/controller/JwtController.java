package com.productcatalog.productbackend.controller;

import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.productbackend.config.JwtUtil;
import com.productcatalog.productbackend.model.JwtRequest;
import com.productcatalog.productbackend.model.JwtResponse;
import com.productcatalog.productbackend.serviceimpl.UserDeatilsServiceImpl;
import com.productcatalog.productbackend.serviceimpl.UserServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {

	@Autowired
	private UserDeatilsServiceImpl userDeatilsServiceImpl;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	Logger logger = LoggerFactory.getLogger(JwtController.class);

	@PostMapping("/token")
	public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest.getPassword() + jwtRequest.getUsername());
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (Exception e) {
			logger.error("Error" + e);
			throw new Exception("Bad crednitails");
		}

		UserDetails userDetails = this.userDeatilsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));

	}

}
