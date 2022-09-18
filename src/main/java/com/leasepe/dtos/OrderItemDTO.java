package com.leasepe.dtos;



public class OrderItemDTO {
	private int quantity;
	private int productId;

	public OrderItemDTO( int quantity, int productId) {
		this.quantity = quantity;
		this.productId = productId;
	}

	public OrderItemDTO() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
		

	
	@Override
	public String toString() {
		return "OrderItemDTO [quantity=" + quantity + ", productId=" + productId + "]";
	}



}
