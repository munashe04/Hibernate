package com.shoppingMall.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingMall.Dto.CartDto;

@Service
public interface CartService {
	
	public CartDto saveCart(CartDto cartDto);
	public List<CartDto> allCarts();
	public CartDto deleteCartById(String id);
	public CartDto getCartById(String id); 
	public CartDto updateCartById(String id,CartDto cartDto);

} 
