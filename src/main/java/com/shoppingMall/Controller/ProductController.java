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

import com.shoppingMall.Dto.ProductDto;
import com.shoppingMall.Service.ProductService;

@RestController
@RequestMapping("/ShoppingMall/Products")
public class ProductController {
	 
	 @Autowired
	 ProductService serv;
		
	
	 @PostMapping
	 public void saveEntity( Long id,@RequestBody ProductDto productDto) {
		serv.saveProduct(id,productDto);
	 }
	 
	@GetMapping
	 public List<ProductDto> getAll() {
		return serv.allProducts();
	 }
	 
	 @GetMapping(path ="{id}")
	 public ProductDto getById(@PathVariable ("id") long id){
		 return serv.getProductById(id);
	 }
	 @PutMapping(path ="{id}")
	 public ProductDto updateById(@PathVariable ("id") long id,@RequestBody ProductDto dto) {
		 System.out.println("Controller");
		return serv.updateProductById(id,dto);
	 }
	 @DeleteMapping(path ="{id}")
			 public ProductDto deleteById(@PathVariable ("id") long id){
				return serv.deleteProductById(id);
			 }
}
