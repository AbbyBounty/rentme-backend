package com.leasepe.dtos;

import java.util.List;



public class OrderDTO {

	private int userId;
	private double total;
	private List<OrderItemDTO> orderItem;
	public OrderDTO() {
	}
	public OrderDTO(int userId, double total, List<OrderItemDTO> orderItem) {
		this.userId = userId;
		this.total = total;
		this.orderItem = orderItem;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<OrderItemDTO> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItemDTO> orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "OrderDTO [userId=" + userId + ", total=" + total + ", orderItem=" + orderItem + "]";
	}
	
}
