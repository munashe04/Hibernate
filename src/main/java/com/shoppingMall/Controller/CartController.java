package com.shoppingMall.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingMall.Dto.CartDto;
import com.shoppingMall.Service.CartService;


@RestController
@RequestMapping("ShoppingMall/Cart")
public class CartController {
	 
	 @Autowired
	 CartService serv;
		
	
	 @PostMapping
	 public void saveCart( Long id,@RequestBody CartDto cartDto) {
		serv.saveCart(id,cartDto);
	 }
	 
	@GetMapping
	 public List<CartDto> getAll() {
		return serv.allCarts();
	 }
	 
	 @GetMapping(path ="{id}")
	 public CartDto getById(@PathVariable ("id") Long id){
		 return serv.getCartById(id);
	 }
	 @PutMapping(path ="{id}")
	 public CartDto updateById(@PathVariable ("id") Long id,@RequestBody CartDto cartDto) {
		 System.out.println("Controller");
		return serv.updateCartById(id,cartDto);
	 }
	 @DeleteMapping(path ="{id}")
			 public CartDto deleteById(@PathVariable ("id") Long id){
				return serv.deleteCartById(id);
			 }
	

}
