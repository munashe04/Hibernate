package com.shoppingMall;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shoppingMall.entities.Cart;
import com.shoppingMall.entities.Product;

@SpringBootApplication
public class ShoppingMallApplication implements CommandLineRunner {
	

	public static void main(String[] args) {
		SpringApplication.run(ShoppingMallApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cart cart = new Cart();
		
		Product product = new Product();
		List<Product>products = new ArrayList<>();
		cart.setProduct(products);
		cart.getProduct().add(product);
		
		
	}

}
