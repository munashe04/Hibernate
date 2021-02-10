package com.shoppingMall.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingMall.Converters.CartConverter;
import com.shoppingMall.Dto.CartDto;
import com.shoppingMall.Repositories.CartRepository;
import com.shoppingMall.Service.CartService;
import com.shoppingMall.entities.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository repo;
	
	@Autowired
	CartConverter conv;
	

	@Override
	public CartDto saveCart(Long id, CartDto cartDto) {
	repo.save(conv.dtoToEntity(cartDto));
		return null;
	}

	@Override
	public List<CartDto> allCarts() {
		List<Cart>carts = repo.findAll();
		
		return conv.cartToDto(carts) ;
	}

	@Override
	public CartDto deleteCartById(Long id) {
		Optional<Cart> cart = repo.findById(id);
		if(cart.isPresent()) {
			repo.deleteById(id);
		}
		return null;
	}

	@Override
	public CartDto getCartById(Long id) {
		Optional<Cart> cart = repo.findById(id);
		if(cart.isPresent()) {
			conv.cartToDto(cart.get());
		}
		return conv.cartToDto(cart.get());
	}

	@Override
	public CartDto updateCartById(Long id, CartDto cartDto) {
		Optional<Cart> cart = repo.findById(id);
		if(cart.isPresent()) {
			Cart newCart = new Cart();
			conv.cartToDto(newCart);
			repo.save(newCart);
		}
		else {
			return null;
		}
		return cartDto;
	}

}
