package com.shoppingMall.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingMall.Converters.ProductConverter;
import com.shoppingMall.Dto.ProductDto;
import com.shoppingMall.Repositories.ProductRepository;
import com.shoppingMall.Service.ProductService;
import com.shoppingMall.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductConverter conv;
	
	@Autowired
	ProductRepository repo;

	@Override
	public ProductDto saveProduct(Long id, ProductDto productDto) {
		repo.save(conv.dtoToProduct(productDto));
		return productDto ;
	}

	@Override
	public List<ProductDto> allProducts() {
		List<Product> products = repo.findAll();
		return conv.productToDto(products);
	}

	@Override
	public ProductDto deleteProductById(long id) {
		Optional<Product> product = repo.findById(id);
		if(product.isPresent()) {
			repo.deleteById(id);
		}
		return null;
	}

	@Override
	public ProductDto getProductById(long id) {
		Optional<Product> product = repo.findById(id);
		if(product.isPresent()) {
			conv.productToDto(product.get());
		}
		else {
			return null;
		}
		return conv.productToDto(product.get());
	}

	@Override
	public ProductDto updateProductById(long id, ProductDto productDto) {
		Optional<Product> product = repo.findById(id);
		if(product.isPresent()) {
			Product newProduct = new Product();
			conv.productToDto(newProduct);
			repo.save(newProduct);
		}
		else {
			return null;
		}
		return productDto;
		
	}

}
