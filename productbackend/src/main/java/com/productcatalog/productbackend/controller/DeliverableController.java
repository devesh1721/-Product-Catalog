package com.productcatalog.productbackend.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalog.productbackend.model.Deliverable;
import com.productcatalog.productbackend.service.DeliverableService;

@RestController
@RequestMapping("/deliverable")
@CrossOrigin(origins = "http://localhost:4200")
public class DeliverableController {

	@Autowired
	private DeliverableService deliverableService;

	@GetMapping("/{productId}/{pincode}")
	public ResponseEntity<HashMap<String, String>> getDeliverable(@PathVariable("productId") String productId,
			@PathVariable("pincode") String pincode) {
		return deliverableService.findAllDeliverable(productId, pincode);
	}

	@PostMapping("/")
	public ResponseEntity<Deliverable> addDev(@RequestBody Deliverable deliverable) {
		return this.deliverableService.addDeveleverable(deliverable);
	}

}
