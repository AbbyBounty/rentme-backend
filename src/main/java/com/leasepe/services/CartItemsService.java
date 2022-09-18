package com.leasepe.services;

import java.util.List;

import com.leasepe.entities.Cart;
import com.leasepe.entities.CartItem;

public interface CartItemsService {
	public Cart findByCartId(int id);

	public void addItemInCart(CartItem cartItem);
	public void addItemsInCart(List<CartItem> cartItems);

	public  List<CartItem> getAllItemOfCart(Cart cart);
}
