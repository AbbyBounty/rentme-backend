package com.leasepe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leasepe.daos.CartItemsDao;
import com.leasepe.entities.Cart;
import com.leasepe.entities.CartItem;

@Service
public class CartItemsImpl implements CartItemsService {

	@Autowired
	CartItemsDao cartItemsDao;
	
	@Override
	public Cart findByCartId(int id) {
		return null;
	}

	@Override
	public void addItemInCart(CartItem cartItem) {
		cartItemsDao.save(cartItem);	
	}
	
	@Override
	public void addItemsInCart(List<CartItem> cartItems) {
		cartItemsDao.saveAll(cartItems);
	}
	
	@Override
	public List<CartItem> getAllItemOfCart(Cart cart) {
		return cartItemsDao.findAllByCart(cart);
	}
}
