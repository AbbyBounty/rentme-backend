package com.leasepe.dtos;

import org.springframework.beans.BeanUtils;

import com.leasepe.entities.OrderItem;


public class OrderItemDTO1 {
	private int oiId ;
	private int orderId ;
	private int productId ;
	private String productName ;
	private int quantity;
	private String productThumbnail;
	
	public OrderItemDTO1() {
	}


	public OrderItemDTO1(int oiId, int orderId, int productId, String productName, int quantity,
			String productThumbnail) {
		this.oiId = oiId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.productThumbnail = productThumbnail;
	}
	
	public int getOiId() {
		return oiId;
	}


	public void setOiId(int oiId) {
		this.oiId = oiId;
	}

	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getProductThumbnail() {
		return productThumbnail;
	}


	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}


	@Override
	public String toString() {
		return "OrderItemDTO1 [oiId=" + oiId + ", productId=" + productId + ", productName="
				+ productName + ", quantity=" + quantity + ", productThumbnail=" + productThumbnail + "]";
	}


	public static OrderItemDTO1 fromEntity(OrderItem orderItem) {
		OrderItemDTO1 orderItemDto = new OrderItemDTO1();
		BeanUtils.copyProperties(orderItem, orderItemDto);
		
		orderItemDto.setOrderId(orderItem.getOrder().getOrderId());
		orderItemDto.setProductId(orderItem.getProduct().getProductId());
		orderItemDto.setProductName(orderItem.getProduct().getProductName());
		orderItemDto.setProductThumbnail(orderItem.getProduct().getProductImage());
		return orderItemDto;
	}

}
