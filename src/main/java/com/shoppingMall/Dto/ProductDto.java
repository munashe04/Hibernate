package com.shoppingMall.Dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.shoppingMall.entities.Cart;



@Component
public class ProductDto {
	
public ProductDto() {
	}

	private long id;
	private String name;
	private double price;
	private Date dateOfPurchase;
	/*private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}*/
	public long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	
}
