package com.shoppingMall.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingMall.entities.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart,String> {

}
