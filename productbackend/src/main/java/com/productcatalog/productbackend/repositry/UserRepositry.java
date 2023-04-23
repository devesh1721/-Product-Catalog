package com.productcatalog.productbackend.repositry;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcatalog.productbackend.model.User;

@Repository
public interface UserRepositry extends JpaRepository<User, String> {
	public User findByEmail(String email);
}
