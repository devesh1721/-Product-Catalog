package com.productcatalog.productbackend.service;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.productcatalog.productbackend.model.Product;

public interface ProductService {
	public ResponseEntity<Optional<Product>> getProduct(String id);

	public ResponseEntity<Void> deleteProduct(String id);

	public ResponseEntity<List<Product>> getProductList();

	public ResponseEntity<Product> updateProduct(Product product);

	public ResponseEntity<Map<String, String>> getProductPrice(String string);
}
