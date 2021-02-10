package com.shoppingMall.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingMall.Dto.ProductDto;

@Service
public interface ProductService {

	public ProductDto saveProduct(Long id,ProductDto productDto);
	public List<ProductDto> allProducts();
	public ProductDto deleteProductById(long id);
	public ProductDto getProductById(long id); 
	public ProductDto updateProductById(long id,ProductDto productDto);


}
