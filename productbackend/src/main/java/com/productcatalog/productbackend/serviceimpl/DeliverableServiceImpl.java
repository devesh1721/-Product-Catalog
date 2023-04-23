package com.productcatalog.productbackend.serviceimpl;

import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.Data;

import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.productcatalog.productbackend.model.Deliverable;
import com.productcatalog.productbackend.repositry.DeliverableRepositry;
import com.productcatalog.productbackend.service.DeliverableService;
import com.productcatalog.productbackend.utility.DateConverter;

@Service
public class DeliverableServiceImpl implements DeliverableService {

	@Autowired
	public DeliverableRepositry deliverableRepositry;

	public ResponseEntity<HashMap<String, String>> findAllDeliverable(String productId, String pincode) {
		Deliverable deliverable = deliverableRepositry.findByProductCodeAndPincode(productId, pincode);
		HashMap<String, String> map = new HashMap<>();
		if (deliverable != null) {
			System.out.println(deliverable);
			String date = DateConverter.covertDaysIntoDate(deliverable.getDeliverlyTime());
			System.out.println(date);
			map.put("deliverable", "Develiry by " + date);
			return ResponseEntity.status(HttpStatus.OK).body(map);
		} else {
			map.put("deliverable", "Not develirable");
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}

	}

	public ResponseEntity<Deliverable> addDeveleverable(Deliverable dev) {
		return ResponseEntity.status(HttpStatus.OK).body(deliverableRepositry.save(dev));
	}

}
