package com.productcatalog.productbackend.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.productcatalog.productbackend.model.Deliverable;

public interface DeliverableService {
	public ResponseEntity<HashMap<String, String>> findAllDeliverable(String productId, String pincode);

	public ResponseEntity<Deliverable> addDeveleverable(Deliverable dev);
}
