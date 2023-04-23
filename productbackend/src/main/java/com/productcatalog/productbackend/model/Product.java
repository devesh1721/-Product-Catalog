package com.productcatalog.productbackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Product {

	@Id
	private String code;
	private String name;
	private String brand;
	private String category;
	private String color;
	private int price;
	@Column(length = 600)
	private String detail;
	@Column(length = 600)
	private String imageLink;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Deliverable> deliverable;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<Deliverable> getDeliverable() {
		return deliverable;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", brand=" + brand + ", price=" + price + ", detail="
				+ detail + ", deliverable=" + deliverable + "]";
	}

	public void setDeliverable(List<Deliverable> deliverable) {
		this.deliverable = deliverable;
	}

}
