package com.productcatalog.productbackend.serviceimpl;

import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.productcatalog.productbackend.model.Deliverable;
import com.productcatalog.productbackend.model.Product;
import com.productcatalog.productbackend.repositry.DeliverableRepositry;
import com.productcatalog.productbackend.repositry.ProductRepositry;
import com.productcatalog.productbackend.repositry.UserRepositry;
import com.productcatalog.productbackend.service.ProductService;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepositry productRepositry;

	@Autowired
	private DeliverableRepositry devRepositry;

	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	public Product saveProduct(Product product) {

		productRepositry.save(product);
		return product;
	}

	@SuppressWarnings("deprecation")
	public ResponseEntity<Optional<Product>> getProduct(String code) {
		Optional<Product> product = productRepositry.findById(code);
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		if (product.get() == null) {
			httpHeaders.add("description", "Product not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body(product);
		}
		httpHeaders.add("description", "Product found");
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(product);
	}

	@SuppressWarnings("deprecation")
	public ResponseEntity<List<Product>> searchProduct(String keyword) {
		System.out.println(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(productRepositry.findAll(keyword));
	}

	public ResponseEntity<Void> deleteProduct(String id) {
		try {
			productRepositry.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			logger.error("error" + e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	public ResponseEntity<List<Product>> getProductList() {
		return ResponseEntity.status(HttpStatus.OK).body(productRepositry.findAll());
	}

	public ResponseEntity<Product> updateProduct(Product product) {
		return ResponseEntity.status(HttpStatus.OK).body(productRepositry.save(product));
	}

	public ResponseEntity<Map<String, String>> getProductPrice(String code) {
		HashMap<String, String> map = new HashMap<>();
		Optional<Product> product = this.productRepositry.findById(code);
		if (product == null) {
			map.put("prive", "price");
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		map.put("error", "product not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

}
