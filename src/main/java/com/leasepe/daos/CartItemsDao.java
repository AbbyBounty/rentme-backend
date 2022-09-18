package com.leasepe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leasepe.entities.Cart;
import com.leasepe.entities.CartItem;

public interface CartItemsDao extends JpaRepository<CartItem, Integer> {

	public List<CartItem> findAllByCart(Cart cart);



	
}

