package com.leasepe.dtos;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.BeanUtils;

import com.leasepe.entities.Cart;
import com.leasepe.entities.CartItem;

public class CartDto {
	int cartId;
	int customerId;
	List<CartItemDto> cartItem ;
	
	{
		this.cartItem = new ArrayList<CartItemDto>();
	}
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDto(int cartId, int customerId, List<CartItemDto> cartItem) {
		this.cartId = cartId;
		this.customerId = customerId;
		this.cartItem = cartItem;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<CartItemDto> getcartItem() {
		return cartItem;
	}

	public void setcartItem(List<CartItemDto> cartItem) {
		this.cartItem = cartItem;
	}
	
	public  void addCartItem( CartItemDto item) {
		this.cartItem.add(item);
	}

	@Override
	public String toString() {
		return "CartDto [cartId=" + cartId + ", customerId=" + customerId + ", cartItem=" + cartItem + "]";
	}
	
	public static CartDto fromEntity(Cart entity) {
		CartDto dto = new CartDto();
		BeanUtils.copyProperties(entity, dto);
		List<CartItem> cartItems = entity.getCartItems();
		cartItems.forEach(item -> {
			CartItemDto itemDto = CartItemDto.fromEntity(item);
			dto.addCartItem(itemDto);
		});	
		return dto;
	}
	

}
