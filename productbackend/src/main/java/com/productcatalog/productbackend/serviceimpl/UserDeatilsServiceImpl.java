package com.productcatalog.productbackend.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productcatalog.productbackend.model.User;
import com.productcatalog.productbackend.repositry.UserRepositry;

@Service
public class UserDeatilsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepositry userRepositry;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//		System.out.println("This is the mei" + email);
		com.productcatalog.productbackend.model.User user = userRepositry.findByEmail(email);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("No user found");
		}

	}

}
