package com.shoppingMall.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String colour;
	private int numberOfWheels;
	private String dateIssued;
	
	
	@OneToMany(mappedBy = "cart",
				cascade = CascadeType.ALL)
	@Column(nullable = false)
	private List<Product> products = new ArrayList<>();
	
	@JsonManagedReference
	public List<Product> getProduct() {
		return products;
	}
	public void setProduct(List<Product> product) {
		this.products = product;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public String getDateIssued() {
		return dateIssued;
	}
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
	public Cart(Long id, String name, String colour, int numberOfWheels, String dateIssued,List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.numberOfWheels = numberOfWheels;
		this.dateIssued = dateIssued;
		this.products = product;
	}
	public Cart () {
		
	}

}
