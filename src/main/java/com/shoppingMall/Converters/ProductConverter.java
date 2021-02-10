package com.shoppingMall.Converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shoppingMall.Dto.ProductDto;
import com.shoppingMall.entities.Product;

@Component
public class ProductConverter {

	
	public ProductDto productToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setName(product.getName());
		productDto.setId(product.getId());
		productDto.setPrice(product.getPrice());
		//productDto.setCart(product.getCart());
		
		
		return productDto;
	}
	public List<ProductDto>productToDto(List<Product>product){
		return product.stream().map(x -> productToDto(x)).collect(Collectors.toList());
	}
	public Product dtoToProduct(ProductDto productDto) {
		Product product = new Product();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date today = new Date();
		
		product.setName(productDto.getName());
		product.setId(productDto.getId());
		product.setPrice(productDto.getPrice());
		product.setDateOfPurchase(dateFormat.format(today));
		//product.setCart(productDto.getCart());
		
		return product;
	}
	public List<Product>dtoToProduct(List<ProductDto>productDto){
		return productDto.stream().map(x -> dtoToProduct(x)).collect(Collectors.toList());
	}
}
