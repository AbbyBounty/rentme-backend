package com.leasepe.dtos;



import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leasepe.entities.CartItem;

public class CartItemDto {

	int cartItemId;
	int productId;
	int productQuantity;
	@JsonProperty("cart_id")
	private int cartId;
	public CartItemDto() {
		
	}
	
	
	public CartItemDto(int cartItemId, int productId, int productQuantity, int cartId) {
		this.cartItemId = cartItemId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.cartId = cartId;
	}


	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	@Override
	public String toString() {
		return "CartItemDto [cartItemId=" + cartItemId + ", productId=" + productId + ", productQuantity="
				+ productQuantity + ", cartId=" + cartId + "]";
	}
	
	public static CartItemDto fromEntity(CartItem entity ) {
		CartItemDto dto = new CartItemDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setCartId(entity.getCart().getCartId());
		dto.setProductId(entity.getProduct().getProductId());
		return dto;
	}
	

}
