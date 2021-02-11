package com.shoppingMall.Converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shoppingMall.Dto.CartDto;
import com.shoppingMall.entities.Cart;

@Component
public class CartConverter {
	public CartDto cartToDto(Cart cart) {
		CartDto cartDto = new CartDto();
		cartDto.setName(cart.getName());
		cartDto.setId(cart.getId());
		cartDto.setColour(cart.getColour());
		cartDto.setNumberOfWheels(cart.getNumberOfWheels());
		
		return cartDto;
		
	}
	public List<CartDto>cartToDto(List<Cart>cart){
		return cart.stream().map(x -> cartToDto(x)).collect(Collectors.toList());
	}
	public Cart dtoToEntity(CartDto cartDto) {
		Cart cart= new Cart();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date today = new Date();
	
		//cart.setId(1);
		cart.setName(cartDto.getName());
		cart.setNumberOfWheels(cartDto.getNumberOfWheels());
		cart.setColour(cartDto.getColour());
		cart.setDateIssued(dateFormat.format(today));
		
		return cart;
	}
	public List<Cart>dtoToEntity(List<CartDto>cartDto){
		return cartDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
	
