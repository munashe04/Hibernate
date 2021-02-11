package com.shoppingMall.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingMall.Dto.ProductRequestDto;
import com.shoppingMall.Dto.ProductResponseDto;

@Service
public interface ProductService {

	public ProductResponseDto saveProduct(String id,ProductRequestDto productDto);
	public List<ProductRequestDto> allProducts();
	public ProductRequestDto deleteProductById(String id);
	public ProductRequestDto getProductById(String id); 
	public ProductRequestDto updateProductById(String id,ProductRequestDto productDto);


}
