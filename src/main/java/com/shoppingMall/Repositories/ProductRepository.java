package com.shoppingMall.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingMall.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>{

}
