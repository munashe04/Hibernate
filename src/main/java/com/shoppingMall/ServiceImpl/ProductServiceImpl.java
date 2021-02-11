package com.shoppingMall.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingMall.Converters.ProductConverter;
import com.shoppingMall.Dto.ProductRequestDto;
import com.shoppingMall.Dto.ProductResponseDto;
import com.shoppingMall.Repositories.CartRepository;
import com.shoppingMall.Repositories.ProductRepository;
import com.shoppingMall.Service.ProductService;
import com.shoppingMall.entities.Cart;
import com.shoppingMall.entities.Product;


@Service
public class ProductServiceImpl implements ProductService {
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductConverter conv;
	
	@Autowired
	ProductRepository repo;
	
	@Autowired
	CartRepository cartRepo;
	
	

	@Override
	public ProductResponseDto saveProduct(String id,ProductRequestDto productRequestDto) {
		
		Optional<Cart> cart = cartRepo.findById(id);
		if(cart.isPresent()) {
			Product productToBeSaved = conv.dtoToProduct(productRequestDto);
			productToBeSaved.setCart(cart.get());
			logger.debug("The cart id to be saved for the product is " +id);
			Product productSaved = repo.save(productToBeSaved);
			ProductResponseDto dto = conv.productToDto(productSaved);

			return dto;
		
		}else {
			
		}
		return null;
	}

	@Override
	public List<ProductRequestDto> allProducts() {
		List<Product> products = repo.findAll();
		return null;
	}

	@Override
	public ProductRequestDto deleteProductById(String id) {
		Optional<Product> product = repo.findById(id);
		if(product.isPresent()) {
			repo.deleteById(id);
		}
		return null;
	}

	@Override
	public ProductRequestDto getProductById(String id) {
		Optional<Product> product = repo.findById(id);
		if(product.isPresent()) {
			conv.productToDto(product.get());
		}
		else {
			return null;
		}
		return null;
	}

	@Override
	public ProductRequestDto updateProductById(String id, ProductRequestDto productDto) {
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
