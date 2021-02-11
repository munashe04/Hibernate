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

import com.shoppingMall.Dto.ProductRequestDto;
import com.shoppingMall.Service.ProductService;

@RestController
@RequestMapping("/ShoppingMall/Products")
public class ProductController {
	 
	 @Autowired
	 ProductService serv;
		
	
	 @PostMapping(path = "/{id}")
	 public void saveEntity(@PathVariable String id,@RequestBody ProductRequestDto productDto) {
		serv.saveProduct(id, productDto);
	 }
	 
	@GetMapping
	 public List<ProductRequestDto> getAll() {
		return serv.allProducts();
	 }
	 
	 @GetMapping(path ="{id}")
	 public ProductRequestDto getById(@PathVariable ("id") String id){
		 return serv.getProductById(id);
	 }
	 @PutMapping(path ="{id}")
	 public ProductRequestDto updateById(@PathVariable ("id") String id,@RequestBody ProductRequestDto dto) {
		 System.out.println("Controller");
		return serv.updateProductById(id,dto);
	 }
	 @DeleteMapping(path ="{id}")
			 public ProductRequestDto deleteById(@PathVariable ("id") String id){
				return serv.deleteProductById(id);
			 }
}
