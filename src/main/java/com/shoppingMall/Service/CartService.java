package com.shoppingMall.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingMall.Dto.CartDto;

@Service
public interface CartService {
	
	public CartDto saveCart(Long id,CartDto cartDto);
	public List<CartDto> allCarts();
	public CartDto deleteCartById(Long id);
	public CartDto getCartById(Long id); 
	public CartDto updateCartById(Long id,CartDto cartDto);

} 
