package com.productcatalog.productbackend.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalog.productbackend.model.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, String> {

	@Query("SELECT p from Product p WHERE " + "CONCAT(p.code, p.brand,p.name, p.category, p.color,"
			+ "p.price, p.detail)" + "LIKE %?1%")
	public List<Product> findAll(String keyword);

}
