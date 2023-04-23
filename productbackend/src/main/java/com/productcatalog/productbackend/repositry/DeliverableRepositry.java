package com.productcatalog.productbackend.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productcatalog.productbackend.model.Deliverable;

@Repository
public interface DeliverableRepositry extends JpaRepository<Deliverable, Integer> {

	Deliverable findByProductCodeAndPincode(String productCode, String pincode);
}
