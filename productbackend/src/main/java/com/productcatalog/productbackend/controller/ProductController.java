package com.productcatalog.productbackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.productbackend.model.Product;
import com.productcatalog.productbackend.serviceimpl.ProductServiceImpl;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/products/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@GetMapping(value = "/detail/{code}")
	public ResponseEntity<Optional<Product>> getProduct(@PathVariable(value = "code") final String code) {
		return this.productService.getProduct(code);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<List<Product>> searchKeyword(@PathVariable(value = "id") final String id) {
		return this.productService.searchProduct(id);
	}

	@PostMapping
	public ResponseEntity<Product> addPorduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(this.productService.saveProduct(product), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProudct() {
		return this.productService.getProductList();
	}
	@GetMapping(value = "price/{code}")
    public ResponseEntity<Map<String,String>> getProductPrice(@PathVariable(value = "code")String code) {
		return this.productService.getProductPrice("code");
	
	}

}
